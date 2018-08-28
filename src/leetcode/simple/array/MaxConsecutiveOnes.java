package leetcode.simple.array;

/**
 * @description: 485. 最大连续1的个数
 * @link: <a>https://leetcode-cn.com/problems/max-consecutive-ones/description/</a>
 * @author: guoping wang
 * @date: 2018/8/28 10:02
 * @project: cc-leetcode
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1, 1};
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
    }

    /**
     * 个人常规思路：不断遍历，统计
     * 7ms 95.69%
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}
