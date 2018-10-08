package leetcode.simple.hash;

import java.util.HashMap;

/**
 * @description: 447. 回旋镖的数量
 * @see: <a>https://leetcode-cn.com/problems/number-of-boomerangs/</a>
 * @author: guoping wang
 * @date: 2018/10/7 16:44
 * @project: cc-leetcode
 */
public class NumberOfBoomerangs {

    /**
     * 常规解法：所有组合情况遍历
     * 461ms 8.57%
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {

        int count = 0;

        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int[] firstPoint = points[i];
                    int[] secondPoint = points[j];
                    int[] thirdPoint = points[k];

                    int f2s = (firstPoint[0] - secondPoint[0]) * (firstPoint[0] - secondPoint[0]) + (firstPoint[1] - secondPoint[1]) * (firstPoint[1] - secondPoint[1]);
                    int s2t = (thirdPoint[0] - secondPoint[0]) * (thirdPoint[0] - secondPoint[0]) + (thirdPoint[1] - secondPoint[1]) * (thirdPoint[1] - secondPoint[1]);
                    int f2t = (firstPoint[0] - thirdPoint[0]) * (firstPoint[0] - thirdPoint[0]) + (firstPoint[1] - thirdPoint[1]) * (firstPoint[1] - thirdPoint[1]);

                    if (f2s == f2t) {
                        count += 2;
                    }
                    if (f2s == s2t) {
                        count += 2;
                    }
                    if (f2t == s2t) {
                        count += 2;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 计数两两，有相等的就计数
     * 147ms 89.34
     * @param points
     * @return
     */
    public int numberOfBoomerangsCountTwo(int[][] points) {

        int count = 0, temp = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int[] firstPoint = points[i];
                int[] secondPoint = points[j];

                int dis = (firstPoint[0] - secondPoint[0]) * (firstPoint[0] - secondPoint[0]) + (firstPoint[1] - secondPoint[1]) * (firstPoint[1] - secondPoint[1]);

                if (dis != 0) {
                    if (hashMap.containsKey(dis)) {
                        temp += hashMap.get(dis); // 着重理解这里：每次找到一个新的点，组合就是，新点，当前点，和之前所有可能点
                        hashMap.put(dis, hashMap.get(dis) + 1);
                    } else {
                        hashMap.put(dis, 1);
                    }
                }
            }
            count += temp * 2;
            temp = 0;
            hashMap.clear();
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        System.out.println(new NumberOfBoomerangs().numberOfBoomerangs(points));
        System.out.println(new NumberOfBoomerangs().numberOfBoomerangsCountTwo(points));
    }
}
