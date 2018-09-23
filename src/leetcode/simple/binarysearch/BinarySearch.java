package leetcode.simple.binarysearch;

/**
 * @description: 704. 二分查找
 * @link: <a>https://leetcode-cn.com/problems/binary-search/</a>
 * @author: guoping wang
 * @date: 2018/9/23 10:42
 * @project: cc-leetcode
 */
public class BinarySearch {

    /**
     * 二分查找算法
     * 4ms 83.67%
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
