package sword2offer;

/**
 * @description: 60. n个骰子的点数
 * @see: 《剑指Offer》面试题60 把n个骰子扔在地上，点数之和为s。输入n，打印出s的所有可能值的概率。
 * @author: guoping wang
 * @date: 2019/4/17 21:20
 * @project: cc-leetcode
 */
public class DiceProbability {

    /**
     * 递归解法：当前为n个骰子，n-1个骰子和1个骰子是1-6的均等机会
     * @param n
     * @param s
     * @return
     */
    public static double diceProbability(int n, int s) {
        // 出口条件为当s不符合n个骰子的情况直接返回0，只有1个骰子直接返回1/6
        if (n > s || s > 6 * n) return 0;
        if (n == 1) return 1.0 / 6;

        return (1.0 / 6) *
                 (diceProbability(n - 1, s - 1)
                + diceProbability(n - 1, s - 2)
                + diceProbability(n - 1, s - 3)
                + diceProbability(n - 1, s - 4)
                + diceProbability(n - 1, s - 5)
                + diceProbability(n - 1, s - 6));
    }

    /**
     * 动态规划：每多1个骰子，都是上面情况的新增
     * @param n
     * @return
     */
    public static void diceProbabilityDp(int n) {
        double[][] res = new double[2][6 * n];  // 第一行保存上一次的值，第二行保存下一次的值

        for (int i = 0; i < 6; i++) {
            res[1][i] = 1.0 / 6;
        }

        if (n == 1) return;  // 如果n=1，直接返回即可，结果保存在res[n % 2]中;

        // n >= 2
        for (int i = 2; i <= n; i++) {
            // 第i个骰子过来，从i-1的状态转移到i
            for (int j = (i - 1) - 1; j <= 6 * (i - 1) - 1; j++) {
                // 第i个骰子6种情况
                for (int k = 1; k <= 6; k++) {
                    res[i % 2][j + k] += res[(i - 1) % 2][j] / 6;
                }
            }
            // 第i个骰子清零
            for (int j = (i - 1) - 1; j <= 6 * (i - 1) - 1; j++) {
                res[(i - 1) % 2][j] = 0;
            }

        }

        // 打印结果
        double sum = 0;
        for (int j = n- 1; j <= 6 * n - 1; j++) {
            System.out.println((j + 1) + " : " + res[n % 2][j]);
            sum += res[n % 2][j];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
//        System.out.println(DiceProbability.diceProbability(7, 9));
        DiceProbability.diceProbabilityDp(7);
    }
}
