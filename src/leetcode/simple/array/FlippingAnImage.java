package leetcode.simple.array;

/**
 * @description: 832. 翻转图像
 * @see: <a>https://leetcode-cn.com/problems/flipping-an-image/</a>
 * @author: guoping wang
 * @date: 2018/12/4 15:07
 * @project: cc-leetcode
 */
public class FlippingAnImage {

    /**
     * 个人常规解法：找到对应的变换关系
     * 5ms 97.46%
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] res = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                res[i][A[j].length - 1 - j] = 1 - A[i][j];
            }
        }

        return res;
    }
}
