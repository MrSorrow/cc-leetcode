package leetcode.simple.array;

/**
 * <a>https://leetcode-cn.com/problems/plus-one/description/</a>
 * @author Kingdompin@163.com
 * @date 2018/8/2 下午5:42
 */
public class PlusOne {


    /**
     * 个人常规解法
     */
    public int[] plusOne(int[] digits) {
        int num = 0;
        for (int i = 0; i < digits.length; i++) {
            num = digits[i] + num * 10;
        }
        num++;
        return null;
    }

}
