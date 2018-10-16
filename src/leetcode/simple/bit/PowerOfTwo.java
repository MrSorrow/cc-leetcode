package leetcode.simple.bit;

/**
 * @description: 231. 2的幂
 * @see: <a>https://leetcode-cn.com/problems/power-of-two/</a>
 * @author: guoping wang
 * @date: 2018/10/16 13:29
 * @project: cc-leetcode
 */
public class PowerOfTwo {

    /**
     * 个人常规解法：二进制表示时只有一个1
     * 1ms 100%
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return true;
        boolean hasOne = false;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (hasOne) {
                    return false;
                }
                hasOne = true;
            }
            n >>>= 1;
        }
        return true;
    }
}
