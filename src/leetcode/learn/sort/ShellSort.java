package leetcode.learn.sort;

import leetcode.utils.ArrayUtils;

import java.util.Collection;

/**
 * @description: 希尔排序
 * @author: guoping wang
 * @date: 2018/8/29 22:27
 * @project: cc-leetcode
 */
public class ShellSort {
    public static int[] sort(int[] array) {
        // 生成增量序列 1, 4, 7, 10...
        int t = 1;
        while (t < array.length / 3) {
            t = t * 3 + 1;
        }

        // 最外层循环控制所有的增量执行一遍，直到为1
        while (t >= 1) {
            // 对于每一个增量形成的子序列进行排序，可以采用之前的排序算法：插入排序
            // 插入排序假设第一个元素是排好的，则从t开始插入
            for (int i = t; i < array.length; i++) {
                int j = i;
                int temp = array[i];
                // 内层循环寻找插入位置，注意j的递减增量和j的结束
                for (; j >= t && array[j - t] > temp; j -= t) {
                    array[j] = array[j - t];
                }
                array[j] = temp;
            }
            t /= 3;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {53, 34, 32, 56, 62, 121, 55, 18, 92, 16, 33, 98, 76};
        ArrayUtils.printArray(sort(array));
    }
}
