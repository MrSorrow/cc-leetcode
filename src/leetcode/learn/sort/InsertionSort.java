package leetcode.learn.sort;

import leetcode.utils.ArrayUtils;

/**
 * @description: 插入排序
 * @author: guoping wang
 * @date: 2018/8/28 16:44
 * @project: cc-leetcode
 */
public class InsertionSort {

    public static int[] sort(int[] array) {
        // 外层循环选择插入的牌，第一张已经排好
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            // 内存循环从后向前扫描，寻找正确的插入位置
            for (; j > 0 && temp < array[j - 1]; j--) {
                // 元素向后移动腾出位置
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {53, 34, 32, 56, 62, 121, 55};
        ArrayUtils.printIntArray(sort(array));
    }
}
