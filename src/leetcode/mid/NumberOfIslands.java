package leetcode.mid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 200. 岛屿的个数
 * @see: <a>https://leetcode-cn.com/problems/number-of-islands/</a>
 * @author: guoping wang
 * @date: 2019/3/4 12:06
 * @project: cc-leetcode
 */
public class NumberOfIslands {

    /**
     * 个人常规解法：通过BFS去寻找连通区域，已寻找的标记为0
     * 20ms 11.94%
     * @param grid
     * @return
     */
    public int numIslandsBFS(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 找到一块陆地进行BFS
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i);
                    queue.add(j);
                    grid[i][j] = '0';

                    while (!queue.isEmpty()) {
                        int row = queue.remove();
                        int col = queue.remove();

                        // 左
                        if (row > 0 && grid[row - 1][col] == '1') {
                            grid[row - 1][col] = '0';
                            queue.add(row - 1);
                            queue.add(col);
                        }

                        // 右
                        if (row < grid.length - 1 && grid[row + 1][col] == '1') {
                            grid[row + 1][col] = '0';
                            queue.add(row + 1);
                            queue.add(col);
                        }

                        // 上
                        if (col > 0 && grid[row][col - 1] == '1') {
                            grid[row][col - 1] = '0';
                            queue.add(row);
                            queue.add(col - 1);
                        }

                        // 下
                        if (col < grid[0].length - 1 && grid[row][col + 1] == '1') {
                            grid[row][col + 1] = '0';
                            queue.add(row);
                            queue.add(col + 1);
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 利用DFS，减少BFS的队列频繁创建与出入
     * 7ms 72.51%
     * @param grid
     * @return
     */
    public int numIslandsDFS(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 找到一块陆地进行DFS
                    numIslandsDFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void numIslandsDFS(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        numIslandsDFS(grid, row - 1, col);
        numIslandsDFS(grid, row + 1, col);
        numIslandsDFS(grid, row, col - 1);
        numIslandsDFS(grid, row, col + 1);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new NumberOfIslands().numIslandsDFS(grid));
    }
}
