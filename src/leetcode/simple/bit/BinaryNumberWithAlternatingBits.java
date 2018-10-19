package leetcode.simple.bit;

/**
 * @description: 693. 交替位二进制数
 * @see: <a>https://leetcode-cn.com/problems/binary-number-with-alternating-bits/</a>
 * @author: guoping wang
 * @date: 2018/10/19 8:53
 * @project: cc-leetcode
 */
public class BinaryNumberWithAlternatingBits {

    /**
     * 个人常规解法：转成字符串遍历
     * 15ms 55.35%
     * @param n
     * @return
     */
    public boolean hasAlternatingBitsString(int n) {
        String binaryString = Integer.toBinaryString(n);
        for (int i = 0; i < binaryString.length() - 1; i++) {
            if (binaryString.charAt(i) == binaryString.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 个人常规解法：向用移位进行异或，判断结果
     * 10ms 98.43%
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n >>> 1);

        boolean hasZeroNum = false;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            if (bit == 1) {
                if (hasZeroNum) {
                    return false;
                }
            } else {
                hasZeroNum = true;
            }
        }
        return true;
    }

    /**
     * 最好算法：向用移位进行异或，判断结果，判断的方式有讲究
     * 7ms 100%
     * @param n
     * @return
     */
    public boolean hasAlternatingBitsBest(int n) {
        n = n ^ (n >>> 1);
        return (n & (n + 1)) == 0;
    }
}
