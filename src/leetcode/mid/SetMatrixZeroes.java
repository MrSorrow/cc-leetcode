package leetcode.mid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 73. 矩阵置零
 * @see: <a>https://leetcode-cn.com/problems/set-matrix-zeroes/</a>
 * @author: guoping wang
 * @date: 2019/3/6 22:21
 * @project: cc-leetcode
 */
public class SetMatrixZeroes {


    /**
     * 个人常规解法：利用额外空间记住所有的0的位置，这属于O(mn)的额外空间，O(m+n)的额外空间方案表示不一次性添加完，找一个添加一个
     * 3ms 62.13%
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int row = queue.remove();
            int col = queue.remove();
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }
    }

    /**
     * 参考解法：利用原本数组的第一行和第一列来记录
     * 1ms 100%
     * @param matrix
     */
    public void setZeroesBest(int[][] matrix) {

        // 第一行第一列共用了标记元素,额外申请一个空间用于标记
        boolean firstLine = false;  // 第一行额外申请空间标记
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstLine = true;
                break;
            }
        }

        // 每一列第个元素是标记，第二行起每一个元素是标记
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 置0的时候要先把第一列空住，每一列置0
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // 置0的时候要先把第一行空住，每一行置0
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 第一列直接查看是否需要置0
        if (matrix.length > 0 && matrix[0][0] == 0) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }

        // 第一行直接查看是否需要置0
        if (firstLine) {
            Arrays.fill(matrix[0], 0);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {0, 1, 2}};
        new SetMatrixZeroes().setZeroesBest(matrix);
    }
}
