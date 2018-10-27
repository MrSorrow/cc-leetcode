package leetcode.simple.math;

import java.util.Arrays;

/**
 * @description: 453. 最小移动次数使数组元素相等
 * @see: <a>https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/</a>
 * @author: guoping wang
 * @date: 2018/10/27 20:34
 * @project: cc-leetcode
 */
public class MinimumMovesToEqualArrayElements {

    /**
     * 个人常规解法：暴力解法
     * 超时
     * @param nums
     * @return
     */
    public int minMovesViolence(int[] nums) {
        if (nums.length == 1) return 0;
        int count = 0;
        Arrays.sort(nums);
        while (nums[0] != nums[nums.length - 1]) {
            for (int i = 0; i < nums.length - 1; i++) {
                nums[i]++;
            }
            Arrays.sort(nums);
            count++;
        }
        return count;
    }

    /**
     * 还是超时
     * 35/84
     * @param nums
     * @return
     */
    public int minMovesViolenceBetter(int[] nums) {
        if (nums.length == 1) return 0;
        int count = 0;
        Arrays.sort(nums);
        while (nums[0] != nums[nums.length - 1]) {
            if (nums[nums.length - 1] != nums[nums.length - 2]) {
                int sub = nums[nums.length - 1] - nums[nums.length - 2];
                for (int i = 0; i < nums.length - 1; i++) {
                    nums[i]+=sub;
                }
                count+=sub;
            } else {
                for (int i = 0; i < nums.length - 1; i++) {
                    nums[i]++;
                }
                Arrays.sort(nums);
                count++;
            }
        }
        return count;
    }

    /**
     * 个人常规解法：发现规律，所有的数字加1就相当于1移动的数字减1，每次减一个数，直到所有的数字减到和最小数相等
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] - nums[0];
        }
        return count;
    }

    /**
     * 减1的优化写法，就不要排序了
     * 7ms 98.83%
     * @param nums
     * @return
     */
    public int minMovesBest(int[] nums) {
        int count = 0;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] - Integer.MIN_VALUE;
            min = min > nums[i] ? nums[i] : min;
        }
        return count - (min - Integer.MIN_VALUE) * nums.length;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new MinimumMovesToEqualArrayElements().minMovesViolence(nums));
    }
}
