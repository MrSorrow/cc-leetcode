package recruitment.baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 图走路
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/9/17 7:42 PM
 * @project: cc-leetcode
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int group = scanner.nextInt();
        label:
        for (int i = 0; i < group; i++) {

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            // 构造图
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            for (int j = 0; j < m; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                int min = Math.min(start, end);
                int max = Math.max(start, end);
                graph.putIfAbsent(min, new ArrayList<>());
                graph.get(min).add(max);
            }

            // 判断0->n-1是否2步内联通
            if (graph.containsKey(1)) {
                List<Integer> nexts = graph.get(1);
                if (nexts.contains(n)) {
                    System.out.println("POSSIBLE");
                    continue;
                }

                for (Integer next : nexts) {
                    if (graph.containsKey(next) && graph.get(next).contains(n)) {
                        System.out.println("POSSIBLE");
                        break label;
                    }
                }
            }

            System.out.println("IMPOSSIBLE");
        }
    }
}
