package leetcode.mid;

/**
 * @description: 64. 最小路径和
 * @see: <a>https://leetcode-cn.com/problems/minimum-path-sum/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/1/23 9:40 PM
 * @project: cc-leetcode
 */
public class MinimumPathSum {

    /**
     * 个人常规解法：回溯穷举
     * 超时：25/61
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int sum = 0;
        backTrack(grid, sum, 0, 0);
        return min;
    }

    private int min = Integer.MAX_VALUE;

    public void backTrack(int[][] grid, int sum, int startX, int startY) {
        if (startY + startX >= grid[0].length + grid.length - 1) {
            if (sum < min) {
                min = sum;
            }
        }
        if (startX < grid[0].length - 1 || (startX < grid[0].length && startY == grid.length - 1)) {
            backTrack(grid, sum + grid[startY][startX], startX + 1, startY);
        }
        if ((startY < grid.length && startX == grid[0].length - 1) || startY < grid.length - 1) {
            backTrack(grid, sum + grid[startY][startX], startX, startY + 1);
        }
    }

    /**
     * 个人常规解法：动态规划，求出到每一个点的最短距离即可
     * 6ms 94.22%
     * @param grid
     * @return
     */
    public int minPathSumDp(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (i == 0) {
                    if (j == 0) res[i][j] = grid[i][j];
                    else res[i][j] = res[i][j - 1] + grid[i][j];
                } else {
                    if (j == 0) res[i][j] = grid[i][j] + res[i - 1][j];
                    else res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
                }
            }
        }
        return res[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},
                        {0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},
                        {8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},
                        {1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},
                        {8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},
                        {4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},
                        {6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},
                        {8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},
                        {9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},
                        {0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},
                        {4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},
                        {2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},
                        {0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},
                        {0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},
                        {6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},
                        {7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},
                        {3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},
                        {5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}};
        System.out.println(new MinimumPathSum().minPathSumDp(grid));
    }
}
