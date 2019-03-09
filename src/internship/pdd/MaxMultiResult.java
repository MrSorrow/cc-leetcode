package internship.pdd;

import java.util.Scanner;

/**
 * @description: 拼多多实习模拟题
 * @author: guoping wang
 * @date: 2019/3/9 10:35
 * @project: cc-leetcode
 */
public class MaxMultiResult {

    /**
     * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
     * 输入描述: 无序整数数组A[n]
     * 输出描述: 满足条件的最大乘积
     * 输入例子: 3 4 1 2   24
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        // 求最大的三个整数和最小两个负数
        long max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 寻找前三大
            if (num >= 0 && num > max3) {
                // 进堆
                if (num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                } else {
                    max3 = num;
                }
            }

            // 寻找后两大
            if (num < 0 && num < min2) {
                // 进堆
                if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else {
                    min2 = num;
                }
            }
        }

        System.out.println(Math.max(max1 * max2 * max3, max1 * min1 * min2));
    }
}
