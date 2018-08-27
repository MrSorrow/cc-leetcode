package leetcode.simple.array;

/**
 * @description: 414. 第三大的数
 * @link: <a>https://leetcode-cn.com/problems/third-maximum-number/description/</a>
 * @author: guoping wang
 * @date: 2018/8/27 18:43
 * @project: cc-leetcode
 */
public class ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] nums = {2,2,3,1};
        System.out.println(new ThirdMaximumNumber().thirdMax(nums));
    }

    /**
     * 个人常规解法：找三个数保存第一第二第三，主要麻烦在于处理各种特殊情况
     * 3ms 99.73%
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        int count = 0;
        if (nums.length > 0) {
            int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > first) {
                    third = second;
                    second = first;
                    first = nums[i];
                    count++;
                } else if (nums[i] == first) {
                    // 相等的时候处理判断是重复值还是和我们定义的Integer.MIN_VALUE重复
                    if (count > 0) {
                        continue;
                    } else {
                        third = second;
                        second = first;
                        first = nums[i];
                        count++;
                    }
                } else if (nums[i] > second) {
                    third = second;
                    second = nums[i];
                    count++;
                } else if (nums[i] == second) {
                    // 相等的时候处理判断是重复值还是和我们定义的Integer.MIN_VALUE重复
                    if (count > 1) {
                        continue;
                    } else {
                        third = second;
                        second = nums[i];
                        count++;
                    }
                } else if (nums[i] > third) {
                    third = nums[i];
                    count++;
                } else if (nums[i] == third) {
                    count++;
                }
            }
            return count > 2 ? third : first;
        } else {
            throw new IllegalArgumentException("No third max!");
        }
    }
}
