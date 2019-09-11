package internship.meituan;

import java.util.*;

/**
 * @description:
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/4/23 8:09 PM
 * @project: cc-leetcode
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();

        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
                if ((i + j) % 2 == 1) {
                    map1.put(matrix[i][j], map1.getOrDefault(matrix[i][j], 0) + 1);
                } else {
                    map2.put(matrix[i][j], map2.getOrDefault(matrix[i][j], 0) + 1);
                }
            }
        }

        List<Map.Entry<Integer, Integer>> list1 = new ArrayList<>(map1.entrySet());
        List<Map.Entry<Integer, Integer>> list2 = new ArrayList<>(map2.entrySet());
        list1.sort(comparator);
        list2.sort(comparator);

        if (list1.get(0).getKey() != list2.get(0).getKey()) {
            System.out.println(n * m - list1.get(0).getValue() - list2.get(0).getValue());
        } else {
            if (list1.size() == 1 && list1.size() == 1) {
                int sum = Math.max(list1.get(0).getValue(), list2.get(0).getValue());
                System.out.println(n * m - sum);
            } else if (list1.size() == 1 && list2.size() > 1) {
                int sum = Math.max(list1.get(0).getValue() + list2.get(1).getValue(), list2.get(0).getValue());
                System.out.println(n * m - sum);
            } else if (list2.size() == 1) {
                int sum = Math.max(list1.get(0).getValue(), list1.get(1).getValue() + list2.get(0).getValue());
                System.out.println(n * m - sum);
            } else {
                int sum = Math.max(list1.get(0).getValue() + list2.get(1).getValue(), list1.get(1).getValue() + list2.get(0).getValue());
                System.out.println(n * m - sum);
            }
        }
    }
}
