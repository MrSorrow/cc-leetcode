package leetcode.mid;

/**
 * @description: 712. 两个字符串的最小ASCII删除和
 * @see: <a>https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/</a>
 * @author: guoping wang
 * @date: 2019/4/29 22:50
 * @project: cc-leetcode
 */
public class MinimumAsciiDeleteSumForTwoStrings {

    /**
     * 个人常规解法：动态规划，这类字符串公共部分通常就是列举一个表格
     * 例如s1 = "delete", s2 = "leet"
     * 表格就是下方的形式
     *   d e l e t e
     * l
     * e
     * e
     * t
     *
     * dp表格形式为dp[i][j]，i代表是s1的字母位置，j代表s2的字母位置，dp[i][j]代表公共的ASCII码
     * 状态转移方程是：
     *     如果是字母相等，则dp[i][j] = dp[i - 1][j - 1] + 当前字母的ASCII码
     *     不相等，则dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
     * 20ms 98.39%
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSumDp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int sum = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            sum += s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            sum += s2.charAt(i);
        }
        return sum - 2 * dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "delete";
        String s2 = "leet";
        System.out.println(new MinimumAsciiDeleteSumForTwoStrings().minimumDeleteSumDp(s1, s2));
    }

}
