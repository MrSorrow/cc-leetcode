package leetcode.mid;

import utils.ArrayUtils;

/**
 * @description: 48. 旋转图像
 * @see: <a>https://leetcode-cn.com/problems/rotate-image/</a>
 * @author: guoping wang
 * @date: 2019/1/7 10:51
 * @project: cc-leetcode
 */
public class RotateImage {

    /**
     * 个人常规解法：不断的通过公式进行替换 [row][col]——>[col][matrix.length - 1 - row]
     * 1ms 100%
     * @param matrix
     */
    public int[][] rotate(int[][] matrix) {
        // 外循环表示需要遍历的圈层
        for (int i = 0; i < matrix.length / 2; i++) {
            // 每个圈层有几个圈
            for (int j = i; j < matrix.length - i - 1; j++) {
                int row = i, col = j, lastTemp = matrix[row][col], newTemp = 0;
                // 每个圈交换4次
                for (int k = 0; k < 4; k++) {
                    int rowCopy = row;
                    row = col;
                    col = matrix.length - 1 - rowCopy;
                    newTemp = matrix[row][col];
                    matrix[row][col] = lastTemp;
                    lastTemp = newTemp;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        ArrayUtils.printInt2DArray(new RotateImage().rotate(matrix));
    }
}
