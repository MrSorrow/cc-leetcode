package recruitment.bytedance;

import java.util.Scanner;

/**
 * @description:
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/9/22 8:02 AM
 * @project: cc-leetcode
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String str = scanner.nextLine();
        if (str.length() != n) {
            throw new IllegalArgumentException("参数错误");
        }

        int[] wc = findWc(str);
        for (int i = 0; i < n; i++) {
            System.out.print(wc[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }


    }

    private static int[] findWc(String str) {

        int[] res = new int[str.length()];

        int index = str.indexOf("O");
        res[index] = 0;
        for (int i = index - 1; i >= 0; i--) {
            res[i] = res[i + 1] + 1;
        }


        for (int i = index + 1; i < str.length(); i++) {
            // 修正数据
            if (str.charAt(i) == 'O') {
                res[i]= 0;
                for (int j = i - 1; j > index; j--) {
                    if (res[j + 1] + 1 > res[j]) {
                        break;
                    }
                    res[j] = res[j + 1] + 1;
                }
            } else {
                res[i] = res[i - 1] + 1;
            }
        }

        return res;
    }
}
