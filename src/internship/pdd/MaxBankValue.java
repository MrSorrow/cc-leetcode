package internship.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 偷银行最大价值
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/3/10 5:05 PM
 * @project: cc-leetcode
 */
public class MaxBankValue {

    /**
     * 有bankNum个银行，每个银行的坐标是pos，偷该银行的价值为value
     * 要求偷的两个银行pos距离大于d，最大的价值是多少
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bankNum = scanner.nextInt();
        int d = scanner.nextInt();

        Bank[] banks = new Bank[bankNum];

        for (int i = 0; i < bankNum; i++) {
            banks[i] = new Bank(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(banks);

        int max = 0;

        for (int i = 0; i < bankNum - 1; i++) {
            for (int j = i + 1; j < bankNum; j++) {
                int value = banks[i].value + banks[j].value;
                if (value <= max) {
                    break;
                } else {
                    if (Math.abs(banks[i].pos - banks[j].pos) >= d) {
                        max = value;
                    }
                }
            }
        }


        System.out.print(max);
    }

    static class Bank implements Comparable<Bank> {
        int pos;
        int value;

        public Bank(int pos, int value) {
            this.pos = pos;
            this.value = value;
        }

        @Override
        public int compareTo(Bank o) {
            return o.value - value;
        }
    }
}

/*
6 3
1 1
3 5
4 8
6 4
10 3
11 2
 */
