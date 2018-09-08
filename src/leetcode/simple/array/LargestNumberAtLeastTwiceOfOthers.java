package leetcode.simple.array;

/**
 * @description: 747. 至少是其他数字两倍的最大数
 * @link: <a>https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/description/</a>
 * @author: guoping wang
 * @date: 2018/9/8 0:46
 * @project: cc-leetcode
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1};
        System.out.println(new LargestNumberAtLeastTwiceOfOthers().dominantIndex(nums));
    }

    /**
     * 个人解法：寻找最大值和第二大
     * 13ms 53.87%
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int maxIndex = 0, secondMax = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                secondMax = nums[maxIndex];
                maxIndex = i;
            }else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }

        if (nums[maxIndex] >= 2 * secondMax) {
            return maxIndex;
        }

        return -1;
    }


}
