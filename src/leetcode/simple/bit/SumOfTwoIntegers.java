package leetcode.simple.bit;

/**
 * @description: 371. 两整数之和
 * @see: <a>https://leetcode-cn.com/problems/sum-of-two-integers/</a>
 * @author: guoping wang
 * @date: 2018/10/17 16:02
 * @project: cc-leetcode
 */
public class SumOfTwoIntegers {

    /**
     * 个人常规解法：用异或可以位运算
     * 0ms 100%
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        int bit = 0; // 进位标记
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int aBit = 1 & (a >> i);
            int bBit = 1 & (b >> i);
            int resBit = aBit ^ bBit ^ bit;
            // 这个判断进位要注意
            if ((aBit == 1 && bBit == 1) || ((aBit == 1 || bBit == 1) && resBit == 0)) {
                bit = 1;
            } else {
                bit = 0;
            }
            res |= (resBit << i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers().getSum(20, 30));
    }

}
