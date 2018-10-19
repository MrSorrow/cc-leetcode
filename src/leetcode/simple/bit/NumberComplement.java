package leetcode.simple.bit;

/**
 * @description: 476. 数字的补数
 * @see: <a>https://leetcode-cn.com/problems/number-complement/</a>
 * @author: guoping wang
 * @date: 2018/10/19 8:28
 * @project: cc-leetcode
 */
public class NumberComplement {

    /**
     * 个人常规解法：操作String
     * 11ms 66.97
     * @param num
     * @return
     */
    public int findComplementString(int num) {
        String binaryString = Integer.toBinaryString(num);
        binaryString = binaryString.replace('0', '2');
        binaryString = binaryString.replace('1', '0');
        binaryString = binaryString.replace('2', '1');
        int res = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            int bit = binaryString.charAt(i) - '0';
            res = (res << 1) | bit;
        }
        return res;
    }

    /**
     * 个人常规解法：直接进行位运算操作
     * 11ms 66.97
     * @param num
     * @return
     */
    public int findComplementBit(int num) {
        int res = 0;
        boolean hasNotZeroNum = false;

        for (int i = 0; i < 32; i++) {
            int bit = (num << i & 0x80000000) >>> 31;
            if (bit == 0) {
                if (hasNotZeroNum) {
                    res = (res << 1) | (1 - bit);
                }
            } else {
                hasNotZeroNum = true;
                res = (res << 1) | (1 - bit);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberComplement().findComplementBit(5));
    }
}
