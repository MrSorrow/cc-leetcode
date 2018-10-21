package leetcode.simple.math;

/**
 * @description: 9. 回文数
 * @see: <a>https://leetcode-cn.com/problems/palindrome-number/</a>
 * @author: guoping wang
 * @date: 2018/10/21 21:15
 * @project: cc-leetcode
 */
public class PalindromeNumber {

    /**
     * 个人常规解法：和回文子串很相似
     * 164ms 72.83%
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        char[] strs = String.valueOf(x).toCharArray();
        for (int i = 0; i < strs.length / 2; i++) {
            if (strs[i] != strs[strs.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 个人常规解法：字符串反序
     * 159ms 78.11%
     * @param x
     * @return
     */
    public boolean isPalindromeString(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    /**
     * 最好的算法
     * @param x
     * @return
     */
    public boolean isPalindromeBest(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int s = 0;
        while (s <= x) {
            s = s * 10 + x % 10;
            if (s == x || s == x / 10) {
                return true;
            }
            x /= 10;
        }
        return false;
    }
}
