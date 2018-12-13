package leetcode.simple.other;

/**
 * @description: 479. 最大回文数乘积
 * @see: <a>https://leetcode-cn.com/problems/largest-palindrome-product/</a>
 * @author: guoping wang
 * @date: 2018/12/13 10:26
 * @project: cc-leetcode
 */
public class LargestPalindromeProduct {

    /**
     * 个人常规解法：暴力解法，对于乘数进行暴力
     * @param n
     * @return
     */
    public int largestPalindromeTimeOut(int n) {
        int[] numsUp = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999};
        int[] numsDown = {1, 90, 900, 9000, 90000, 900000, 9000000, 90000000};

        int max = 0;
        int num1 = numsUp[n - 1], num2 = numsDown[n - 1];
        for (int i = num1; i >= num2; i--) {
            for (int j = num1; j >= num2; j--) {
                if (isPalindrome(i * j)) {
                    max = Math.max(i * j, max);
                }
            }
        }
        return max % 1337;
    }

    private boolean isPalindrome(int i) {
        StringBuilder sb = new StringBuilder(i+"");
        return sb.reverse().toString().equals(sb.reverse().toString());
    }

    /**
     * 暴力解法2：对于回文数进行逆序暴力==>关键在于怎么组装回文数
     * 406ms 78.13%
     * @param n
     * @return
     */
    public int largestPalindrome(int n) {
        int up = (int) (Math.pow(10, n) - 1), down = (int) (Math.pow(10, n - 1));
        for (int i = up; i >= down; i--) {
            // 组装递减的回文数
            StringBuilder sb = new StringBuilder(i + "");
            long num = Long.valueOf(i + "" + sb.reverse().toString());

            // 判断该回文数是否能被整除
            for (long j = up; j * j > num; --j) {
                if (num % j == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return 9;
    }

    public static void main(String[] args) {
        System.out.println(new LargestPalindromeProduct().largestPalindrome(5));
    }
}
