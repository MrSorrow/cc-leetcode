package leetcode.simple.string;

/**
 * @description: 521. 最长特殊序列 Ⅰ
 * @link: <a>https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/</a>
 * @author: guoping wang
 * @date: 2018/9/28 10:21
 * @project: cc-leetcode
 */
public class LongestUncommonSubsequenceI {

    /**
     * 个人常规解法：题目的意思要找两个字符串中最长的特殊序列，其实只要本身不相等最长的就是两个字符串中更长的那个
     * 2ms 100%
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() > b.length() ? a.length() : b.length();
        }
        if (a.equals(b)) {
            return -1;
        } else {
            return a.length();
        }
    }
}
