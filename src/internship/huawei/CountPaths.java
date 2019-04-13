package internship.huawei;

import java.util.*;

/**
 * 统计A->B两点的路径数量
 */
public class CountPaths {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        int Ax = scanner.nextInt(), Ay = scanner.nextInt();
        int Bx = scanner.nextInt(), By = scanner.nextInt();

        int result = map[Bx][By];
        int count = 0;

        LinkedList<int[]> queue = new LinkedList<>();
        int[] A = {Ax, Ay};
        queue.offer(A);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 1; i <= size; i++) {
                int[] pos = queue.poll();
                int tX = pos[0];
                int tY = pos[1];

                count = getCount(N, M, map, result, count, queue, tX, tY);
            }
        }
        System.out.println(count);
    }

    private static int getCount(int N, int M, int[][] map, int result, int count, LinkedList<int[]> queue, int tX, int tY) {
        if(tX - 1 >= 0 && map[tX - 1][tY] > map[tX][tY]) {
            if(map[tX - 1][tY] == result) {
                count++;
            } else if(map[tX - 1][tY] < result) {
                int[] step = {tX - 1, tY};
                queue.offer(step);
            }
        }

        if(tX + 1 <= N - 1 && map[tX + 1][tY] > map[tX][tY]) {
            if(map[tX + 1][tY] == result) {
                count++;
            } else if(map[tX + 1][tY] < result) {
                int[] step = {tX + 1, tY};
                queue.offer(step);
            }
        }

        if(tY - 1 >= 0 && map[tX][tY - 1] > map[tX][tY]) {
            if(map[tX][tY - 1] == result) {
                count++;
            } else if(map[tX][tY - 1] < result) {
                int[] step = {tX, tY - 1};
                queue.offer(step);
            }
        }

        if(tY + 1 <= M - 1 && map[tX][tY + 1] > map[tX][tY]) {
            if(map[tX][tY + 1] == result) {
                count++;
            } else if(map[tX][tY + 1] < result) {
                int[] step = {tX, tY + 1};
                queue.offer(step);
            }
        }
        return count;
    }
}
