package leetcode.simple.array;

/**
 * @description: 509. 斐波那契数
 * @see: <a>https://leetcode-cn.com/problems/fibonacci-number/</a>
 * @author: guoping wang
 * @date: 2019/3/17 18:20
 * @project: cc-leetcode
 */
public class FibonacciNumber {

    /**
     * 个人常规解法：递推，动态规划
     * @param N
     * @return
     */
    public int fib(int N) {
        int[] fibs = new int[N + 1];
        fibs[0] = 0;
        if (N >= 1) {
            fibs[1] = 1;
        }
        for (int i = 2; i <= N; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
        return fibs[N];
    }
}
