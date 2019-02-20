package leetcode.mid;

import java.util.Stack;

/**
 * @description: 150. 逆波兰表达式求值
 * @see: <a>https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/</a>
 * @author: guoping wang
 * @date: 2019/2/20 21:33
 * @project: cc-leetcode
 */
public class EvaluateReversePolishNotation {

    /**
     * 个人常规解法：基于栈的方法
     * 17ms 44.51%
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {

        // 创建栈
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int num = stack.pop();
                    stack.push(stack.pop() / num);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }


    public static void main(String[] args) {
        String[] tokens = {"-3", "9", "*"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
    }
}
