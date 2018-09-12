package leetcode.learn.mqueue;

/**
 * @description: 用有序数组实现优先队列
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 下午10:00
 * @project: cc-leetcode
 */
public class MaxPQueueWithSortedArray<T extends Comparable<T>> extends BaseMaxPQueue<T> {

    private T[] data;
    private int maxSize;
    private int top;

    public MaxPQueueWithSortedArray() {
        this(10);
    }

    public MaxPQueueWithSortedArray(int initialSize) {
        data = (T[]) new Comparable[initialSize];
        maxSize = initialSize;
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int getSize() {
        return top + 1;
    }

    @Override
    public void insert(T t) {
        // 插入排序
        if (top == maxSize - 1) {
            throw new RuntimeException("优先队列已满，无法将元素入优先队列！");
        } else if (isEmpty()) {
            data[++top] = t;
        } else {
            int i = top;
            for (; i >= 0;) {
                if (data[i].compareTo(t) > 0) {
                    data[i + 1] = data[i];
                    i--;
                } else {
                    break;
                }
            }
            data[++i] = t;
            top++;
        }
    }

    @Override
    public T delMax() {
        if(top == -1){
            throw new RuntimeException("优先队列为空！");
        }else {
            return data[top--];
        }
    }

    @Override
    public T getMax() {
        if(top == -1){
            throw new RuntimeException("优先队列为空！");
        }else {
            return data[top];
        }
    }

    public static void main(String[] args) {
        MaxPQueueWithSortedArray<Integer> maxPQueueWithSortedArray = new MaxPQueueWithSortedArray<>(5);
        System.out.println(maxPQueueWithSortedArray.isEmpty());
        maxPQueueWithSortedArray.insert(3);
        maxPQueueWithSortedArray.insert(2);
        maxPQueueWithSortedArray.insert(6);
        System.out.println(maxPQueueWithSortedArray.getMax());
        maxPQueueWithSortedArray.insert(4);
        maxPQueueWithSortedArray.insert(3);
        System.out.println(maxPQueueWithSortedArray.delMax());
        maxPQueueWithSortedArray.insert(1);
        System.out.println(maxPQueueWithSortedArray.getSize());
    }
}
