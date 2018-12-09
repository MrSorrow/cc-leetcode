package leetcode.simple.math;

/**
 * @description: 868. 二进制间距
 * @see: <a>https://leetcode-cn.com/problems/binary-gap/</a>
 * @author: guoping wang
 * @date: 2018/12/9 20:56
 * @project: cc-leetcode
 */
public class BinaryGap {

    /**
     * 个人常规解法：计数
     * 11ms 95.51%
     * @param N
     * @return
     */
    public int binaryGap(int N) {
        int max = 0, count = 0;
        boolean countFlag = false;
        for (int i = 0; i < 32; i++) {
            int bit = (N >>> i) & 1;
            if (bit == 1) {
                max = Math.max(max, count);
                countFlag = true;
                count = 0;
            }
            if (countFlag)
                count++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryGap().binaryGap(5));
    }
}
