package leetcode.learn.sort;

import leetcode.utils.ArrayUtils;

/**
 * @description: 归并排序
 * @author: guoping wang
 * @date: 2018/9/6 19:05
 * @project: cc-leetcode
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] array = {53, 34, 32, 56, 62, 121, 55, 41};
        sort(array, 0, array.length - 1);
        ArrayUtils.printIntArray(array);
    }

    private static void sort(int[] array, int start, int end) {
        // 递归结束
        if (start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        sort(array, start, mid);  // 左半排序
        sort(array, mid + 1, end); // 右半排序
        merge(array, start, mid + 1, end); // 归并
    }

    /**
     * 两个有序的数组(start->mid - 1, mid->end)原地归并
     * @param array 数组
     * @param start 开始
     * @param mid 中间
     * @param end 结束
     */
    public static void merge(int[] array, int start, int mid, int end) {
        int[] copyArray = new int[end - start + 1];
        for (int i = 0; i < copyArray.length; i++) {
            copyArray[i] = array[i + start];
        }
        // 定义两个数组的指针，向后遍历比较
        int leftIndex = start, rightIndex = mid;
        for (int i = start; i <= end; i++) {
            if (leftIndex >= mid) {
                // 如果左边搞完
                array[i] = copyArray[rightIndex - start];
                rightIndex++;
            } else if (rightIndex > end) {
                // 如果右边边搞完
                array[i] = copyArray[leftIndex - start];
                leftIndex++;
            } else if (copyArray[leftIndex - start] <= copyArray[rightIndex - start]) {
                // 如果左边比右边小
                array[i] = copyArray[leftIndex - start];
                leftIndex++;
            } else if (copyArray[leftIndex - start] > copyArray[rightIndex - start]) {
                // 如果右边比左边小
                array[i] = copyArray[rightIndex - start];
                rightIndex++;
            }
        }
    }
}
