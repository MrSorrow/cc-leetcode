package leetcode.learn.search;

/**
 * @description: 符号表抽象类定义
 * @author: guoping wang
 * @date: 2018/9/12 21:32
 * @project: cc-leetcode
 */
public abstract class BaseST<Key extends Comparable<Key>, Value> {

    public abstract Value get(Key key);

    public abstract void put(Key key, Value value);

    public abstract boolean contains(Key key);

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract Value delete(Key key);

    public abstract Iterable<Key> keys();
}
