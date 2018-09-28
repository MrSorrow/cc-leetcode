package leetcode.simple.string;

/**
 * @description: 541. 反转字符串 II
 * @link: <a>https://leetcode-cn.com/problems/reverse-string-ii/</a>
 * @author: guoping wang
 * @date: 2018/9/28 11:03
 * @project: cc-leetcode
 */
public class ReverseStringII {

    /**
     * 个人常规解法：循环，利用subString
     * 6ms 88.24%
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int parts = s.length() % (2 * k) == 0 ? s.length() / (2 * k) : s.length() / (2 * k) + 1;
        for (int i = 0; i < parts; i++) {
            StringBuilder reverse = null;
            if (2 * k * i + k >= s.length()) {
                reverse = new StringBuilder(s.substring(2 * k * i, s.length())).reverse();
                sb.replace(2 * k * i, s.length(), reverse.toString());
            } else {
                reverse = new StringBuilder(s.substring(2 * k * i, 2 * k * i + k)).reverse();
                sb.replace(2 * k * i, 2 * k * i + k, reverse.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStringII().reverseStr("abcdefg", 1));
    }
}
