package leetcode.simple.array;

/**
 * @description: 665. 非递减数列
 * @link: <a>https://leetcode-cn.com/problems/non-decreasing-array/description/</a>
 * @author: guoping wang
 * @date: 2018/9/4 8:54
 * @project: cc-leetcode
 */
public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3};
        System.out.println(new NonDecreasingArray().checkPossibilityBetter(nums));
        System.out.println(new NonDecreasingArray().checkPossibility(nums));
    }

    /**
     * 个人常规解法：遍历数组
     * 28ms 42.46%
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                // 如果是因为第i个数太大了，将第i个数更新成i+1的，然后后退一步，重新进行判断
                if (i + 2 < nums.length && nums[i] > nums[i + 2]) {
                    nums[i] = nums[i + 1];
                    i -= 2;
                    if (i < 0) {
                        i = -1;
                    }
                }
            }

            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 个人解法：直接判断
     * 24ms 55.69%
     * @param nums
     * @return
     */
    public boolean checkPossibilityBetter(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                // 判断两个中不能全部出错
                if (i - 1 >= 0 && i + 2 < nums.length && nums[i - 1] > nums[i + 1] && nums[i] > nums[i + 2]) {
                    return false;
                }
            }

            if (count > 1) {
                return false;
            }
        }
        return true;
    }

}
