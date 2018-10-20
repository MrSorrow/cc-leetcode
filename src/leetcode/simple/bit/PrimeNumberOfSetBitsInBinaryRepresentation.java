package leetcode.simple.bit;

/**
 * @description: 762. 二进制表示中质数个计算置位
 * @see: <a>https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/</a>
 * @author: guoping wang
 * @date: 2018/10/20 21:54
 * @project: cc-leetcode
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

    /**
     * 个人常规解法：利用API，由于上限有32位数，最快的还是直接构造数组
     * 18ms 97.69%
     * @param L
     * @param R
     * @return
     */
    public int countPrimeSetBits(int L, int R) {
        boolean[] primeFlags = {false, false, true, true, false, true, false, true, false, false,
                false, true, false, true, false, false, false, true, false, true, false, false,
                false, true, false, false, false, false, false, true, false, false, false};
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (primeFlags[Integer.bitCount(i)]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
