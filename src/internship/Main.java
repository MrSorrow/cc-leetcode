package internship;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // int[] a = {5,1,2,3};
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[][] h = new int[n][m];
            // System.out.println(n+","+m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    h[i][j] = input.nextInt();
                }
            }

            int n1 = input.nextInt();
            int m1 = input.nextInt();
            int n2 = input.nextInt();
            int m2 = input.nextInt();

            //System.out.println(n1+","+m1);
            //System.out.println(n2+","+m2);

            int result = h[n2][m2];
            int count = 0;

            Queue<int[]> queue = new LinkedList<>();
            int[] start = {n1, m1};
            queue.offer(start);

            while (!queue.isEmpty()) {

                int size = queue.size();

                for (int i = 1; i <= size; i++) {
                    int[] tmp = queue.poll();
                    int tn = tmp[0];
                    int tm = tmp[1];

                    if(tn - 1 >= 0 && h[tn - 1][tm] > h[tn][tm]) {
                        if(h[tn - 1][tm] == result) {
                            count++;
                        } else if(h[tn - 1][tm] < result) {
                            int[] step = {tn - 1, tm};
                            queue.offer(step);
                        }
                    }

                    if(tn + 1 <= n - 1 && h[tn + 1][tm] > h[tn][tm]) {
                        if(h[tn + 1][tm] == result) {
                            count++;
                        } else if(h[tn + 1][tm] < result) {
                            int[] step = {tn + 1, tm};
                            queue.offer(step);
                        }
                    }

                    if(tm - 1 >= 0 && h[tn][tm - 1] > h[tn][tm]) {
                        if(h[tn][tm - 1] == result) {
                            count++;
                        } else if(h[tn][tm - 1] < result) {
                            int[] step = {tn, tm - 1};
                            queue.offer(step);
                        }
                    }

                    if(tm + 1 <= m - 1 && h[tn][tm + 1] > h[tn][tm]) {
                        if(h[tn][tm + 1] == result) {
                            count++;
                        } else if(h[tn][tm + 1] < result) {
                            int[] step = {tn, tm + 1};
                            queue.offer(step);
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}