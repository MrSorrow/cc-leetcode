package leetcode.simple.bit;

/**
 * @description: 461. 汉明距离
 * @see: <a>https://leetcode-cn.com/problems/hamming-distance/</a>
 * @author: guoping wang
 * @date: 2018/10/18 22:36
 * @project: cc-leetcode
 */
public class HammingDistance {

    /**
     * 个人常规解法：进行异或，结果统计1的个数
     * 8ms 97.15%
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
