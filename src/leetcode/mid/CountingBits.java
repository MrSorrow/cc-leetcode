package leetcode.mid;

import utils.ArrayUtils;

/**
 * @description: 338. 比特位计数
 * @see: <a>https://leetcode-cn.com/problems/counting-bits/</a>
 * @author: guoping wang
 * @date: 2019/4/15 20:52
 * @project: cc-leetcode
 */
public class CountingBits {

    /**
     * 个人常规解法：动态规划，寻找状态转移方程
     * 3ms 53.58%
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int temp = 1;
        for (int i = 1; i <= num; i++) {
            while ((temp = temp << 1) < i) {
                // loop
            }
            if (temp > i) temp = temp >> 1;
            res[i] = res[i - temp] + 1;  // 状态方程
        }
        return res;
    }

    /**
     * 参考解法：2ms 94.03%
     * @param num
     * @return
     */
    public int[] countBitsBetter(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);  // 状态方程
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayUtils.printIntArray(new CountingBits().countBits(10));
    }
}
