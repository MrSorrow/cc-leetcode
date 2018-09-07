package leetcode.simple.array;

/**
 * @description: 867. 转置矩阵
 * @link: <a>https://leetcode-cn.com/problems/transpose-matrix/description/</a>
 * @author: guoping wang
 * @date: 2018/9/7 16:49
 * @project: cc-leetcode
 */
public class TransposeMatrix {

    public static void main(String[] args) {

    }

    /**
     * 个人常规解法：4ms 87.75%
     * @param A
     * @return
     */
    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = A[j][i];
            }
        }

        return res;
    }
}
