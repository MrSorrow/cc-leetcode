package leetcode.simple.stack;

import java.util.Stack;

/**
 * @description: 844. 比较含退格的字符串
 * @link: <a>https://leetcode-cn.com/problems/backspace-string-compare/description/</a>
 * @author: guoping wang
 * @date: 2018/9/17 16:58
 * @project: cc-leetcode
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        String S = "y#fo##f";
        String T = "y#f#o##f";
        System.out.println(new BackspaceStringCompare().backspaceCompare(S, T));
    }

    /**
     * 个人常规解法：栈的应用
     * 11ms 69.68%
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stackS.isEmpty() && S.charAt(i) == '#') {
                stackS.pop();
            } else if (S.charAt(i) != '#') {
                stackS.push(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (!stackT.isEmpty() && T.charAt(i) == '#') {
                stackT.pop();
            } else if (T.charAt(i) != '#') {
                stackT.push(T.charAt(i));
            }
        }
        // 判断栈是否一样
        if (stackS.size() != stackT.size()) {
            return false;
        } else {
            while (!stackS.isEmpty()) {
                if (!stackS.pop().equals(stackT.pop())) {
                    return false;
                }
            }
            return true;
        }
    }
}
