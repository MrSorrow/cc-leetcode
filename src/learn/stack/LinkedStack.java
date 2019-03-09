package learn.stack;

/**
 * @description: 栈的链表实现
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/10 下午9:12
 * @project: cc-leetcode
 */
public class LinkedStack<T> {

    private class Node<T> {
        T t;
        Node<T> next;

        public Node() {
        }

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }
    }

    /** 栈顶 */
    private Node<T> top;
    /** 栈大小 */
    private int size;

    public LinkedStack() {
        top = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T t) {
        // 栈
        top = new Node(t, top);
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("空栈异常！");
        }
        Node<T> res = top;
        top = top.next;
        res.next = null;
        size--;
        return res.t;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("空栈异常！");
        }
        return top.t;
    }
}
