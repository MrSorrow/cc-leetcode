package sword2offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * @see <a>https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6</a>
 * @author liweng
 * @created 2019-06-23
 **/
public class QueueWithStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
