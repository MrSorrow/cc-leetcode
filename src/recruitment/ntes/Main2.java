package recruitment.ntes;

import java.util.Scanner;

/**
 * @description: 网易第二道
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/9/21 3:28 PM
 * @project: cc-leetcode
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();

            System.out.println(count(A, B, p, q));
        }
    }

    private static int count(int a, int b, int p, int q) {
        if (a >= b) {
            return 0;
        }
        if (a + p >= b) {
            return 1;
        }
        return 1 + Math.min(count(a + p, b, p, q), count(a, b, p * q, q));
    }
}
