package recruitment.aiqiyi;

import java.util.*;

/**
 * @description:
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/9/18 7:49 PM
 * @project: cc-leetcode
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = 1 << n;
        int[] A = new int[k];
        for (int i = 0; i < k; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int index = scanner.nextInt();
            int newValue = scanner.nextInt();
            A[index - 1] = newValue;
            System.out.println(computeV(Arrays.copyOf(A, k), k));
        }
    }

    private static int computeV(int[] array, int end) {
        if (end == 1) {
            return array[0];
        }

        for (int i = 0; i < end / 2; i++) {
            array[i] = array[i * 2] | array[i * 2 + 1];
        }

        for (int i = 0; i < end / 4; i++) {
            array[i] = array[i * 2] ^ array[i * 2 + 1];
        }
        return computeV(array, end / 4);
    }
}
