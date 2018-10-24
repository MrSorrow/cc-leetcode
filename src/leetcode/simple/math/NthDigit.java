package leetcode.simple.math;

/**
 * @description: 400. 第N个数字
 * @see: <a>https://leetcode-cn.com/problems/nth-digit/</a>
 * @author: guoping wang
 * @date: 2018/10/24 18:57
 * @project: cc-leetcode
 */
public class NthDigit {

    /**
     * 个人常规解法：先寻找在几位数区间，再计算第几个数，再定位第几个数字
     * 5ms 72.36%
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int stage = 1;

        // 定位几位数的区间
        while (n >= 0) {
            long nums = 9 * Math.round(Math.pow(10, stage - 1)) * stage;
            if (n > nums) {
                n -= nums;
                stage++;
            } else {
                break;
            }
        }

        // 计算在第几个数里面
        int mod = n % stage == 0 ? stage : n % stage;
        int div = n % stage == 0 ? n / stage - 1 : n /stage;

        // 计算出该数字
        int res = (int) (div + Math.round(Math.pow(10, stage - 1)));

        // 计算数的哪一位
        mod = stage - mod;

        for (int i = 0; i < mod; i++) {
            res /= 10;
        }

        return res % 10;
    }

    public static void main(String[] args) {
        System.out.println(new NthDigit().findNthDigit(3));
    }
}
