package leetcode.simple.array;

/**
 * @author Kingdompin@163.com
 * @link <a>https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/</a>
 * @date 2018/7/29 下午4:15
 */
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {

		int[] prices = {7,1,5,3,6,4};
		System.out.println(new BestTimeToBuyAndSellStock().maxProfitDp(prices , 0));
		System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
	}

	/**
	 * 个人解法：（dp or 分治） 如果在第一天买入，则寻找最大差价；如果没有第一天买，则递归
	 * 131ms 23.61%
	 * @param prices
	 * @return
	 */
	public int maxProfitDp(int[] prices, int start) {
		// 递归结束
		if (start >= prices.length - 1) {
			return 0;
		}

		// 第一天没有买，递归
		int maxNot = maxProfitDp(prices, start + 1);

		// 第一天买了，求最大差
		int maxYes = 0;
		int maxSub = 0;
		for (int i = start + 1; i < prices.length; i++) {
			maxSub = prices[i] - prices[start];
			if (maxYes < maxSub) {
				maxYes = maxSub;
			}
		}
		return maxYes > maxNot ? maxYes : maxNot;
	}

	/**
	 * 个人解法：买入的那天如果后面遇见价格更低的 肯定要重新选择 买入价格更低的那天 作为新的买入进行继续向后算
	 * 1ms 99.92%
	 */
	public int maxProfit(int[] prices) {
		int maxValue = 0;
		int sub = 0, start = 0;
		for (int i = 1; i < prices.length; i++) {
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

}
