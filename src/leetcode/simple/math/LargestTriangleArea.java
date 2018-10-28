package leetcode.simple.math;

/**
 * @description: 812. 最大三角形面积
 * @see: <a>https://leetcode-cn.com/problems/largest-triangle-area/</a>
 * @author: guoping wang
 * @date: 2018/10/28 16:55
 * @project: cc-leetcode
 */
public class LargestTriangleArea {

    /**
     * 个人常规解法：暴力解法，求三角形面积用面积公式
     * 19ms 59.35%
     * @param points
     * @return
     */
    public double largestTriangleAreaViolence(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    // 求三个点的三角形面积
                    double a = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                    double b = Math.sqrt(Math.pow(points[k][0] - points[j][0], 2) + Math.pow(points[k][1] - points[j][1], 2));
                    double c = Math.sqrt(Math.pow(points[i][0] - points[k][0], 2) + Math.pow(points[i][1] - points[k][1], 2));
                    double p = (a + b + c) / 2;
                    double S = p * (p - a) * (p - b) * (p - c);
                    max = S > max ? S : max;
                }
            }
        }
        return Math.sqrt(max);
    }
}
