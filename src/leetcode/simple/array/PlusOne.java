package leetcode.simple.array;

import java.math.BigInteger;

/**
 * <a>https://leetcode-cn.com/problems/plus-one/description/</a>
 *
 * @author Kingdompin@163.com
 * @date 2018/8/2 下午5:42
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {8, 9, 9};
        System.out.println(new PlusOne().plusOneSimple(digits, digits.length - 1));
    }

    /**
     * 个人常规解法
     * 0ms 100% :)
     */
    public int[] plusOneSimple(int[] digits, int end) {
        if (digits[end] == 9) {
            digits[end] = 0;
            if (end > 0)
                plusOneSimple(digits, end - 1);
            else
                digits[end] = 10;
        } else {
            digits[end] = digits[end] + 1;
        }
        if (digits[0] == 10) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            result[1] = 0;
            for (int i = 2; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        } else {
            return digits;
        }
    }

}
