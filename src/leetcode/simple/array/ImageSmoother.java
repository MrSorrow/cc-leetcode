package leetcode.simple.array;

import utils.ArrayUtils;

/**
 * @description: 661. 图片平滑器
 * @link: <a>https://leetcode-cn.com/problems/image-smoother/description/</a>
 * @author: guoping wang
 * @date: 2018/9/3 16:40
 * @project: cc-leetcode
 */
public class ImageSmoother {

    public static void main(String[] args) {
        int[][] M = {{2,3,4}, {5,6,7}, {8,9,10},{11,12,13},{14,15,16}};
        ArrayUtils.printInt2DArray(new ImageSmoother().imageSmoother(M));
    }

    /**
     * 个人解法：直接求八零域均值,try-catch捕获异常
     * 483ms 0%
     * @param M
     * @return
     */
    public int[][] imageSmootherTryCatch(int[][] M) {

        int[] temp = {0, 0, 0, 0, 0, 0, 0, 0};
        int[][] result = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int count = 9;
                try {
                    temp[0] = M[i-1][j-1];
                } catch (Exception e) {
                    temp[0] = 0;
                    count--;
                }
                try {
                    temp[1] = M[i-1][j];
                } catch (Exception e) {
                    temp[1] = 0;
                    count--;
                }
                try {
                    temp[2] = M[i-1][j+1];
                } catch (Exception e) {
                    temp[2] = 0;
                    count--;
                }
                try {
                    temp[3] = M[i][j-1];
                } catch (Exception e) {
                    temp[3] = 0;
                    count--;
                }
                try {
                    temp[4] = M[i][j+1];
                } catch (Exception e) {
                    temp[4] = 0;
                    count--;
                }
                try {
                    temp[5] = M[i+1][j-1];
                } catch (Exception e) {
                    temp[5] = 0;
                    count--;
                }
                try {
                    temp[6] = M[i+1][j];
                } catch (Exception e) {
                    temp[6] = 0;
                    count--;
                }
                try {
                    temp[7] = M[i+1][j+1];
                } catch (Exception e) {
                    temp[7] = 0;
                    count--;
                }
                result[i][j] = (int) Math.floor((temp[0] + temp[1] + temp[2] + temp[3] + temp[4] + temp[5] + temp[6] + temp[7] + M[i][j]) * 1.0 / count);
            }
        }
        return result;
    }

    /**
     * 最优解法：没有就continue
     * 26ms 83.97%
     * @param M
     * @return
     */
    public int[][] imageSmoother(int[][] M) {

        int[][] result = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                result[i][j] = smooth(M, i, j);
            }
        }

        return result;
    }

    private int smooth(int[][] m, int i, int j) {
        int sum = 0, count = 0;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (i + k < 0 || i + k >= m.length || j + l < 0 || j + l >= m[0].length) {
                    continue;
                }
                count++;
                sum += m[i + k][j + l];
            }
        }
        return sum / count;
    }
}
