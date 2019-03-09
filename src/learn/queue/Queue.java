package learn.queue;

/**
 * @description: 基于数组实现的队列
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 上午9:35
 * @project: cc-leetcode
 */
public class Queue<T> {

    private T[] data;
    private int maxSize;
    private int front;
    private int rear;

    public Queue() {
        this(10);
    }

    public Queue(int initialSize) {
        if (initialSize >= 0) {
            maxSize = initialSize;
            data = (T[]) new Object[initialSize];
            front = 0; // 对头，包括该元素
            rear = 0; // 队尾，不包括该元素
        } else {
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
        }
    }

    public int getSize() {
        return rear - front;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void add(T t) {
        if (rear == maxSize) {
            throw new RuntimeException("队列已满，无法插入新的元素！");
        }
        data[rear++] = t;
    }

    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("空队列异常！");
        }
        T res = data[front];
        data[front++] = null;
        return res;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("空队列异常！");
        }
        return data[front];
    }
}
