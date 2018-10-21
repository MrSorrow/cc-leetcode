package leetcode.simple.math;

/**
 * @description: 7. 反转整数
 * @see: <a>https://leetcode-cn.com/problems/reverse-integer/</a>
 * @author: guoping wang
 * @date: 2018/10/21 20:34
 * @project: cc-leetcode
 */
public class ReverseInteger {

    /**
     * 个人常规解法：直接转成字符串反序，进行try-catch
     * 33ms 82.21%
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean flag = x >= 0;
        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
        try {
            int value = Integer.valueOf(sb.reverse().toString());
            return flag ? value : -value;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 个人常规解法：直接转换，出界时判断
     * 44ms 50.37%
     * @param x
     * @return
     */
    public int reverseDirect(int x) {
        boolean flag = x >= 0;
        int res = 0;
        x = Math.abs(x);

        while (x != 0) {
            if (res <= (Integer.MAX_VALUE - x % 10) / 10.0) {
                res = res * 10 + x % 10;
            } else {
                return 0;
            }
            x /= 10;
        }
        return flag ? res : -res;
    }


    /**
     * 直接法的更优写法：不需要判断正负，溢出也可以用long来判断
     * @param x
     * @return
     */
    public int reverseDirectBetter(int x) {
        int res = 0;
        while (x != 0) {
            long temp = res * 10L + x % 10;
            if (temp < Integer.MIN_VALUE || temp > Integer.MAX_VALUE) {
                return 0;
            } else {
                res = (int) temp;
            }
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1534213649));
        System.out.println(new ReverseInteger().reverseDirect(1534213649));
        System.out.println(new ReverseInteger().reverseDirectBetter(1534236469));
    }
}
