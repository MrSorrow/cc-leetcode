package recruitment.meituan;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/9/18 2:35 PM
 * @project: cc-leetcode
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(compute(input));
        }
    }

    private static String compute(String input) {

        String[] strs = input.split("\\s");
        LinkedList<String> stack = new LinkedList<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            if (stack.isEmpty() && ("and".equals(str) || "or".equals(str))) {
                return "error";
            }

            if ("true".equals(str) || "false".equals(str) || "or".equals(str)) {
                stack.push(str);
            }

            if ("and".equals(str)) {
                String top = stack.pop();
                if (i + 1 >= strs.length) {
                    return "error";
                }
                if ("true".equals(strs[++i]) && "true".equals(top)) {  // i++可能越界
                    stack.push("true");
                } else {
                    stack.push("false");
                }
            }
        }

        if (stack.size() % 2 == 0) {
            return "error";
        }

        LinkedList<String> stack2 = new LinkedList<>();
        for (int i = 0; i < stack.size(); i++) {
            String str = stack.get(i);

            if ("true".equals(str) || "false".equals(str)) {
                stack2.push(str);
            }

            if ("or".equals(str)) {
                if (i + 1 >= stack.size()) {
                    return "error";
                }
                String top = stack2.pop();
                if ("false".equals(stack.get(++i)) && "false".equals(top)) {  // i++可能越界
                    stack2.push("false");
                } else {
                    stack2.push("true");
                }
            }
        }

        if (stack2.size() > 1) {
            return "error";
        }

        return stack2.pop();
    }
}
