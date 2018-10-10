package leetcode.simple.hash;

import java.util.Arrays;

/**
 * @description: 594. 最长和谐子序列
 * @see: <a>https://leetcode-cn.com/problems/longest-harmonious-subsequence/</a>
 * @author: guoping wang
 * @date: 2018/10/9 10:41
 * @project: cc-leetcode
 */
public class LongestHarmoniousSubsequence {

    /**
     * 个人常规解法：题目非连续最长和谐子序列，所以直接排序
     * 38ms 97.77%
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        // 先排序
        Arrays.sort(nums);

        if (nums.length == 0 || nums[0] == nums[nums.length - 1]) {
            return 0;
        }

        // 最大值
        int res = 0;
        // 中间所有值
        int count = 0;

        int start = 0;
        int nextStart = 0;
        int end = 0;

        // 标记是否有大于1的数字
        boolean flag = false;
        for (; ;) {
            if (end >= nums.length) {
                // count至少大于1才算有子序列，否则就是自身
                if (count > 1 && count > res) {
                    res = count;
                }
                break;
            }
            if (nums[end] == nums[start]) {
                count++;
                end++;
            } else if (nums[end] - nums[start] == 1) {
                count++;
                if (!flag) {
                    nextStart = end;
                }
                end++;
                flag = true;
            } else if (nums[end] - nums[start] > 1) {
                // 并没有经过第二种情况就直接下一组
                if (!flag) {
                    nextStart = end;
                    count = 0;
                }
                start = nextStart;
                flag = false;
                end = start;
                if (count > 1 && count > res) {
                    res = count;
                }
                count = 0;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,11,13,15,17};
        System.out.println(new LongestHarmoniousSubsequence().findLHS(nums));
    }
}
