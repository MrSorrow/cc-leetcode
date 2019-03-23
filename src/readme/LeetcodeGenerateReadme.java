package readme;

import java.io.IOException;

/**
 * @description: LeetCode题解表格生成readme文档
 * @author: guoping wang
 * @date: 2018/9/13 11:03
 * @project: cc-leetcode
 */
public class LeetcodeGenerateReadme {

    public static void main(String[] args) {

        String questionUrlName = "binary-tree-right-side-view";
        String answerPath = "leetcode.mid.BinaryTreeRightSideView";

        String readmeFilePath = "E:\\eclipse\\cc-leetcode\\Readme.md";
        String tableName = "LeetCode Solution Table";

        LeetcodeQuestionInfo questionInfo = null;

        try {
            questionInfo = LeetcodeReadmeInfoUtil.getQuestionInfoByName(questionUrlName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (questionInfo == null) {
            System.out.println("[Error]\t出错了，没获取到题目信息...");
            return;
        }

        LeetcodeReadmeQInfo readmeQInfo = LeetcodeReadmeInfoUtil.buildReadmeQInfo(questionInfo, answerPath);

        LeetcodeReadmeInfoUtil.updateReadme(readmeFilePath, readmeQInfo, tableName);
    }
}
