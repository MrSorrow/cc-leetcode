package learn.stack;

import java.util.LinkedList;

/**
 * @description: 栈的LinkedList实现
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 上午9:29
 * @project: cc-leetcode
 */
public class StackList<T> {

    private LinkedList<T> linkedList;

    public StackList() {
        linkedList = new LinkedList<>();
    }

    public int getSize() {
        return linkedList.size();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public void push(T t) {
        linkedList.addFirst(t);
    }

    public T pop() {
        return linkedList.removeFirst();
    }

    public T peek() {
        return linkedList.getFirst();
    }
}
