package leetcode.simple.math;

/**
 * @description: 326. 3的幂
 * @see: <a>https://leetcode-cn.com/problems/power-of-three/</a>
 * @author: guoping wang
 * @date: 2018/10/24 18:32
 * @project: cc-leetcode
 */
public class PowerOfThree {

    /**
     * 个人常规解法：能被3整除就一直除以3
     * 78ms 31.83%
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        while (n > 2 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(243));
    }
}
