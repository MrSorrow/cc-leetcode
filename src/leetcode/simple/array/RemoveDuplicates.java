package leetcode.simple.array;

/**
 * @link <a>https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/</a>
 * @author Kingdompin@163.com
 * @date 2018/7/28 下午7:19
 */
public class RemoveDuplicates {

    /**
     * 快慢指针——之前就这么思索，原来这叫快慢指针 ^o^!
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[count] = nums[i+1];
                count++;
            }
        }
        return count;
    }
}
