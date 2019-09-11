package sword2offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈
 *
 * @author liweng
 * @created 2019-06-23
 **/
public class StackWithQueue {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        if (queue2.isEmpty()) {
            queue1.offer(node);
        } else {
            queue2.offer(node);
        }
    }

    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return queue1.poll();
        } else if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else {
            throw new IllegalStateException("状态错误");
        }
    }
}
