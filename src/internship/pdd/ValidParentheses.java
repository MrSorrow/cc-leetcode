package internship.pdd;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description: 有效的括号
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/3/10 6:05 PM
 * @project: cc-leetcode
 */
public class ValidParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String b = scanner.nextLine();

        ValidParentheses main = new ValidParentheses();

        int left = 0, right = 0;
        
        int count = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
        }

        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
        }

        if ((a.length() + b.length()) % 2 != 0 || left != right) {
            System.out.println(0);
        } else {
            int[] s = new int[b.length()];

            while (main.sum(s) != b.length() * a.length()) {
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i <= a.length(); i++) {
                    for (int j = 0; j < b.length(); j++) {
                        if (s[j] == i)
                            sb.append(b.charAt(j));

                    }

                    if (i != a.length()) {
                        sb.append(a.charAt(i));
                    }
                }

                if (main.isValid(sb.toString()))
                    count++;

                for (int i = b.length() - 1; i >= 0; i--) {
                    if (s[i] < a.length()) {
                        s[i]++;
                        for (int j = i + 1; j < b.length(); j++) {
                            s[j] = s[i];
                        }
                        break;
                    }

                }
            }

            if (main.isValid(a + b)) {
                count++;
            }
            System.out.println(count);
        }
    }

    public int sum(int[] s) {
        int sum = 0;

        for (int i = 0; i < s.length; i++) {
            sum = sum + s[i];
        }
        return sum;
    }

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(charArray[i]);
            } else if (charArray[i] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
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
