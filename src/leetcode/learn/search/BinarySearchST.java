package leetcode.learn.search;

import java.util.Arrays;

/**
 * @description: 基于有序数组实现的符号表进行二分查找
 * @author: guoping wang
 * @date: 2018/9/12 22:32
 * @project: cc-leetcode
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> extends BaseST<Key, Value> {

    private Key[] keys;
    private Value[] values;
    private int size;
    private int maxSize;

    public BinarySearchST() {
        this(16);
    }

    public BinarySearchST(int initialSize) {
        maxSize = initialSize;
        size = 0;
        keys = (Key[]) new Comparable[initialSize];
        values = (Value[]) new Comparable[initialSize];
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int index = rank(key);
        if (index < size && key.equals(keys[index])) {
            return values[index];
        }
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        int index = rank(key);
        if (index < size && key.equals(keys[index])) {
            values[index] = value;
        } else {
            // 在index位置插入，后面的右移
            for (int i = size; i > index ; i--) {
                keys[i] = keys[i - 1];
                values[i] = values[i - 1];
            }
            keys[index] = key;
            values[index] = value;
            size++;
        }
    }

    @Override
    public boolean contains(Key key) {
        int index = rank(key);
        if (index < size && key.equals(keys[index])) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Value delete(Key key) {
        int index = rank(key);
        if (index < size && key.equals(keys[index])) {
            Value res = values[index];
            // 数据前移，最后清空
            for (int i = index; i < size - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }
            keys[size - 1] = null;
            values[size - 1] = null;
            size--;
            return res;
        }
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        return Arrays.asList(keys);
    }

    /**
     * 返回表中小于给定键的键的数量（二分查找）
     * @param key
     * @return
     */
    private int rank(Key key) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (key.compareTo(keys[mid]) < 0) {
                right = mid - 1;
            } else if (key.compareTo(keys[mid]) > 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        BinarySearchST<String, String> binarySearchST = new BinarySearchST<>();
        binarySearchST.put("a", "aa");
        binarySearchST.put("vb", "aa");
        binarySearchST.put("s", "aa");
        binarySearchST.put("a", "bb");
        System.out.println(binarySearchST.delete("a"));
        System.out.println(binarySearchST.contains("a"));
        System.out.println(binarySearchST.contains("s"));
        System.out.println(binarySearchST.size());

    }
}
