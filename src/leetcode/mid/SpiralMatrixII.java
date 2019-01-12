package leetcode.mid;

import leetcode.utils.ArrayUtils;

/**
 * @description: 59. 螺旋矩阵 II
 * @see: <a>https://leetcode-cn.com/problems/spiral-matrix-ii/</a>
 * @author: guoping wang
 * @date: 2019/1/12 20:32
 * @project: cc-leetcode
 */
public class SpiralMatrixII {

    /**
     * 个人常规解法：递归赋值每一圈的值
     * 2ms 83.63%
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        for (int i = 0; i < n / 2; i++) {
            num = generateMatrix(res, i, num);
        }
        if (n % 2 == 1) {
            res[n / 2][n / 2] = n * n;
        }
        return res;
    }

    private int generateMatrix(int[][] res, int start, int num) {
        for (int i = start; i < res.length - start; i++) {
            res[start][i] = num++;
        }
        for (int i = start + 1; i < res.length - start; i++) {
            res[i][res.length - start - 1] = num++;
        }
        for (int i = res.length - start - 2; i >= start; i--) {
            res[res.length - start - 1][i] = num++;
        }
        for (int i = res.length - start - 2; i > start; i--) {
            res[i][start] = num++;
        }
        return num;
    }

    public static void main(String[] args) {
        ArrayUtils.printInt2DArray(new SpiralMatrixII().generateMatrix(5));
    }
}
