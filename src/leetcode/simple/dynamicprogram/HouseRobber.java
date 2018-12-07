package leetcode.simple.dynamicprogram;

/**
 * @description: 198. 打家劫舍
 * @see: <a>https://leetcode-cn.com/problems/house-robber/</a>
 * @author: guoping wang
 * @date: 2018/12/7 22:05
 * @project: cc-leetcode
 */
public class HouseRobber {

    /**
     * 个人常规解法：动态规划，关键在于如何记录中间值
     * 3ms 99.96%
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[][] res = new int[nums.length + 1][2];
        for (int i = 0; i < nums.length; i++) {
            // 选择当前的元素
            res[i + 1][0] = res[i][1] + nums[i];
            // 不选择当前的元素
            res[i + 1][1] = Math.max(res[i][0], res[i][1]);
        }
        return Math.max(res[nums.length][0], res[nums.length][1]);
    }

    /**
     * 个人常规解法：递归超时
     * 56/69
     * @param nums
     * @return
     */
    public int robCir(int[] nums) {
        if (nums.length == 0) return 0;
        return Math.max(nums[0] + robCir(nums, 2), robCir(nums, 1));
    }

    public int robCir(int[] nums, int start) {
        if (start >= nums.length) return 0;
        return Math.max(nums[start] + robCir(nums, start + 2), robCir(nums, start + 1));
    }
}
