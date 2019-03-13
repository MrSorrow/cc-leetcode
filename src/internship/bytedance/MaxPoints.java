package internship.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: guoping wang
 * @date: 2019/3/13 11:16
 * @project: cc-leetcode
 */
public class MaxPoints {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Point[] points = new Point[num];
        for (int i = 0; i < num; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(points);

        long lastX = points[0].x + 1, lastY = points[0].y - 1;
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if (points[i].x < lastX) {
                lastX = points[i].x;
                if (lastY <= points[i].y) {
                    lastY = points[i].y;
                    list.add(points[i]);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(list.size() - i - 1));
        }
    }

    public static class Point implements Comparable<Point> {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Point o) {
            if (x != o.x) return o.x > x ? 1 : -1;
            else return o.y > y ? 1 : -1;
        }
    }
}
