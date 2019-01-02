package leetcode.mid;

/**
 * @description: 33. 搜索旋转排序数组
 * @see: <a>https://leetcode-cn.com/problems/search-in-rotated-sorted-array/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/1/2 下午5:19
 * @project: cc-leetcode
 */
public class SearchInRotatedSortedArray {

    /**
     * 个人常规解法：假的二分递归
     * 15ms 57.69
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return searchBetter(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start > end || (start == end && nums[start] != target)) {
            return -1;
        }
        if (nums[start] == target) {
            return start;
        } else {
            int res = search(nums, target, start + 1, (start + end) / 2);
            return res == -1 ? search(nums, target, (start + 1 + end) / 2, end) : res;
        }
    }

    /**
     * 个人常规解法：正宗的二分法
     * 8ms 95.41%
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return
     */
    public int searchBetter(int[] nums, int target, int start, int end) {
        if (start > end || (start == end && nums[start] != target)) {
            return -1;
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[start] < target) {
            if (nums[(start + 1 + end) / 2] > nums[start]) {
                if (nums[(start + 1 + end) / 2] < target) {
                    return searchBetter(nums, target, (start + 1 + end) / 2 + 1, end);
                } else if (nums[(start + 1 + end) / 2] > target) {
                    return searchBetter(nums, target, start + 1, (start + 1 + end) / 2 - 1);
                } else {
                    return (start + 1 + end) / 2;
                }
            } else {
                return searchBetter(nums, target, start + 1, (start + 1 + end) / 2);
            }
        } else {
            if (nums[(start + 1 + end) / 2] < nums[end]) {
                if (nums[(start + 1 + end) / 2] < target) {
                    return searchBetter(nums, target, (start + 1 + end) / 2 + 1, end);
                } else if (nums[(start + 1 + end) / 2] > target) {
                    return searchBetter(nums, target, start + 1, (start + 1 + end) / 2 - 1);
                } else {
                    return (start + 1 + end) / 2;
                }
            } else {
                return searchBetter(nums, target, (start + 1 + end) / 2, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 2, 3, 4,5,6};
        int target = 6;
        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }
}
