package leetcode.simple.stack;

import java.util.Stack;

/**
 * @description: 232. 用栈实现队列
 * @link: <a>https://leetcode-cn.com/problems/implement-queue-using-stacks/description/</a>
 * @author: guoping wang
 * @date: 2018/9/14 14:44
 * @project: cc-leetcode
 */
public class ImplementQueueUsingStacks {

    /**
     * 个人常规解法：两个水杯冷水的方式，另一个栈专门辅助
     * 96ms 35.90%
     */
    static class MyQueue {

        private Stack<Integer> stackMaster;
        private Stack<Integer> stackSlave;

        /** Initialize your data structure here. */
        public MyQueue() {
            stackMaster = new Stack<>();
            stackSlave = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stackMaster.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stackMaster.isEmpty()) {
                throw new RuntimeException("queue is empty...");
            } else {
                while (!stackMaster.isEmpty()) {
                    stackSlave.push(stackMaster.pop());
                }
                Integer res = stackSlave.pop();
                while (!stackSlave.isEmpty()) {
                    stackMaster.push(stackSlave.pop());
                }
                return res;
            }
        }

        /** Get the front element. */
        public int peek() {
            if (stackMaster.isEmpty()) {
                throw new RuntimeException("queue is empty...");
            } else {
                Integer res = null;
                while (!stackMaster.isEmpty()) {
                    res = stackMaster.pop();
                    stackSlave.push(res);
                }
                while (!stackSlave.isEmpty()) {
                    stackMaster.push(stackSlave.pop());
                }
                return res;
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stackMaster.isEmpty();
        }
    }

    /**
     * 个人改进算法：正常push一直都进主栈，pop的时候主栈的元素全部进入从栈在取，直到取完
     * 73ms 98.80%
     */
    static class MyQueueFast {

        private Stack<Integer> stackMaster;
        private Stack<Integer> stackSlave;

        /** Initialize your data structure here. */
        public MyQueueFast() {
            stackMaster = new Stack<>();
            stackSlave = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stackMaster.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (empty()) {
                throw new RuntimeException("queue is empty...");
            }
            // 专用于pop的栈
            if (stackSlave.isEmpty()) {
                while (!stackMaster.isEmpty()) {
                    stackSlave.push(stackMaster.pop());
                }
            }
            return stackSlave.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (empty()) {
                throw new RuntimeException("queue is empty...");
            }
            // 专用于pop的栈
            if (stackSlave.isEmpty()) {
                while (!stackMaster.isEmpty()) {
                    stackSlave.push(stackMaster.pop());
                }
            }
            return stackSlave.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stackMaster.isEmpty() && stackSlave.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueueFast myQueue = new MyQueueFast();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
    }
}
