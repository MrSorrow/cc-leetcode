package leetcode.simple.math;

/**
 * @description: 598.范围求和 II
 * @see: <a>https://leetcode-cn.com/problems/range-addition-ii/</a>
 * @author: guoping wang
 * @date: 2018/10/27 22:13
 * @project: cc-leetcode
 */
public class RangeAdditionII {

    /**
     * 个人常规解法：按照题目要求，只需要求出最小的公共区域即可，同时起点已经确定
     * 4ms 100%
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;
        for (int i = 0; i < ops.length; i++) {
            minRow = ops[i][0] < minRow ? ops[i][0] : minRow;
            minCol = ops[i][1] < minCol ? ops[i][1] : minCol;
        }
        return minRow * minCol;
    }
}
