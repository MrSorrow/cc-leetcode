package leetcode.simple.stack;

import java.util.Stack;

/**
 * @description: 20. 有效的括号
 * @link: <a>https://leetcode-cn.com/problems/valid-parentheses/description/</a>
 * @author: guoping wang
 * @date: 2018/9/13 10:29
 * @project: cc-leetcode
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("]"));
    }

    /**
     * 个人解法：用栈，左括号进栈，右括号出栈
     * 7ms 95.90%
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(' || charArray[i] == '{' || charArray[i] == '[') {
                stack.push(charArray[i]);
            } else if (charArray[i] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (charArray[i] == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (charArray[i] == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
