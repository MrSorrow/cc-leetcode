package leetcode.simple.other;

/**
 * @description: 908. 最小差值 I
 * @see: <a>https://leetcode-cn.com/problems/smallest-range-i/</a>
 * @author: guoping wang
 * @date: 2018/12/16 22:12
 * @project: cc-leetcode
 */
public class SmallestRangeI {

    /**
     * 个人常规解法：其实就是找最大最小值
     * 5ms 100%
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max - min > 2 * K ? max - min - 2 * K : 0;
    }
}
