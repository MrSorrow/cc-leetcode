package recruitment.yuewen;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 反转数字
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/9/16 7:55 PM
 * @project: cc-leetcode
 */
public class ReverseNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int i = scanner.nextInt();
            System.out.println(reverse(i));
        }
    }

    public static int reverse(int num) {
        StringBuilder sb = new StringBuilder(num+"");
        String str = sb.reverse().toString();

        if (str.endsWith("-")) {
            str = "-" + str.substring(0, str.length() - 1);
        }

        int res = 0;
        try {
            res = Integer.parseInt(str);
        } catch (Exception e) {
        }
        return res;
    }
}
