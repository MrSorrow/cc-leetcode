package leetcode.simple.array;

/**
 * @description: 643. 子数组最大平均数 I
 * @link: <a>https://leetcode-cn.com/problems/maximum-average-subarray-i/description/</a>
 * @author: guoping wang
 * @date: 2018/9/2 22:08
 * @project: cc-leetcode
 */
public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        int k = 1;
        int[] nums = {5};
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(nums, k));
    }

    /**
     * 个人常规解法：数组遍历 寻找最大的k个和
     * 17ms 80.24%
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                temp += nums[i];
                max = temp;
            } else {
                temp -= nums[i - k];
                temp += nums[i];
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max * 1.0 / k;
    }
}
