package leetcode.simple.array;

/**
 * @description: 724. 寻找数组的中心索引
 * @link: <a>https://leetcode-cn.com/problems/find-pivot-index/description/</a>
 * @author: guoping wang
 * @date: 2018/9/6 9:46
 * @project: cc-leetcode
 */
public class FindPivotIndex {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(new FindPivotIndex().pivotIndex(nums));
    }

    /**
     * 个人常规解法：先算出总和，然后寻找 (最优)
     * 40ms 52.33%
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left == sum - left - nums[i]) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
