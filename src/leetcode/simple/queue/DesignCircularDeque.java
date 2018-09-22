package leetcode.simple.queue;

/**
 * @description: 641.设计循环双端队列
 * @link: <a>https://leetcode-cn.com/problems/design-circular-deque/</a>
 * @author: guoping wang
 * @date: 2018/9/22 18:35
 * @project: cc-leetcode
 */
public class DesignCircularDeque {

    /**
     * 个人常规解法
     * 84ms 85.18%
     */
    static class MyCircularDeque {

        private int[] deque;
        private int maxSize;
        private int size;
        private int front;
        private int rear;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            deque = new int[k];
            maxSize = k;
            size = 0;
            front = 0;
            rear = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                front = (front - 1 + maxSize) % maxSize;
                deque[front] = value;
                size++;
                return true;
            }
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                deque[rear] = value;
                rear = (rear + 1) % maxSize;
                size++;
                return true;
            }
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                deque[front] = -1;
                front = (front + 1) % maxSize;
                size--;
                return true;
            }
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                rear = (rear - 1 + maxSize) % maxSize;
                deque[rear] = -1;
                size--;
                return true;
            }
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque[front];
            }
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque[(rear - 1 + maxSize) % maxSize];
            }
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == maxSize;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        boolean b = circularDeque.insertLast(1);// 返回 true
        boolean b1 = circularDeque.insertLast(2);// 返回 true
        boolean b2 = circularDeque.insertFront(3);// 返回 true
        boolean b3 = circularDeque.insertFront(4);// 已经满了，返回 false
        int rear = circularDeque.getRear();// 返回  32
        boolean full = circularDeque.isFull();// 返回 true
        boolean b4 = circularDeque.deleteLast();// 返回 true
        boolean b5 = circularDeque.insertFront(4);// 返回 true
        int front = circularDeque.getFront();// 返回 4
    }
}
