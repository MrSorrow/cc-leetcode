package leetcode.simple.array;

/**
 * @description: 766. 托普利茨矩阵
 * @link: <a>https://leetcode-cn.com/problems/toeplitz-matrix/description/</a>
 * @author: guoping wang
 * @date: 2018/9/8 21:09
 * @project: cc-leetcode
 */
public class ToeplitzMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(new ToeplitzMatrix().isToeplitzMatrix(matrix));
    }

    /**
     * 个人解法：常规解法
     * 34ms 13.43%
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int times = matrix.length + matrix[0].length - 1;
        for (int i = 0; i < times; i++) {
            int leftRow = 0, leftCol = 0, rightRow = 0, rightCol = 0;
            leftRow = i < matrix.length ? matrix.length - i - 1 : 0;
            leftCol = i < matrix.length ? 0 : i - matrix.length;
            rightRow = i < matrix[0].length ? matrix.length - 1 : matrix.length - i + matrix[0].length;
            rightCol = i < matrix[0].length ? i : matrix[0].length - 1;
            if(!isValid(matrix, leftRow, leftCol, rightRow, rightCol)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检测对角线元素是否一致
     * @param matrix 二维矩阵
     * @param leftRow 左上角所在行
     * @param leftCol 左上角所在列
     * @param rightRow 右上角所在行
     * @param rightCol 右上角所在列
     * @return
     */
    public static boolean isValid(int[][] matrix, int leftRow, int leftCol, int rightRow, int rightCol) {
        for (int i = leftRow + 1, j = leftCol + 1; i <= rightRow && j <= rightCol; i++, j++) {
            if (matrix[i][j] != matrix[leftRow][leftCol]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最快算法：下一行是上一行的一位
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrixBest(int[][] matrix) {
        // 从第二行开始
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
