package leetcode.simple.array;

/**
 * @author Kingdompin@163.com
 * @link <a>https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/</a>
 * @date 2018/8/23 下午5:25
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfitDp(prices, 0, 1));
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(prices));
    }

    /**
     * 个人解法：（dp or 分治） 选择第一次交易完成时间，最大值为第一次交易时间段的最大值（121题），加上后面时间的最大值（递归）。
     * 超时 199/201 :(
     *
     * @param prices
     * @return
     */
    public int maxProfitDp(int[] prices, int start, int divide) {

        int max = 0;
        for (; divide < prices.length; divide++) {
            int maxFirstValue = maxOneExchangeProfit(prices, start, divide);
            int maxLeftValue = maxProfitDp(prices, divide, divide + 2);
            if (max < maxFirstValue + maxLeftValue) {
                max = maxFirstValue + maxLeftValue;
            }
        }
        return max;
    }

    public int maxOneExchangeProfit(int[] prices, int start, int end) {
        int maxValue = 0;
        int sub = 0;
        for (int i = start + 1; i <= end; i++) {
            sub = prices[i] - prices[start];
            if (sub > maxValue) {
                maxValue = sub;
            }
            if (sub < 0) {
                start = i;
            }
        }
        return maxValue;
    }

    /**
     * 贪心算法
     * 1ms 99.98%
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i+1] > prices[i]) {
                sum += prices[i+1] - prices[i];
            }
        }
        return sum;
    }

}
