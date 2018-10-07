package leetcode.simple.hash;

/**
 * @description: 409. 最长回文串
 * @see: <a>https://leetcode-cn.com/problems/longest-palindrome/</a>
 * @author: guoping wang
 * @date: 2018/10/7 11:15
 * @project: cc-leetcode
 */
public class LongestPalindrome {

    /**
     * 个人常规解法：用数组计数，然后偶数次数直接相加，奇数加一次全额即可
     * 7ms 98.65%
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int[] counter = new int[58];

        for (int i = 0; i < s.length(); i++) {
             counter[s.charAt(i) - 'A']++;
        }

        int res = 0;
        boolean hasAdd = false;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] % 2 == 0) {
                res += counter[i];
            } else {
                if (!hasAdd) {
                    res += counter[i];
                    hasAdd = true;
                } else {
                    res += (counter[i] - 1);
                }
            }
        }
        return res;
    }
}
