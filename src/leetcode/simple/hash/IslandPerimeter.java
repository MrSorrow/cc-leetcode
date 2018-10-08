package leetcode.simple.hash;

/**
 * @description: 463. 岛屿的周长
 * @link: <a>https://leetcode-cn.com/problems/island-perimeter/</a>
 * @author: guoping wang
 * @date: 2018/10/8 9:46
 * @project: cc-leetcode
 */
public class IslandPerimeter {

    /**
     * 个人常规解法：查看每一个矩阵元素是否为1,1的上下左右有多少1
     * 100ms 80.61%
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 每一个矩阵元素是否为1
                if (grid[i][j] == 1) {
                    // 判断上下左右
                    if (i - 1 < 0 || grid[i-1][j] == 0) {
                        res++;
                    }
                    if (i + 1 >= grid.length || grid[i+1][j] == 0) {
                        res++;
                    }
                    if (j - 1 < 0 || grid[i][j-1] == 0) {
                        res++;
                    }
                    if (j + 1 >= grid[0].length || grid[i][j+1] == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
