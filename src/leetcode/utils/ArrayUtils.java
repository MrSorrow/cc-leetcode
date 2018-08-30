package leetcode.utils;

/**
 * @description: 数组工具类
 * @author: guoping wang
 * @date: 2018/8/27 16:09
 * @project: cc-leetcode
 */
public class ArrayUtils {

    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void print2DArray(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            printArray(nums[i]);
        }
    }
}
