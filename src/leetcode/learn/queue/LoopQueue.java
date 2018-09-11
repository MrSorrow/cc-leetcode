package leetcode.learn.queue;

import java.util.Arrays;

/**
 * @description: 循环队列的数组实现
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 上午10:20
 * @project: cc-leetcode
 */
public class LoopQueue<T> {

    private T[] data;
    private int maxSize;
    private int rear;
    private int front;
    private int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int initialSize) {
        if (initialSize >= 0) {
            maxSize = initialSize;
            data = (T[]) new Object[initialSize];
            front = 0;
            rear = 0;
            size = 0;
        } else {
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(T t) {
        if (size == maxSize) {
            throw new RuntimeException("队列已满，无法插入新的元素！");
        } else {
            data[rear] = t;
            rear = (rear + 1) % maxSize;
            size++;
        }
    }

    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("空队列异常！");
        } else {
            T res = data[front];
            data[front] = null;
            front = (front + 1) % maxSize;
            size--;
            return res;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("空队列异常！");
        } else {
            return data[front];
        }
    }

    public void clear() {
        Arrays.fill(data, null);
        size = 0;
        front = 0;
        rear = 0;
    }
}
