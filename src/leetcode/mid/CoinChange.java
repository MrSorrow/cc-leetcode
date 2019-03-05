package leetcode.mid;

import leetcode.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @description: 322. 零钱兑换
 * @see: <a>https://leetcode-cn.com/problems/coin-change/</a>
 * @author: guoping wang
 * @date: 2019/3/5 21:09
 * @project: cc-leetcode
 */
public class CoinChange {

    /**
     * 个人常规解法：动态规划，明确状态转移
     * 示例： coins [2, 3, 5] amount 5
     * -------------------------------------------------------------------------------------------------------------------------------
     * |      |  0   |          1           |         2          |          3          |          4           |           5          |
     * -------------------------------------------------------------------------------------------------------------------------------
     * |  0   |  0   |          -1          |         -1         |         -1          |          -1          |          -1          |
     * -------------------------------------------------------------------------------------------------------------------------------
     * |  2   |  0   | (-1, 2)+1, (1, 0)=-1 | (0, 2)+1, (2, 0)=1 | (1, 2)+1, (3, 0)=-1 |  (2, 2)+1, (4, 0)=2  |  (3, 2)+1, (5, 0)=-1 |
     * -------------------------------------------------------------------------------------------------------------------------------
     * |  3   |  0   |                      |                    |                     |                      |                      |
     * -------------------------------------------------------------------------------------------------------------------------------
     * |  5   |  0   |                      |                    |                     |                      |                      |
     * -------------------------------------------------------------------------------------------------------------------------------
     * 60ms 19.45%
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[][] results = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < results.length; i++) {
            for (int j = 1; j < results[0].length; j++) {
                if (i == 0) results[i][j] = -1;  // 第一行赋值为-1
                else {
                    // 利用递推关系进行赋值 results[i][j] = min(results[i][j - coins[i]], results[i - 1][j])
                    int choose = -1;  // 如果选择，背包减少，加1放在后面
                    if (j - coins[i - 1] >= 0) choose = results[i][j - coins[i - 1]];

                    int drop = results[i - 1][j];  // 如果不选择，背包不变，状态转移到上一层

                    if (choose > -1 && drop > -1) {
                        results[i][j] = Math.min(choose + 1, drop);
                    } else if (choose > -1 && drop <= -1) {
                        results[i][j] = choose + 1;
                    } else if (choose <= -1 && drop > -1) {
                        results[i][j] = drop;
                    } else {
                        results[i][j] = -1;
                    }
                }
            }
        }
//        ArrayUtils.printInt2DArray(results);
        return results[coins.length][amount];
    }

    /**
     * 参考解法：一维数组即可，初始可以不用-1， 等到最后再判断是否是-1
     * 34ms 77.16%
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeBetter(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) return 0;
        int[] results = new int[amount+1];
        Arrays.fill(results, amount + 1); // 初始化足够大的数
        results[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                results[j] = Math.min(results[j - coins[i]] + 1, results[j]);
            }
        }

        return results[amount] <= amount ? results[amount] : -1;
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {2, 3, 5};
        System.out.println(new CoinChange().coinChange(coins, amount));
    }
}
