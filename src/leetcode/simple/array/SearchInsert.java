package leetcode.simple.array;

/**
 * @link <a>https://leetcode-cn.com/problems/search-insert-position/description/</a>
 * @author Kingdompin@163.com
 * @date 2018/7/29 下午2:39
 */
public class SearchInsert {

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 7, 9, 10};
        System.out.println(new SearchInsert().searchInsert(nums, 0));
    }

    /**
     * 个人解法 二分查找插入 5ms 80.13%
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 后半部分 更新mid start
                start = mid + 1;
                mid = (start + end) / 2;
            } else {
                // 前半部分 更新end mid
                end = mid - 1;
                mid = (start + end) / 2;
            }
        }
        return start;
    }
}
