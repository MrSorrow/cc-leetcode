package leetcode.simple.array;

/**
 * @link <a>https://leetcode-cn.com/problems/remove-element/description/</a>
 * @author Kingdompin@163.com
 * @date 2018/7/28 下午7:59
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0,4,4,0,4,4,4,0,2};
        System.out.println(new RemoveElement().removeElement(nums, 4));
    }

    /**
     * 自己解法--首尾快慢指针 8ms 79.10%
     */
    public int removeElement(int[] nums, int val) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int slowIndex = nums.length - 1;
        int count = 0;
        for (int fastIndex = 0; fastIndex <= slowIndex; fastIndex++) {
            if (nums[fastIndex] == val) {
                count++;
                while (nums[slowIndex] == val) {
                    if (slowIndex > fastIndex) {
                        slowIndex--;
                        count++;
                    } else if (slowIndex == fastIndex) {
                        break;
                    } else {
                        break;
                    }
                }
                nums[fastIndex] = nums[slowIndex];
                slowIndex--;
            }
        }
        return nums.length - count;
    }
}
