package leetcode.simple.string;

/**
 * @description: 58. 最后一个单词的长度
 * @link: <a>https://leetcode-cn.com/problems/length-of-last-word/</a>
 * @author: guoping wang
 * @date: 2018/9/25 13:37
 * @project: cc-leetcode
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("b "));
        System.out.println(new LengthOfLastWord().lengthOfLastWordReverse("b "));
    }

    /**
     * 个人常规解法：遍历寻找到最后一个单词计数O(N)
     * 5ms 70.55%
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (s.charAt(i) == ' ' && i != s.length() - 1) {
                count = 0;
            }
        }
        return count;
    }

    /**
     * 个人常规解法：倒序
     * 3ms 99.95%
     * @param s
     * @return
     */
    public int lengthOfLastWordReverse(String s) {
        s = s.trim();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }
}
