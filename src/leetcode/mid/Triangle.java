package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 120. 三角形最小路径和
 * @see: <a>https://leetcode-cn.com/problems/triangle/</a>
 * @author: guoping wang
 * @date: 2019/4/26 22:22
 * @project: cc-leetcode
 */
public class Triangle {

    /**
     * 个人常规解法：动态规划，后一行的值根据前一行的值推断出来
     * 9ms 39.88%
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        int min = Integer.MAX_VALUE;
        if (triangle.size() == 1) return triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            // 利用上一行的值推断下一行
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int value;
                if (j == 0) {
                    value = triangle.get(i).get(j) + triangle.get(i - 1).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    value = triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1);
                } else {
                    value = triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1));
                }
                triangle.get(i).set(j, value);
                if (i == triangle.size() - 1 && min > value) {
                    min = value;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        triangle.add(row4);
        System.out.println(new Triangle().minimumTotal(triangle));
    }
}
