package leetcode.mid;

import leetcode.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 22. 括号生成
 * @see: <a>https://leetcode-cn.com/problems/generate-parentheses/</a>
 * @author: guoping wang
 * @date: 2019/1/1 14:31
 * @project: cc-leetcode
 */
public class GenerateParentheses {

    class ParenthesisString {
        String parenthesisString;
        int leftNum;
        int rightNum;

        public ParenthesisString(String parenthesisString, int leftNum, int rightNum) {
            this.parenthesisString = parenthesisString;
            this.leftNum = leftNum;
            this.rightNum = rightNum;
        }
    }


    /**
     * 个人常规解法：简单的动态规划往往后递推
     * 4ms 64,39%
     * @param n
     * @return
     */
    public List<String> generateParenthesisDp(int n) {
        ArrayList<ParenthesisString>[] res = new ArrayList[2 * n + 1];
        ArrayList<ParenthesisString> list = new ArrayList<>();
        list.add(new ParenthesisString("", 0, 0));
        res[0] = list;
        for (int i = 1; i < 2 * n + 1; i++) {
            ArrayList<ParenthesisString> lastList = res[i - 1];
            ArrayList<ParenthesisString> iList = new ArrayList<>();

            for (ParenthesisString s : lastList) {
                if (s.leftNum < n) {
                    iList.add(new ParenthesisString(s.parenthesisString + "(", s.leftNum + 1, s.rightNum));
                }
                if (s.rightNum < s.leftNum) {
                    iList.add(new ParenthesisString(s.parenthesisString + ")", s.leftNum, s.rightNum + 1));
                }
            }

            res[i] = iList;
        }
        ArrayList<String> result = new ArrayList<>(res[2 * n].size());
        for (ParenthesisString string : res[2 * n]) {
            result.add(string.parenthesisString);
        }
        return result;
    }


    /**
     * 参考解法：对个人解法思路的简洁写法，利用函数形参记住状态值
     * 2ms 96.88%
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generateParenthesisCir(new char[2 * n], 0, 0, 0, result);
        return result;
    }

    public void generateParenthesisCir(char[] str, int pos, int leftNum, int rightNum, ArrayList<String> result) {
        if (pos == str.length) {
            result.add(new String(str));
            return;
        }
        if (leftNum < str.length / 2) {
            str[pos] = '(';
            generateParenthesisCir(str, pos + 1, leftNum + 1, rightNum, result);
        }
        if (rightNum < leftNum) {
            str[pos] = ')';
            generateParenthesisCir(str, pos + 1, leftNum, rightNum + 1, result);
        }
    }

    public static void main(String[] args) {
        ListUtils.printLists(new GenerateParentheses().generateParenthesis(3));
    }
}
