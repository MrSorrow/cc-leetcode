package leetcode.simple.queue;

/**
 * @description: 622.设计循环队列
 * @link: <a>https://leetcode-cn.com/problems/design-circular-queue/</a>
 * @author: guoping wang
 * @date: 2018/9/22 16:59
 * @project: cc-leetcode
 */
public class DesignCircularQueue {

    /**
     * 个人常规解法：数组实现循环队列
     * 76ms 94.97%
     */
    static class MyCircularQueue {

        private int[] queue;
        private int front; // 有元素，可删除
        private int rear; // 不包含元素，待插入
        private int size;
        private int maxSize;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            queue = new int[k];
            maxSize = k;
            front = 0; // 队头，没有该元素
            rear = 0; // 队尾
            size = 0;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (size >= maxSize) {
                return false;
            } else {
                queue[rear] = value;
                rear = (rear + 1) % maxSize;
                size++;
                return true;
            }
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            } else {
                queue[front] = -1;
                front = (front + 1) % maxSize;
                size--;
                return true;
            }
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty()) {
                return -1;
            } else {
                return queue[front];
            }
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            } else {
                return queue[(rear + maxSize - 1) % maxSize];
            }
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == maxSize;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为3

        boolean b = circularQueue.enQueue(1);// 返回true

        boolean b1 = circularQueue.enQueue(2);// 返回true

        boolean b2 = circularQueue.enQueue(3);// 返回true

        boolean b3 = circularQueue.enQueue(4);// 返回false,队列已满

        int rear = circularQueue.Rear();// 返回3

        boolean full = circularQueue.isFull();// 返回true

        boolean b4 = circularQueue.deQueue();// 返回true

        boolean b5 = circularQueue.enQueue(4);// 返回true

        int rear1 = circularQueue.Rear();// 返回4
    }
}
