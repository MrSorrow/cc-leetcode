package internship.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/*
1
6
1 2 3 4 5 6


2
3
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();
        for (int i = 0; i < testNum; i++) {
            int n = scanner.nextInt();
            int[] costs = new int[n];
            for (int j = 0; j < n; j++) {
                costs[j] = scanner.nextInt();
            }
            Arrays.sort(costs);
            System.out.println(solution(costs));
        }
    }

    private static int solution(int[] costs) {
        // 每次过最慢的两个人，两种方案：
        // 最快、次快、再次快->  最快、次快<-  最快、最慢、次慢-> 最快、再次快<-   2个人  2 1 n-1 2
        // 最快、次快、最慢->    最快、次快<-  最快、次快、次慢-> 最快、次快<-     2个人 n-1 1 n-2 1

        int sum = 0;
        int i = costs.length;
        for (; i > 4 ; i-=2) {
            int solution1 = 2 * costs[2] + costs[1] + costs[i - 1];
            int solution2 = 2 * costs[1] + costs[i- 1] + costs[i - 2];
            if (solution1 > solution2) {
                sum += solution2;
            } else {
                sum += solution1;
            }
        }
        if (i == 4) {
            // 最快、最慢、次慢->  最快、次快<-  最快、次快、再次快->  3 1 2
            sum += (costs[1] + costs[2] + costs[3]);
        } else if (i == 3) {
            sum += costs[2];
        } else {
            //
        }

        return sum;
    }
}
