package leetcode.simple.math;

/**
 * @description: 883.三维形体投影面积
 * @see: <a>https://leetcode-cn.com/problems/projection-area-of-3d-shapes/</a>
 * @author: guoping wang
 * @date: 2018/10/28 19:10
 * @project: cc-leetcode
 */
public class ProjectionAreaOf3DShapes {

    /**
     * 个人常规解法：转化题意，分别求两种最大值和一次计数
     * 6ms 100%
     * @param grid
     * @return
     */
    public int projectionArea(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int maxInSameX = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    result++;
                }
                if (grid[i][j] > maxInSameX) {
                    maxInSameX = grid[i][j];
                }
            }
            result += maxInSameX;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int maxInSameY = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] > maxInSameY) {
                    maxInSameY = grid[j][i];
                }
            }
            result += maxInSameY;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{2}};
        System.out.println(new ProjectionAreaOf3DShapes().projectionArea(grid));
    }
}
