package leetcode.simple.array;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @description: 674. 最长连续递增序列
 * @link: <a>https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/description/</a>
 * @author: guoping wang
 * @date: 2018/9/4 10:15
 * @project: cc-leetcode
 */
public class LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {

    }

    /**
     * 个人常规解法：遍历，记录最大的
     * 5ms 87.76%
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int max= 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                count++;
            } else {
                count = 1;
            }

            if (max < count) {
                max = count;
            }
        }

        return max;
    }
}
