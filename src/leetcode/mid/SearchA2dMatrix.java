package leetcode.mid;

/**
 * @description: 74. 搜索二维矩阵
 * @see: <a>https://leetcode-cn.com/problems/search-a-2d-matrix/</a>
 * @author: guoping wang
 * @date: 2019/3/7 19:30
 * @project: cc-leetcode
 */
public class SearchA2dMatrix {

    /**
     * 个人常规解法：二分查找
     * 11ms 66.02%
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        return searchMatrix(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }

    private boolean searchMatrix(int[][] matrix, int startRow, int startCol, int endRow, int endCol, int target) {

        int start = startRow * matrix[0].length + startCol;
        int end = endRow * matrix[0].length + endCol;
        if (start > end) return false;

        int midRow = ((start + end) / 2) / matrix[0].length;
        int midCol = ((start + end) / 2) % matrix[0].length;

        if (matrix[midRow][midCol] == target) return true;
        else if (matrix[midRow][midCol] < target) {
            if (midCol == matrix[0].length - 1) {
                midCol = 0;
                midRow++;
            } else {
                midCol++;
            }
            return searchMatrix(matrix, midRow, midCol, endRow, endCol, target);
        }
        else {
            if (midCol == 0) {
                midCol = matrix[0].length - 1;
                midRow--;
            } else {
                midCol--;
            }
            return searchMatrix(matrix, startRow, startCol, midRow, midCol, target);
        }
    }

    public static void main(String[] args) {
        int target = 13;
        int[][] matrix = {{1}};
        System.out.println(new SearchA2dMatrix().searchMatrix(matrix, target));
    }
}
