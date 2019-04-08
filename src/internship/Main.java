package internship;

import java.util.Scanner;

/**
 * @description:
 * @author: guoping wang
 * @date: 2019/4/8 19:35
 * @project: cc-leetcode
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int k = Integer.valueOf(scanner.nextLine());

        if (line.length() > 2) {
            String[] strs = line.substring(1, line.length() - 1).split(",");

            int index = 0;
            StringBuilder sb = new StringBuilder("[");
            while (strs.length - 1 - index >= k) {
                for (int i = index + k - 1; i >= index; i--) {
                    sb.append(strs[i]);
                    if (i != strs.length - 1) sb.append(",");
                }
                index += k;
            }
            if (index < strs.length) {
                for (int i = index; i < strs.length; i++) {
                    sb.append(strs[i]);
                    if (i != strs.length - 1) sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb.toString());

        } else {
            System.out.println(line);
        }
    }
}
