package leetcode.simple.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * @description: 189. 旋转数组
 * @link: <a>https://leetcode-cn.com/problems/rotate-array/description/</a>
 * @author: guoping wang
 * @date: 2018/8/24 19:05
 * @project: cc-leetcode
 */
public class RotateArray {

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1,2,3,4,5,6,7};
        new RotateArray().rotate(nums, k);
    }

    /**
     * 个人常规解法：原地算法，向左移动
     * 超时 :(
     * @param nums
     * @param k
     */
    public void rotateStill(int[] nums, int k) {
        if (k > nums.length) {
            k %= nums.length;
        }
        for (int i = nums.length - k; i < nums.length; i++) {
            for (int j = i; j > i + k - nums.length; j--) {
                // 交换
                nums[j] = nums[j] + nums[j - 1];
                nums[j - 1] = nums[j] -nums[j - 1];
                nums[j] = nums[j] -nums[j - 1];
            }
        }
    }

    /**
     * 假原地，也就骗骗leetcode
     * 1ms 93.84%
     */
    public void rotateFakeStill(int[] nums, int k) {
        if (k > nums.length) {
            k %= nums.length;
        }
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[(i + nums.length - k) % nums.length];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    /**
     * 最优算法
     * 1ms 93.84%
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k %= nums.length;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        nums[start] = nums[start] + nums[end];
        nums[end] = nums[start] -nums[end];
        nums[start] = nums[start] -nums[end];
        reverse(nums, ++start, --end);
    }
}
