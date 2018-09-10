package leetcode.simple.array;

/**
 * @description: 746. 使用最小花费爬楼梯
 * @link: <a>https://leetcode-cn.com/problems/min-cost-climbing-stairs/description/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/10 下午6:26
 * @project: cc-leetcode
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {0, 0, 1, 1};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairsDp(cost, 0));
    }

    /**
     * 个人常规解法：动态规划
     * 超时 :(
     * @param cost
     * @return
     */
    public int minCostClimbingStairsDp(int[] cost, int index) {
        // 递归条件
        if (index == cost.length - 2) {
            return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
        } else if (index == cost.length - 1) {
            return 0;
        }

        // 选择走一步
        int one = minCostClimbingStairsDp(cost, index + 1) + cost[index];
        // 选择走两步
        int two = minCostClimbingStairsDp(cost, index + 2) + cost[index + 1];
        return Math.min(one, two);
    }

    /**
     * 真正的动态规划
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
        }
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }
}
