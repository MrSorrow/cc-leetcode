package leetcode.simple.array;

import java.util.Arrays;
import java.util.Map;

/**
 * @description: 628. 三个数的最大乘积
 * @link: <a>https://leetcode-cn.com/problems/maximum-product-of-three-numbers/description/</a>
 * @author: guoping wang
 * @date: 2018/9/2 19:47
 * @project: cc-leetcode
 */
public class MaximumProductOfThreeNumbers {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new MaximumProductOfThreeNumbers().maximumProductSort(nums));
        System.out.println(new MaximumProductOfThreeNumbers().maximumProductIteritor(nums));
    }

    /**
     * 个人算法：遍历一次数组，寻找最大的三个正数相乘或者最大的正数与两个最小的负数相乘 (最优算法)
     * 22ms 78.98%
     * @param nums
     * @return
     */
    public int maximumProductIteritor(int[] nums) {
        if (nums.length < 2) {
            return 0;
        } else if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        } else {
            // 存放最大正数、第二正数、第三正数、最小负数、倒数第二负数
            int[] temp = {nums[0], nums[1], nums[2], nums[1], nums[2]};
            temp[0] = Math.max(Math.max(nums[0], nums[1]), nums[2]);
            temp[2] = Math.min(Math.min(nums[0], nums[1]), nums[2]);
            temp[1] = nums[0] +nums[1] + nums[2] - temp[0] - temp[2];
            temp[3] = temp[2];
            temp[4] = temp[1];

            for (int i = 3; i < nums.length; i++) {
                if (nums[i] >= 0) {
                    // 如果是正数开始比
                    if (nums[i] > temp[0]) {
                        temp[2] = temp[1];
                        temp[1] = temp[0];
                        temp[0] = nums[i];
                    } else if (nums[i] > temp[1]) {
                        temp[2] = temp[1];
                        temp[1] = nums[i];
                    } else if (nums[i] > temp[2]) {
                        temp[2] = nums[i];
                    }
                } else {
                    // 如果是负数开始比
                    if (nums[i] < temp[3]) {
                        temp[4] = temp[3];
                        temp[3] = nums[i];
                    } else if (nums[i] < temp[4]) {
                        temp[4] = nums[i];
                    }
                }
            }
            return Math.max(temp[0] * temp[1] * temp[2], temp[0] * temp[3] * temp[4]);
        }
    }

    /**
     * 个人解法：排序 最后乘积最大无外乎三种情况
     * 38ms 21.88%
     * @param nums
     * @return
     */
    public int maximumProductSort(int[] nums) {
        if (nums.length < 2) {
            return 0;
        } else if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        } else {
            Arrays.sort(nums);
            return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                    nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
        }
    }
}
