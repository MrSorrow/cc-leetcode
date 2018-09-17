package leetcode.simple.stack;

import java.util.Stack;

/**
 * @description: 682. 棒球比赛
 * @link: <a>https://leetcode-cn.com/problems/baseball-game/description/</a>
 * @author: guoping wang
 * @date: 2018/9/17 14:23
 * @project: cc-leetcode
 */
public class BaseballGame {

    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(new BaseballGame().calPoints(ops));
    }

    /**
     * 个人常规解法：栈的应用
     * 7ms 94.03%
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "+":
                    if (stack.size() > 1) {
                        stack.push(stack.get(stack.size() - 2) + stack.peek());
                    }
                    break;

                case "D":
                    if (!stack.isEmpty()) {
                        stack.push(stack.peek() * 2);
                    }
                    break;

                case "C":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;

                default:
                    Integer score = Integer.valueOf(ops[i]);
                    stack.push(score);
                    break;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
