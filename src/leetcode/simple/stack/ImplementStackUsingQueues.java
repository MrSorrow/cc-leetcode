package leetcode.simple.stack;

import java.util.LinkedList;

/**
 * @description: 225. 用队列实现栈
 * @link: <a>https://leetcode-cn.com/problems/implement-stack-using-queues/description/</a>
 * @author: guoping wang
 * @date: 2018/9/14 10:58
 * @project: cc-leetcode
 */
public class ImplementStackUsingQueues {

    /**
     * 个人解法：两个队列实现栈，队列元素不停的轮换
     * 75ms 92.0%
     */
    static class MyStack {

        private LinkedList<Integer> linkedListMater;
        private LinkedList<Integer> linkedListSlave;

        /** Initialize your data structure here. */
        public MyStack() {
            linkedListMater = new LinkedList<>();
            linkedListSlave = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (linkedListSlave.isEmpty()) {
                linkedListMater.push(x);
            } else {
                linkedListSlave.push(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (empty()) {
                throw new RuntimeException("stack is empty...");
            } else if (linkedListMater.isEmpty() && !linkedListSlave.isEmpty()) {
                for (int i = 0; i < linkedListSlave.size() - 1;) {
                    Integer integer = linkedListSlave.pollLast();
                    linkedListMater.push(integer);
                }
                return linkedListSlave.pollLast();
            } else if (linkedListSlave.isEmpty() && !linkedListMater.isEmpty()) {
                for (int i = 0; i < linkedListMater.size() - 1;) {
                    Integer integer = linkedListMater.pollLast();
                    linkedListSlave.push(integer);
                }
                return linkedListMater.pollLast();
            } else {
                throw new RuntimeException("stack error...");
            }
        }

        /** Get the top element. */
        public int top() {
            if (empty()) {
                throw new RuntimeException("stack is empty...");
            } else if (linkedListMater.isEmpty() && !linkedListSlave.isEmpty()) {
                int top = 0;
                while (!linkedListSlave.isEmpty()) {
                    top = linkedListSlave.pollLast();
                    linkedListMater.push(top);
                }
                return top;
            } else if (linkedListSlave.isEmpty() && !linkedListMater.isEmpty()) {
                int top = 0;
                while (!linkedListMater.isEmpty()) {
                    top = linkedListMater.pollLast();
                    linkedListSlave.push(top);
                }
                return top;
            } else {
                throw new RuntimeException("stack error...");
            }
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return linkedListMater.isEmpty() && linkedListSlave.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
