package readme;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @description: 工具类
 * @author: guoping wang
 * @date: 2018/9/13 13:13
 * @project: cc-leetcode
 */
public class LeetcodeReadmeInfoUtil {

    private static final String questionUrl = "https://leetcode-cn.com/problemset/algorithms/";
    private static final String graphqlUrl = "https://leetcode-cn.com/graphql";
    private static final String repositoryUrl = "https://github.com/MrSorrow/cc-leetcode/blob/master/src/";
    private static final String chineseQuestionUrl = "https://leetcode-cn.com/problems/translatedTitle/description/";
    private static final String englishQuestionUrl = "https://leetcode.com/problems/questionTitle/description/";

    /**
     * 根据leetcode-cn题目url地址的名称返回题目信息<br/>
     * 比如：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/description/
     * @param questionUrlName 参数就为1-bit-and-2-bit-characters
     * @return
     * @throws IOException
     */
    public static LeetcodeQuestionInfo getQuestionInfoByName(String questionUrlName) throws IOException {
        Connection.Response response = Jsoup.connect(questionUrl)
                .method(Connection.Method.GET)
                .execute();

        Map<String, String> cookies = response.cookies();
        String csrftoken = response.cookie("csrftoken");
        String __cfduid = response.cookie("__cfduid");

        OkHttpClient client = new OkHttpClient.Builder()
                .followRedirects(false)
                .followSslRedirects(false)
                .build();

        String postBody = "query{\n" +
                "  question(titleSlug:\"" + questionUrlName + "\") {\n" +
                "    questionId\n" +
                "    questionFrontendId\n" +
                "    questionTitle\n" +
                "    questionTitleSlug\n" +
                "    translatedTitle\n" +
                "    difficulty\n" +
                "  }\n" +
                "}\n";

        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/graphql")
                .addHeader("Referer", questionUrl)
                .addHeader("accept-language", "zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("Cookie", "__cfduid=" + __cfduid + ";" + "csrftoken=" + csrftoken)
                .addHeader("x-csrftoken", csrftoken)
                .url(graphqlUrl)
                .post(RequestBody.create(MediaType.parse("application/graphql; charset=utf-8"), postBody))
                .build();

        Response response1 = client.newCall(request).execute();
        String json = response1.body().string();
        Gson gson = new Gson();
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(json);
        LeetcodeQuestionInfo questionInfo = gson.fromJson(jsonObject.get("data").getAsJsonObject().get("question").getAsJsonObject(), LeetcodeQuestionInfo.class);
        System.out.println(gson.toJson(questionInfo));
        return questionInfo;
    }

    /**
     * 构造readme写入内容
     * @param questionInfo
     * @param answerPath
     * @return
     */
    public static LeetcodeReadmeQInfo buildReadmeQInfo(LeetcodeQuestionInfo questionInfo, String answerPath) {

        LeetcodeReadmeQInfo readmeQInfo = new LeetcodeReadmeQInfo();
        String translatedTitle = "[" + questionInfo.getTranslatedTitle() + "](" + parseTranslatedTitle(questionInfo.getQuestionTitleSlug()) + ")";
        readmeQInfo.setTranslatedTitle(translatedTitle);
        String questionTitle = "[" + questionInfo.getQuestionTitle() + "](" + parseQuestionTitle(questionInfo.getQuestionTitleSlug()) + ")";
        readmeQInfo.setQuestionTitle(questionTitle);
        String answerUrl = "[Java](" + parseAnswerPath(answerPath) + ")";
        readmeQInfo.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        readmeQInfo.setAnswerAddress(answerUrl);

        readmeQInfo.setQuestionTitleSlug(questionInfo.getQuestionTitleSlug());
        readmeQInfo.setDifficulty(questionInfo.getDifficulty());
        readmeQInfo.setQuestionId(questionInfo.getQuestionId());
        readmeQInfo.setQuestionFrontendId(questionInfo.getQuestionFrontendId());
        return readmeQInfo;

    }

    /**
     * 根据类名转换为访问路径
     * @param answerPath 类全名 leetcode.simple.sort.IntersectionOfTwoArrays
     * @return 路径 leetcode/simple/sort/IntersectionOfTwoArrays.java
     */
    public static String parseAnswerPath(String answerPath) {
        return repositoryUrl + answerPath.replace(".", "/") + ".java";
    }

    /**
     * 根据中文题目转换为访问路径
     * @param translatedTitle
     * @return
     */
    public static String parseTranslatedTitle(String translatedTitle) {
        return chineseQuestionUrl.replace("translatedTitle", translatedTitle);
    }

    /**
     * 根据英文题目转换为访问路径
     * @param questionTitle
     * @return
     */
    public static String parseQuestionTitle(String questionTitle) {
        return englishQuestionUrl.replace("questionTitle", questionTitle);
    }

    /**
     * 更新readme
     * @param filePath
     * @param readmeQInfo
     */
    public static void updateReadme(String filePath, LeetcodeReadmeQInfo readmeQInfo, String tableName) {
        File readmeFile = new File(filePath);

        // 构造插入数据内容
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("| ");
        stringBuilder.append(readmeQInfo.getQuestionFrontendId());
        stringBuilder.append("    | ");
        stringBuilder.append(readmeQInfo.getTranslatedTitle());
        stringBuilder.append(" | ");
        stringBuilder.append(readmeQInfo.getQuestionTitle());
        stringBuilder.append(" | ");
        stringBuilder.append(readmeQInfo.getDifficulty());
        stringBuilder.append("       | ");
        stringBuilder.append(readmeQInfo.getAnswerAddress());
        stringBuilder.append(" | ");
        stringBuilder.append(readmeQInfo.getDate());
        stringBuilder.append(" |");

        int lineNum = checkInsertPosition(readmeQInfo.getQuestionFrontendId(), readmeFile, tableName);
        if (lineNum == -1) {
            System.out.println("[Error]\t更新失败，插入行号获取错误！");
            return;
        } else if (lineNum == -2) {
            System.out.println("[Info]\t已经存在该题解，无需更新！");
            return;
        }

        try {
            FileInsertRow.insertStringInFile(readmeFile, lineNum, stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查插入位置
     * @return
     */
    private static int checkInsertPosition(String id, File inFile, String tableName) {
        return FileInsertRow.checkInsertPosition(Integer.valueOf(id), inFile, tableName);
    }
}
