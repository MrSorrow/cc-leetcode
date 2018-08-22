package leetcode.simple.array;

/**
 * @author Kingdompin@163.com
 * @link <a>https://leetcode-cn.com/problems/maximum-subarray/description/</a>
 * @date 2018/7/29 下午3:03
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-3, -2, 0, -1};
        System.out.println(new MaxSubArray().maxSubArrayBest(nums));
        System.out.println(new MaxSubArray().maxSubArrayDivideAndConquer(nums, 0, nums.length - 1));
        System.out.println(new MaxSubArray().maxSubArrayDynamic(nums, 0));
    }

    /**
     * 暴力解法 超时……
     */
    public int maxSubArrayViolence(int[] nums) {

        int max = nums[0];

        // 最外层表示几个数字连在一起
        for (int i = 1; i <= nums.length; i++) {
            // 第二层表示那里开始画框
            for (int j = 0; j <= nums.length - i; j++) {
                int sum = 0;
                // 求框内数字和
                for (int k = j; k < i + j; k++) {
                    sum += nums[k];
                }
                if (max < sum) {
                    max = sum;
                }
            }
        }

        return max;
    }

    /**
     * 自己解法——关键在于怎么画框
     * 优化的暴力解法 103ms 4.27%
     */
    public int maxSubArrayBetterViolence(int[] nums) {
        int max = nums[0];
        // 最外层表示框的起点
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            // 框不断地扩大，顺便求了和
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 分治算法，数组一分为二，最大连续子序列和出现位置分三种情况进行递归
     * 24ms 36.14%
     */
    public int maxSubArrayDivideAndConquer(int[] nums, int left, int right) {

        // 递归结束
        if (left == right) {
            return nums[left];
        }

        // 切分数组
        int center = (left + right) / 2;

        // 分别求左边和右边最大
        int maxLeft = maxSubArrayDivideAndConquer(nums, left, center);
        int maxRight = maxSubArrayDivideAndConquer(nums, center + 1, right);

        // 求中间最大
        int maxCenter = nums[center] + nums[center + 1];
        int sum = maxCenter;
        for (int i = center + 2; i <= right; i++) {
            sum += nums[i];
            if (maxCenter < sum) {
                maxCenter = sum;
            }
        }
        sum = maxCenter;
        for (int i = center - 1; i >= left; i--) {
            sum += nums[i];
            if (maxCenter < sum) {
                maxCenter = sum;
            }
        }

        return (maxLeft > maxRight ? maxLeft : maxRight) > maxCenter ? (maxLeft > maxRight ? maxLeft : maxRight) : maxCenter;
    }

    /**
     * 动态规划
     * 106ms 4.01%
     */
    public int maxSubArrayDynamic(int[] nums, int start) {
        if (start == nums.length - 1) {
            return nums[start];
        }

        // 最大子序列不包含start的元素
        int maxNotInclude = maxSubArrayDynamic(nums, start + 1);

        // 最大子序列包含start位置元素
        int maxInclude = nums[start];
        int sum = maxInclude;
        for (int i = start + 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxInclude) {
                maxInclude = sum;
            }
        }

        return maxNotInclude > maxInclude ? maxNotInclude : maxInclude;
    }


    /**
     * 任何负的子序列不可能作为最大连续子序列的前缀，需要重新开始截取
     * 11ms 96.43%
     */
    public int maxSubArrayBest(int[] a) {
        int maxSum = a[0], sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
