package leetcode.simple.bit;

/**
 * @description: 342. 4的幂
 * @see: <a>https://leetcode-cn.com/problems/power-of-four/</a>
 * @author: guoping wang
 * @date: 2018/10/17 15:44
 * @project: cc-leetcode
 */
public class PowerOfFour {

    /**
     * 个人常规解法：只能偶数位上有一个1
     * 1ms 100%
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {

        boolean first = false;

        for (int i = 0; i < 32; i++) {
            int low = num & 1;
            if (low == 1) {
                if (i % 2 == 1) {
                    return false;
                } else {
                    if (!first)
                        first = true;
                    else
                        return false;
                }
            }
            num >>>= 1;
        }
        if (first)
            return true;
        return false;
    }
}
