package leetcode.mid;

/**
 * @description: 50. Pow(x, n)
 * @see: <a>https://leetcode-cn.com/problems/powx-n/</a>
 * @author: guoping wang
 * @date: 2019/1/8 22:21
 * @project: cc-leetcode
 */
public class PowxN {

    /**
     * 个人常规解法：递归乘
     * 12ms 91.81%
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
            if (-n == Integer.MIN_VALUE) {
                return x * myPow(x, (n - 1));
            }
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public double myPowApi(double x, int n) {
        return Math.pow(x, n);
    }
}
