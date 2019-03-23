package readme;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 剑指Offer题解表格生成readme
 * @author: guoping wang
 * @date: 2019/3/23 12:07
 * @project: cc-leetcode
 */
public class Sword2OfferGenerateReadme {

    public static void main(String[] args) {
        String questionId = "3";
        String questionName = "数组中重复的数字";
        String questionUrl = "https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8";
        String answerPath = "sword2offer.UniqueNumInArray";

        String readmeFilePath = "E:\\eclipse\\cc-leetcode\\Readme.md";
        String tableName = "剑指Offer Solution Table";

        Sword2OfferQInfo questionInfo = null;
        questionInfo = buildQuestionInfoByUrl(questionId, questionName, questionUrl, answerPath);

        if (questionInfo == null) {
            System.out.println("[Error]\t出错了，构建题目信息出错...");
            return;
        }

        updateReadme(readmeFilePath, questionInfo, tableName);
    }

    private static void updateReadme(String filePath, Sword2OfferQInfo questionInfo, String tableName) {
        File readmeFile = new File(filePath);

        // 构造插入数据内容
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("| ");
        stringBuilder.append(questionInfo.getQuestionId());
        stringBuilder.append("    | ");
        stringBuilder.append(questionInfo.getQuestionTitle());
        stringBuilder.append(" | ");
        stringBuilder.append(questionInfo.getAnswerAddress());
        stringBuilder.append(" | ");
        stringBuilder.append(questionInfo.getDate());
        stringBuilder.append(" |");

        int lineNum = FileInsertRow.checkInsertPosition(Integer.valueOf(questionInfo.getQuestionId()), readmeFile, tableName);
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
     * 根据输入信息构建题解表格的一行
     * @param questionId id
     * @param questionName 题目名称
     * @param questionUrl 题目路径
     * @param answerPath 题解路径
     * @return
     */
    private static Sword2OfferQInfo buildQuestionInfoByUrl(String questionId, String questionName, String questionUrl, String answerPath) {
        Sword2OfferQInfo sword2OfferQInfo = new Sword2OfferQInfo();
        sword2OfferQInfo.setQuestionId(questionId);
        sword2OfferQInfo.setQuestionTitle("[" + questionName + "](" + questionUrl + ")");
        sword2OfferQInfo.setAnswerAddress("[Java](" + LeetcodeReadmeInfoUtil.parseAnswerPath(answerPath) + ")");
        sword2OfferQInfo.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return sword2OfferQInfo;
    }


}
