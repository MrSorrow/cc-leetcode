package leetcode.simple.bit;

/**
 * @description: 190. 颠倒二进制位
 * @see: <a>https://leetcode-cn.com/problems/reverse-bits/</a>
 * @author: guoping wang
 * @date: 2018/10/16 10:59
 * @project: cc-leetcode
 */
public class ReverseBits {

    /**
     * 个人常规解法：用移位、异或进行操作
     * 1ms 100%
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int lowBit = 1;
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n >> i & lowBit;  // 获取末尾数字
            res = res | bit << (31 - i);  // 添加数字，二的次方用移位运算
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(1));
    }
}
