package recruitment.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/9/22 8:29 AM
 * @project: cc-leetcode
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int samples = scanner.nextInt();

        for (int i = 0; i < samples; i++) {

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] times = new int[n];
            for (int j = 0; j < n; j++) {
                times[j] = scanner.nextInt();
            }

            int[] solution = solution(times, n, m);
            printIntArray(solution);
            if (i != samples - 1) {
                System.out.println("");
            }
        }
    }

    private static int[] solution(int[] times, int n, int m) {

        int[] res = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += times[i];

            if (sum <= m) {
                res[i] = 0;
            } else {
                int count = 0, s = sum;
                Arrays.sort(times, 0, i);
                for (int j = i - 1; j >= 0; j--) {
                    s -= times[j];
                    count++;
                    if (s <= m) {
                        break;
                    }
                }
                res[i] = count;
            }
        }

        return res;
    }

    public static void printIntArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
