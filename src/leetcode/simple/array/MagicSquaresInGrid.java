package leetcode.simple.array;

/**
 * @description: 840. 矩阵中的幻方
 * @link: <a>https://leetcode-cn.com/problems/magic-squares-in-grid/description/</a>
 * @author: guoping wang
 * @date: 2018/9/7 17:15
 * @project: cc-leetcode
 */
public class MagicSquaresInGrid {

    public static void main(String[] args) {
        int[][] grid = {{1,8,6}, {10,5,0}, {4,2,9}};
        System.out.println(new MagicSquaresInGrid().numMagicSquaresInside(grid));
    }

    /**
     * 个人解法：遍历
     * 5ms 100%
     * @param grid
     * @return
     */
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if(check(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean check(int[][] grid, int rowStart, int colStart) {
        if (grid[rowStart+1][colStart+1] != 5) {
            return false;
        }

        int[] nums = new int[9];
        for (int i = rowStart; i <= rowStart + 2; i++) {
            for (int j = colStart; j <= colStart + 2; j++) {
                if (grid[i][j] - 1 < 9 && grid[i][j] - 1 >= 0) {
                    nums[grid[i][j] - 1] = 1;
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return false;
            }
        }

        int row1 = grid[rowStart][colStart] + grid[rowStart+1][colStart] + grid[rowStart+2][colStart];
        int row2 = grid[rowStart][colStart+1] + grid[rowStart+1][colStart+1] + grid[rowStart+2][colStart+1];
        int row3 = grid[rowStart][colStart+2] + grid[rowStart+1][colStart+2] + grid[rowStart+2][colStart+2];
        int col1 = grid[rowStart][colStart] + grid[rowStart][colStart+1] + grid[rowStart][colStart+2];
        int col2 = grid[rowStart+1][colStart] + grid[rowStart+1][colStart+1] + grid[rowStart+1][colStart+2];
        int col3 = grid[rowStart+2][colStart] + grid[rowStart+2][colStart+1] + grid[rowStart+2][colStart+2];
        int angle1 = grid[rowStart][colStart] + grid[rowStart+1][colStart+1] + grid[rowStart+2][colStart+2];
        int angle2 = grid[rowStart+2][colStart] + grid[rowStart+1][colStart+1] + grid[rowStart][colStart+2];

        if (row1 == row2 && row2 == row3 && row3 == col1 && col1 == col2
                && col2 == col3 && col3 == angle1 && angle1 == angle2) {
            return true;
        }
        return false;
    }
}
