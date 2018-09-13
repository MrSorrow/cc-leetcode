package leetcode.simple.stack;


import java.util.Stack;

/**
 * @description: 155. 最小栈
 * @link: <a>https://leetcode-cn.com/problems/min-stack/description/</a>
 * @author: guoping wang
 * @date: 2018/9/13 18:20
 * @project: cc-leetcode
 */
public class MinStack {

    public static void main(String[] args) {

    }

    /**
     * 个人常规解法：额外添加一个数用来记录最小值
     * 124ms 29.78%
     */
    /*
    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        if (min > x) {
            min = x;
        }
    }

    public void pop() {
        stack.pop();
        min = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            if (integer < min) {
                min = integer;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
    */

    /**
     * 最优算法：用单独一个栈来存最小值
     * 84ms 97.56%
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;


    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
