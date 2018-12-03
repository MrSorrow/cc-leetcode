package leetcode.simple.array;

/**
 * @description: 70. 爬楼梯
 * @see: <a>https://leetcode-cn.com/problems/climbing-stairs/</a>
 * @author: guoping wang
 * @date: 2018/12/3 13:07
 * @project: cc-leetcode
 */
public class ClimbingStairs {

    /**
     * 个人常规解法：递归超时，所以需要动归
     * @param n
     * @return
     */
    public int climbStairsCir(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 个人常规解法：动态规划
     * 2ms 100%
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}
