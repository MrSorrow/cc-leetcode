package learn.sort;

import utils.ArrayUtils;

/**
 * @description: 堆排序
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/12 上午9:31
 * @project: cc-leetcode
 */
public class HeapSort {

    public static void sort(int[] array) {
        int N = array.length - 1;
        // 构造堆
        for (int i = (N - 1) / 2; i >= 0 ; i--) {
            sink(array, i, N);
        }
        // 下沉排序
        while (N > 0) {
            // 交换
            int temp = array[0];
            array[0] = array[N];
            array[N] = temp;

            // 下沉0
            sink(array,0, --N);
        }
    }

    /**
     * 下沉k索引元素至正确位置
     * @param array 数组
     * @param k
     * @param tail 堆的末尾索引
     */
    public static void sink(int[] array, int k, int tail) {
        while (2 * k + 1 <= tail) {
            int index = 2 * k + 1;
            if (index < tail && array[index] < array[index + 1]) {
                index++;
            }
            if (array[k] >= array[index]) {
                break;
            }
            // 交换
            int temp = array[k];
            array[k] = array[index];
            array[index] = temp;
            k = index;
        }
    }

    public static void main(String[] args) {
        int[] array = {55};
        ArrayUtils.printIntArray(array);
        sort(array);
        ArrayUtils.printIntArray(array);
    }
}
