package leetcode.mid;

import leetcode.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 54. 螺旋矩阵
 * @see: <a>https://leetcode-cn.com/problems/spiral-matrix/</a>
 * @author: guoping wang
 * @date: 2019/1/9 12:58
 * @project: cc-leetcode
 */
public class SpiralMatrix {

    /**
     * 个人常规解法：递归
     * 2ms 91.73%
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>(matrix.length == 0 ? 0 : matrix.length * matrix[0].length);
        spiralOrder(matrix, res, 0, 0, matrix.length - 1, matrix.length == 0 ? -1 : matrix[0].length - 1);
        return res;
    }

    private void spiralOrder(int[][] matrix, List<Integer> res, int startRow, int startCol, int endRow, int endCol) {
        if (startRow > endRow || startCol > endCol)
            return;
        else if (startRow == endRow) {
            for (int i = startCol; i <= endCol; i++) {
                res.add(matrix[startRow][i]);
            }
            return;
        } else if (startCol == endCol) {
            for (int i = startRow; i <= endRow; i++) {
                res.add(matrix[i][endCol]);
            }
            return;
        } else {
            for (int i = startCol; i <= endCol; i++) {
                res.add(matrix[startRow][i]);
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                res.add(matrix[i][endCol]);
            }
            for (int i = endCol - 1; i >= startCol; i--) {
                res.add(matrix[endRow][i]);
            }
            for (int i = endRow - 1; i > startRow; i--) {
                res.add(matrix[i][startCol]);
            }
        }

        spiralOrder(matrix, res, startRow + 1, startCol + 1, endRow - 1, endCol - 1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5,6,7,8,9,10}, {1,2,3,4,5,6,7,8,9,10}};
        ListUtils.printLists(new SpiralMatrix().spiralOrder(matrix));
    }
}
