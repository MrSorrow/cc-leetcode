package internship.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 求组合最大值
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/3/10 4:45 PM
 * @project: cc-leetcode
 */
public class MinNum {

    /**
     * 有两个数组a和b，亮度为num，
     * 求 sum(a[i]*b[j]) 最大值
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int num = scanner.nextInt();

            int[] arrayA = new int[num];
            int[] arrayB = new int[num];

            for (int i = 0; i < num; i++) {
                arrayA[i] = scanner.nextInt();
            }

            for (int i = 0; i < num; i++) {
                arrayB[i] = scanner.nextInt();
            }

            if (num <= 0) {
                System.out.println(0);
            } else {
                Arrays.sort(arrayA);
                Arrays.sort(arrayB);

                int sum = 0;

                for (int i = 0; i < num; i++) {
                    sum += arrayA[i] * arrayB[num - 1 - i];
                }
                System.out.println(sum);
            }
    }

}
