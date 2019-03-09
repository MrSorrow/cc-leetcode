package utils;

/**
 * @description: 数组工具类
 * @author: guoping wang
 * @date: 2018/8/27 16:09
 * @project: cc-leetcode
 */
public class ArrayUtils {

    public static void printIntArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void printInt2DArray(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            printIntArray(nums[i]);
        }
    }

    public static void printStringArray(String[] strings) {
        System.out.print("[");
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
            if (i != strings.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
