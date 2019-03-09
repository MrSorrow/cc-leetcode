package leetcode.mid;

import utils.ArrayUtils;

/**
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * @see: <a>https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/1/3 下午10:17
 * @project: cc-leetcode
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 个人常规解法：二分查找后再前后寻找索引位置
     * 7ms 71.41%
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int[] res = {-1, -1};
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                // 如果存在相等的target
                res[0] = mid; res[1] = mid;
                while (res[0] > 0 && nums[res[0] - 1] == target) {
                    res[0]--;
                }
                while (res[1] < nums.length - 1 && nums[res[1] + 1] == target) {
                    res[1]++;
                }
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        ArrayUtils.printIntArray(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, target));
    }
}
