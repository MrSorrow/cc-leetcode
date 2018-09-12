package leetcode.learn.mqueue;

/**
 * @description: 优先队列基类
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 下午4:51
 * @project: cc-leetcode
 */
public abstract class BaseMaxPQueue<T extends Comparable<T>> {

    public abstract boolean isEmpty();

    public abstract int getSize();

    public abstract void insert(T t);

    public abstract T delMax();

    public abstract T getMax();
}
