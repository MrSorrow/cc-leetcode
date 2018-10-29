package leetcode.simple.math;

/**
 * @description: 892.三维形体的表面积
 * @see: <a>https://leetcode-cn.com/problems/surface-area-of-3d-shapes/</a>
 * @author: guoping wang
 * @date: 2018/10/29 10:29
 * @project: cc-leetcode
 */
public class SurfaceAreaOf3DShapes {

    /**
     * 个人常规解法：一个正方体表面积为6，每两个相邻就会减去2，分别计算三个维度减了多少
     * 9ms 96.37%
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        int res = 0;
        int N = grid.length;

        // 计算z维度减去量
        for (int i = 0; i < N; i++) {
            int x = 0, y = 0;
            for (int j = 0; j < N; j++) {
                res += grid[i][j] * 6;  // 每个正方体有6个面
                if (grid[i][j] > 1) {
                    res -= (grid[i][j] - 1) * 2;  // z纬度的减去
                }
                if (j < N - 1) {
                    x += Math.min(grid[i][j], grid[i][j + 1]);
                    y += Math.min(grid[j][i], grid[j + 1][i]);
                }
            }
            res -= x * 2;
            res -= y * 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2}, {3,4}};
        System.out.println(new SurfaceAreaOf3DShapes().surfaceArea(grid));
    }
}
