package leetcode.simple.array;

import java.util.Arrays;

/**
 * @description: 581. 最短无序连续子数组
 * @link: <a>https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/description/</a>
 * @author: guoping wang
 * @date: 2018/8/30 9:55
 * @project: cc-leetcode
 */
public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 2};
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarraySort(nums));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarrayBetter(nums));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums));
    }

    /**
     * 个人常规解法：一次遍历 找到非升序的起点与终点
     * 47ms 20.45%
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        // 记录需要排序的数组起始索引
        int startIndex = 0, endIndex = nums.length - 1;
        boolean startMove = false, endMove = false;
        for (int i = 1; i < nums.length; i++) {
            // 确定第一个未升序位置
            if (nums[i - 1] > nums[i]) {
                startIndex = i - 1;
                startMove = true;
                break;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            // 确定最后一个未升序位置
            if (nums[i - 1] > nums[i]) {
                endIndex = i;
                endMove = true;
                break;
            }
        }
        // 本身有序处理
        if (!startMove && !endMove) {
            return 0;
        }

        // 调整startIndex和endIndex的值
        Arrays.sort(nums, startIndex, endIndex + 1);
        int min = nums[startIndex];
        int max = nums[endIndex];
        for (int i = startIndex - 1; i >= 0; i--) {
            if (nums[i] > min) {
                startIndex = i;
            } else {
                break;
            }
        }
        for (int i = endIndex + 1; i < nums.length; i++) {
            if (nums[i] < max) {
                endIndex = i;
            } else {
                break;
            }
        }
        return endIndex - startIndex + 1;
    }

    /**
     * 算法优化（最优）：寻找最大最小值时，不排序
     * 33ms 50.56%
     * @param nums
     * @return
     */
    public int findUnsortedSubarrayBetter(int[] nums) {
        // 记录需要排序的数组起始索引
        int startIndex = 0, endIndex = nums.length - 1;
        boolean startMove = false, endMove = false;
        for (int i = 1; i < nums.length; i++) {
            // 确定第一个未升序位置
            if (nums[i - 1] > nums[i]) {
                startIndex = i - 1;
                startMove = true;
                break;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            // 确定最后一个未升序位置
            if (nums[i - 1] > nums[i]) {
                endIndex = i;
                endMove = true;
                break;
            }
        }
        // 本身有序处理
        if (!startMove && !endMove) {
            return 0;
        }

        // 调整startIndex和endIndex的值
        int min = findMinAndMax(nums, startIndex, endIndex + 1)[0];
        int max = findMinAndMax(nums, startIndex, endIndex + 1)[1];
        for (int i = startIndex - 1; i >= 0; i--) {
            if (nums[i] > min) {
                startIndex = i;
            } else {
                break;
            }
        }
        for (int i = endIndex + 1; i < nums.length; i++) {
            if (nums[i] < max) {
                endIndex = i;
            } else {
                break;
            }
        }
        return endIndex - startIndex + 1;
    }

    public int[] findMinAndMax(int[] nums, int start, int end) {
        int[] res = {nums[start], nums[start]};
        for (int i = start; i < end; i++) {
            if (res[0] > nums[i]) {
                res[0] = nums[i];
            }
            if (res[1] < nums[i]) {
                res[1] = nums[i];
            }
        }
        return res;
    }

    /**
     * 个人常规解法：排好序比较位数不同
     * 72ms 9.67%
     */
    public int findUnsortedSubarraySort(int[] nums) {
        int[] numCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numCopy);
        int startIndex = 0, endIndex = nums.length - 1;
        boolean startMove = false, endMove = false;
        for (int i = 0; i < nums.length; i++) {
            if (numCopy[i] - nums[i] != 0) {
                startIndex = i;
                startMove = true;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (numCopy[i] - nums[i] != 0) {
                endIndex = i;
                endMove = true;
                break;
            }
        }
        // 本身有序处理
        if (!startMove && !endMove) {
            return 0;
        }
        return endIndex - startIndex + 1;
    }

}
