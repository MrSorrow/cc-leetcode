package learn.mqueue;

/**
 * @description: 用堆的形式实现优先队列
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 下午10:33
 * @project: cc-leetcode
 */
public class MaxPQueueWithHeap<T extends Comparable<T>> extends BaseMaxPQueue<T> {

    private T[] data;
    private int maxSize;
    private int size;

    public MaxPQueueWithHeap() {
        this(10);
    }

    public MaxPQueueWithHeap(int initialSize) {
        maxSize = initialSize + 1;
        data = (T[]) new Comparable[maxSize];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void insert(T t) {
        if (size == maxSize - 1) {
            throw new RuntimeException("优先队列已满，无法将元素入优先队列！");
        }
        data[++size] = t;
        swim(size);
    }

    @Override
    public T delMax() {
        if (isEmpty()) {
            throw new RuntimeException("优先队列为空！");
        }
        T max = data[1];
        data[1] = data[size--]; // 交换位置
        data[size + 1] = null; // 防止对象游离
        sink(1);
        return max;
    }

    @Override
    public T getMax() {
        if (isEmpty()) {
            throw new RuntimeException("优先队列为空！");
        }
        return data[1];
    }

    /**
     * 上浮k下标元素至正确位置
     *
     * @param k 需要上浮数据的下标
     */
    private void swim(int k) {
        // 与父节点进行比较交换
        while (k > 1 && data[k].compareTo(data[k / 2]) > 0) {
            T temp = data[k];
            data[k] = data[k / 2];
            data[k / 2] = temp;
            k = k / 2;
        }
    }

    /**
     * 下沉k下标元素至正确位置
     *
     * @param k 需要下沉数据的下标
     */
    private void sink(int k) {
        // 与子节点比较(较大)交换
        while(2 * k <= size) {
            int i = 2 * k;
            if (i < size && data[i].compareTo(data[i + 1]) < 0) {
                i++;
            }
            if (data[k].compareTo(data[i]) >= 0) {
                break;
            }
            T temp = data[k];
            data[k] = data[i];
            data[i] = temp;
            k = i;
        }
    }

    public static void main(String[] args) {
        MaxPQueueWithHeap<String> maxPQueueWithHeap = new MaxPQueueWithHeap<>();
        System.out.println(maxPQueueWithHeap.isEmpty());
        maxPQueueWithHeap.insert("c");
        maxPQueueWithHeap.insert("a");
        maxPQueueWithHeap.insert("bc");
        maxPQueueWithHeap.insert("b");
        maxPQueueWithHeap.insert("ac");
        System.out.println(maxPQueueWithHeap.delMax());
        maxPQueueWithHeap.insert("ca");
        System.out.println(maxPQueueWithHeap.getSize());
        maxPQueueWithHeap.insert("e");
        maxPQueueWithHeap.insert("f");
        maxPQueueWithHeap.insert("d");
    }
}
