package leetcode.simple.array;

import leetcode.utils.ArrayUtils;

/**
 * @description: 283. 移动零
 * @link: <a>https://leetcode-cn.com/problems/move-zeroes/description/</a>
 * @author: guoping wang
 * @date: 2018/8/27 15:31
 * @project: cc-leetcode
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 0, 3, 0};
        new MoveZeroes().moveZeroes(nums);
        ArrayUtils.printIntArray(nums);
    }

    /**
     * 冒泡排序思路
     * 96ms 2.90%
     * @param nums
     */
    public void moveZeroesBubble(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] != 0) {
                    continue;
                }
                nums[j] = nums[j] + nums[j + 1];
                nums[j + 1] = nums[j] - nums[j + 1];
                nums[j] = nums[j] - nums[j + 1];
            }
        }
    }

    /**
     * 个人常规算法：O(n) 挨个查看是否为0，是0的寻找最近的换上
     * 27ms 14,79%
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    count++;
                } else {
                    break;
                }
                if (j == nums.length - 1) {
                    return;
                }
            }
            nums[i] = nums[i + count];
            nums[i + count] = 0;
        }
    }

    /**
     * 最快解法：假装额外开辟了数组空间
     * 2ms 99.97%
     */
    public void moveZeroesFast(int[] nums) {
        // 第二个数组的索引
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 不等于0的数拷贝至第二数组
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[index++] = 0;
        }
    }
}
