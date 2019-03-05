package leetcode.mid;

/**
 * @description: 518. 零钱兑换 II
 * @see: <a>https://leetcode-cn.com/problems/coin-change-2/</a>
 * @author: guoping wang
 * @date: 2019/3/5 20:55
 * @project: cc-leetcode
 */
public class CoinChangeII {

    /**
     * 个人常规解法：动态规划，选活着不选
     * 7ms 77.11%
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {

        int[] results = new int[amount+1];
        results[0] = 1;  // 这很重要

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                results[j] = results[j] + results[j - coins[i]];
            }
        }
        return results[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int amount = 5;
        System.out.println(new CoinChangeII().change(amount, coins));
    }
}
