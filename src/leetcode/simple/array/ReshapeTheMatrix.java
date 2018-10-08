package leetcode.simple.array;

import leetcode.utils.ArrayUtils;

/**
 * @description: 566. 重塑矩阵
 * @link: <a>https://leetcode-cn.com/problems/reshape-the-matrix/description/</a>
 * @author: guoping wang
 * @date: 2018/8/30 9:23
 * @project: cc-leetcode
 */
public class ReshapeTheMatrix {

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}, {1, 2}, {3, 4}};
        ArrayUtils.printInt2DArray(new ReshapeTheMatrix().matrixReshapeDirect(nums, 2, 4));
        ArrayUtils.printInt2DArray(new ReshapeTheMatrix().matrixReshapeTemp(nums, 2, 4));
    }

    /**
     * 个人常规解法：先全部展开为一维数组，然后再整成新维度数组
     * 6ms 100%
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshapeTemp(int[][] nums, int r, int c) {
        // 如果不能reshape，则直接返回
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[] temp = new int[r * c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                temp[i * nums[0].length + j] = nums[i][j];
            }
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = temp[i * c + j];
            }
        }
        return result;
    }

    /**
     * 个人常规解法：直接换算两者的索引关系
     * 7ms 91.54%
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshapeDirect(int[][] nums, int r, int c) {
        // 如果不能reshape，则直接返回
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[(i * c + j) / nums[0].length][(i * c + j) % nums[0].length];
            }
        }
        return result;
    }
}
