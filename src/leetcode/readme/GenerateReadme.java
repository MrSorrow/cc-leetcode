package leetcode.readme;

import java.io.IOException;

/**
 * @description: 生成readme文档
 * @author: guoping wang
 * @date: 2018/9/13 11:03
 * @project: cc-leetcode
 */
public class GenerateReadme {

    public static void main(String[] args) {

        String questionUrlName = "nth-digit";
        String answerPath = "leetcode.simple.math.NthDigit";

        String readmeFilePath = "E:\\eclipse\\cc-leetcode\\Readme.md";

        QuestionInfo questionInfo = null;

        try {
            questionInfo = ReadmeInfoUtil.getQuestionInfoByName(questionUrlName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (questionInfo == null) {
            System.out.println("出错了，没获取到题目信息...");
            return;
        }

        ReadmeQInfo readmeQInfo = ReadmeInfoUtil.buildReadmeQInfo(questionInfo, answerPath);

        ReadmeInfoUtil.updateReadme(readmeFilePath, readmeQInfo);
    }
}
