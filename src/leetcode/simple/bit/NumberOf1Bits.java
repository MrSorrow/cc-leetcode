package leetcode.simple.bit;

/**
 * @description: 191. 位1的个数
 * @see: <a>https://leetcode-cn.com/problems/number-of-1-bits/</a>
 * @author: guoping wang
 * @date: 2018/10/16 13:22
 * @project: cc-leetcode
 */
public class NumberOf1Bits {

    /**
     * 个人常规解法：不断的转置统计个数
     * 3ms 40.09%
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int dis = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                dis ++;
            }
            n = n >>> 1;
        }
        return dis;
    }
}
