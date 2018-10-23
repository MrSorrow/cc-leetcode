package leetcode.simple.math;

/**
 * @description: 172. 阶乘后的零
 * @see: <a>https://leetcode-cn.com/problems/factorial-trailing-zeroes/</a>
 * @author: guoping wang
 * @date: 2018/10/23 13:30
 * @project: cc-leetcode
 */
public class FactorialTrailingZeroes {

    /**
     * 数学推导：拥有递推公式
     * f(n!) = f(n/5 !) + n/5
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        return trailingZeroes(n / 5) + n / 5;
    }

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(30));
    }
}
