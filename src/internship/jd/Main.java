package internship.jd;

/**
6
2 1
3 2
4 3
5 2
6 1
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            HashMap<Integer, Node> map = new HashMap<>(num);

            for (int i = 0; i < num; i++) {
                map.put(i + 1, new Node(i + 1));
            }

            // 构建树
            for (int i = 0; i < num - 1; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int min = Math.min(x, y);
                int max = Math.max(x, y);
                Node root = map.get(min);
                root.addNext(map.get(max));
            }

            // 获取1号
            if (map.get(1) == null) {
                System.out.println(0);
                continue;
            }

            Node root = map.get(1);

            int[] queues = new int[root.next.size()];
            for (int i = 0; i < queues.length; i++) {
                queues[i] = counter(root.next.get(i));
            }

            Arrays.sort(queues);

            if (queues.length <= 2) {
                System.out.println(queues[queues.length - 1]);
            } else {
                int res = 0;
                // 多个出队
                while (queues[queues.length - 2] > 0) {
                    res += queues[queues.length - 2];
                    queues[queues.length - 1] = queues[queues.length - 1] - queues[queues.length - 2];
                    queues[queues.length - 2] = 0;
                    Arrays.sort(queues);
                }
                System.out.println(res + queues[queues.length - 1]);
            }
        }
    }

    private static int counter(Node node) {
        if (node.next.size() == 0) return 1;
        int res = 1;
        for (Node sub : node.next) {
            res += counter(sub);
        }
        return res;
    }

    static class Node {
        int x;
        List<Node> next = new ArrayList<>();

        public Node(int x) {
            this.x = x;
        }

        public void addNext(Node next) {
            this.next.add(next);
        }

        @Override
        public String toString() {
            return x + "";
        }
    }
}
