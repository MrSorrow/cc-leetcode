package leetcode.mid;

/**
 * @description: 29. 两数相除
 * @see: <a>https://leetcode-cn.com/problems/divide-two-integers/</a>
 * @author: guoping wang
 * @date: 2019/1/1 16:12
 * @project: cc-leetcode
 */
public class DivideTwoIntegers {

    /**
     * 个人常规解法：除数不断累加，直到超过被除数，需要注意累加速度，以1为步进速度太慢
     * 23ms 92.87%
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        long count = 0; long sum = 0; boolean tried = false;
        while (Math.abs(sum) <= Math.abs((long) dividend)) {
            if (sum != 0 && Math.abs(sum + sum) <= Math.abs((long) dividend)) {
                sum += sum;
                count += count;
            } else {
                if (tried) {
                    count += divide(dividend - (int) (divisor * count), divisor);
                    return count > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) count;
                } else {
                    tried = true;
                    sum += divisor;
                    if (Math.abs(sum) <= Math.abs((long) dividend))
                        count = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) ? count - 1 : count + 1;
                }

            }
        }
        return count > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) count;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(7, -3));
    }
}
