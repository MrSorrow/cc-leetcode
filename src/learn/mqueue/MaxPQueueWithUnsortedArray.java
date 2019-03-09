package learn.mqueue;

/**
 * @description: 用无序数组实现的优先队列
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 下午4:35
 * @project: cc-leetcode
 */
public class MaxPQueueWithUnsortedArray<T extends Comparable<T>> extends BaseMaxPQueue<T> {

    private T[] data;
    private int maxSize;
    private int top;

    public MaxPQueueWithUnsortedArray() {
        this(10);
    }

    public MaxPQueueWithUnsortedArray(int initialSize) {
        maxSize = initialSize;
        data = (T[]) new Comparable[maxSize];
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
        if (top == maxSize - 1) {
            throw new RuntimeException("优先队列已满，无法将元素入优先队列！");
        }
        data[++top] = t;
    }

    @Override
    public T delMax() {
        if(top == -1){
            throw new RuntimeException("优先队列为空！");
        }else {
            int maxIndex = top;
            // 选择排序选出最大并与top交换
            for (int i = top - 1; i >= 0; i--) {
                if (data[maxIndex].compareTo(data[i]) < 0) {
                    maxIndex = i;
                }
            }
            T max = data[maxIndex];
            data[maxIndex] = data[top];
            data[top--] = null;
            return max;
        }
    }

    @Override
    public T getMax() {
        if(top == -1){
            throw new RuntimeException("优先队列为空！");
        }else {
            int maxIndex = top;
            // 选择排序选出最大
            for (int i = top - 1; i >= 0; i--) {
                if (data[maxIndex].compareTo(data[i]) < 0) {
                    maxIndex = i;
                }
            }
            return data[maxIndex];
        }
    }

    public static void main(String[] args) {
        MaxPQueueWithUnsortedArray<Integer> maxPQueueWithStack = new MaxPQueueWithUnsortedArray<>(5);
        System.out.println(maxPQueueWithStack.isEmpty());
        maxPQueueWithStack.insert(1);
        maxPQueueWithStack.insert(5);
        maxPQueueWithStack.insert(4);
        maxPQueueWithStack.insert(3);
        System.out.println(maxPQueueWithStack.getSize());
        System.out.println(maxPQueueWithStack.getMax());
        System.out.println(maxPQueueWithStack.delMax());
        maxPQueueWithStack.insert(6);
        maxPQueueWithStack.insert(6);
        System.out.println(maxPQueueWithStack.delMax());
        System.out.println(maxPQueueWithStack.getMax());
    }
}
