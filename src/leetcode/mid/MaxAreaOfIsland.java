package leetcode.mid;

/**
 * @description: 695. 岛屿的最大面积
 * @see: <a>https://leetcode-cn.com/problems/max-area-of-island/</a>
 * @author: guoping wang
 * @date: 2019/3/4 13:01
 * @project: cc-leetcode
 */
public class MaxAreaOfIsland {

    int[][] grid = null;

    /**
     * 个人常规解法：其实就是求最大连通子图，DFS求每一个连通子图的面积
     * 36ms 73.89%
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int b = maxAreaOfIsland(i, j, 0);
                max = Math.max(max, b);
            }
        }

        return max;
    }

    private int maxAreaOfIsland(int row, int col, int count) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return count;
        }
        grid[row][col] = 0;
        count++;
        count = maxAreaOfIsland(row - 1, col, count);
        count = maxAreaOfIsland(row + 1, col, count);
        count = maxAreaOfIsland(row, col - 1, count);
        count = maxAreaOfIsland(row, col + 1, count);
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }
}
