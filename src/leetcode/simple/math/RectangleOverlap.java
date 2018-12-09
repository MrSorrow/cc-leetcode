package leetcode.simple.math;

/**
 * @description: 836. 矩形重叠
 * @see: <a>https://leetcode-cn.com/problems/rectangle-overlap/</a>
 * @author: guoping wang
 * @date: 2018/12/9 20:21
 * @project: cc-leetcode
 */
public class RectangleOverlap {

    /**
     * 个人常规解法：求出公共区域坐标
     * 2ms 100%
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] rec = new int[4];
        rec[0] = Math.max(rec1[0], rec2[0]);
        rec[1] = Math.max(rec1[1], rec2[1]);
        rec[2] = Math.min(rec1[2], rec2[2]);
        rec[3] = Math.min(rec1[3], rec2[3]);
        return rec[0] < rec[2] && rec[1] < rec[3];
    }
}
