package leetcode.learn.sort;

import leetcode.utils.ArrayUtils;

/**
 * @description: 快速排序
 * @author: guoping wang
 * @date: 2018/9/7 9:47
 * @project: cc-leetcode
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {53, 34, 32, 56, 34, 56, 62, 121, 55, 41};
//        sort(array, 0, array.length - 1);
        sort3way(array, 0, array.length - 1);
        ArrayUtils.printArray(array);
    }

    public static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(array, start, end);
        sort(array, start, mid - 1);
        sort(array, mid + 1, end);
    }

    /**
     * 寻找切分元素，将数组分成左右两部分
     * @param array 数组
     * @param start 开始
     * @param end 结束
     * @return 切分元素索引
     */
    private static int partition(int[] array, int start, int end) {
        // 定义首尾指针位置
        int leftIndex = start, rightIndex = end + 1;

        while (true) {
            // 寻找左边大于切分元素
            while (array[++leftIndex] <= array[start]) {
                if (leftIndex == end) {
                    break;
                }
            }
            // 寻找右边小于切分元素
            while (array[--rightIndex] >= array[start]) {
                if (rightIndex == start) {
                    break;
                }
            }
            // 寻找到的进行替换
            if (leftIndex >= rightIndex) {
                break;
            }
            int temp = array[leftIndex];
            array[leftIndex] = array[rightIndex];
            array[rightIndex] = temp;
        }

        // 最终交换切分位置
        int temp = array[start];
        array[start] = array[rightIndex];
        array[rightIndex] = temp;

        return rightIndex;
    }

    /**
     * 三向切分的快速排序
     * @param array
     * @param start
     * @param end
     */
    public static void sort3way(int[] array, int start, int end) {
        // 递归条件
        if (start >= end) {
            return;
        }

        // 定义三个指针和切分元素
        int lt = start, i = start + 1, gt = end;
        int div = array[start];

        while (i <= gt) {
            if (array[i] < div) {
                int temp = array[i];
                array[i] = array[lt];
                array[lt] = temp;
                i++;
                lt++;
            } else if (array[i] > div) {
                int temp = array[i];
                array[i] = array[gt];
                array[gt] = temp;
                gt--;
            } else {
                i++;
            }
        }

        sort(array, start, lt - 1);
        sort(array, gt + 1, end);
    }
}
