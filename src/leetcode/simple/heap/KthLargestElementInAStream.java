package leetcode.simple.heap;

import java.util.*;

/**
 * @description: 703. 数据流中的第K大元素
 * @link: <a>https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/description/</a>
 * @author: guoping wang
 * @date: 2018/9/21 20:14
 * @project: cc-leetcode
 */
public class KthLargestElementInAStream {

    /**
     * 链+堆的实现思路
     * 342ms 40.12%
     */
    static class KthLargest {

        private int[] startArr;
        private int size;
        private List<Integer> heap;

        public KthLargest(int k, int[] nums) {
            startArr = new int[k];
            size = 0;
            heap = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        /**
         * 插入元素在堆的末尾，并进行上升
         *
         * @param val
         * @return
         */
        public int add(int val) {
            if (size < startArr.length) {
                // 插入排序

                if (size > 0) {
                    int i = size;
                    for (; i > 0 && startArr[i - 1] < val; i--) {
                        startArr[i] = startArr[i - 1];
                    }
                    startArr[i] = val;
                } else {
                    startArr[size] = val;
                }
                size++;
            } else {
                // 元素放入堆中
                heap.add(val);
                size++;

                swimInHeap(heap.size() - 1);

                // 如果需要继续上浮至数组中
                if (heap.get(0) > startArr[startArr.length - 1]) {
                    int temp = heap.get(0);
                    heap.set(0, startArr[startArr.length - 1]);
                    startArr[startArr.length - 1] = temp;

                    swimInArray(startArr.length - 1);
                }

                if (heap.size() > 1 && heap.get(1) > startArr[startArr.length - 1]) {
                    int temp = heap.get(1);
                    heap.set(1, startArr[startArr.length - 1]);
                    startArr[startArr.length - 1] = temp;

                    swimInArray(startArr.length - 1);
                }
            }
            return startArr[startArr.length - 1];
        }

        /**
         * 上浮元素
         *
         * @param index
         */
        public void swimInHeap(int index) {
            while (index > 1 && heap.get(index) > heap.get(index / 2 - 1)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(index / 2 - 1));
                heap.set(index / 2 - 1, temp);

                index = index / 2 - 1;
            }
        }

        public void swimInArray(int index) {
            for (int i = index; i > 0; i--) {
                if (startArr[i] > startArr[i - 1]) {
                    int temp = startArr[i];
                    startArr[i] = startArr[i - 1];
                    startArr[i - 1] = temp;
                } else {
                    break;
                }
            }
        }

        public static void main(String[] args) {
            int k = 3;
            int[] arr = {4, 5, 8, 2};
            KthLargest kthLargest = new KthLargest(3, arr);
            kthLargest.add(3);   // returns 4
            kthLargest.add(5);   // returns 5
            kthLargest.add(10);  // returns 5
            kthLargest.add(9);   // returns 8
            kthLargest.add(4);   // returns 8
        }
    }

    /**
     * 只保留前7个最大的元素
     * 278ms 41.71%
     */
    static class KthLargestOnlyK {

        private int[] startArr;
        private int size;

        public KthLargestOnlyK(int k, int[] nums) {
            startArr = new int[k];
            size = 0;
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        /**
         * 插入元素在堆的末尾，并进行上升
         *
         * @param val
         * @return
         */
        public int add(int val) {

            if (size < startArr.length) {
                // 插入排序
                if (size > 0) {
                    int i = size;
                    for (; i > 0 && startArr[i - 1] < val; i--) {
                        startArr[i] = startArr[i - 1];
                    }
                    startArr[i] = val;
                } else {
                    startArr[size] = val;
                }
                size++;
            } else {
                if (val > startArr[startArr.length - 1]) {
                    startArr[startArr.length - 1] = val;
                    swimInArray(startArr.length - 1);
                }
            }

            return startArr[startArr.length - 1];
        }

        public void swimInArray(int index) {
            for (int i = index; i > 0; i--) {
                if (startArr[i] > startArr[i - 1]) {
                    int temp = startArr[i];
                    startArr[i] = startArr[i - 1];
                    startArr[i - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 最快的：JavaAPI最小根的优先队列，思路也是仅保留开头的7个
     * 107ms 91.43%
     */
    static class KthLargestOnlyKHeap {

        private Queue<Integer> kHeap;
        private int maxSize;

        public KthLargestOnlyKHeap(int k, int[] nums) {
            kHeap = new PriorityQueue<>(k);
            maxSize = k;
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        /**
         * 插入元素在堆的末尾，并进行上升
         *
         * @param val
         * @return
         */
        public int add(int val) {
            if (kHeap.size() < maxSize) {
                kHeap.add(val);
            } else if (kHeap.peek() < val) {
                kHeap.poll();
                kHeap.add(val);
            }

            return kHeap.peek();
        }
    }
}
