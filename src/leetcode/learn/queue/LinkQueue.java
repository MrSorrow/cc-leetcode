package leetcode.learn.queue;

/**
 * @description: 基于链式存储的队列
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 上午9:51
 * @project: cc-leetcode
 */
public class LinkQueue<T> {

    private class Node<T> {
        private T t;
        private Node<T> next;

        public Node() {
        }

        public Node(T t, Node<T> next) {
            this.t = t;
            this.next = next;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(T t) {
        if (isEmpty()) {
            front = new Node<>(t, null);
            rear = front;
        } else {
            Node<T> newNode = new Node<>(t, null);
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("空队列异常！");
        } else {
            Node<T> res = front;
            front = front.next;
            res.next = null;
            size--;
            return res.t;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("空队列异常！");
        } else {
            return front.t;
        }
    }
}
