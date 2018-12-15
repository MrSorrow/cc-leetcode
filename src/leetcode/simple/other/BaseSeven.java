package leetcode.simple.other;

/**
 * @description: 504. 七进制数
 * @see: <a>https://leetcode-cn.com/problems/base-7/</a>
 * @author: guoping wang
 * @date: 2018/12/15 11:11
 * @project: cc-leetcode
 */
public class BaseSeven {

    /**
     * 个人常规解法：除余法
     * 9ms 99.32%
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num == 0) return "0";

        StringBuilder res = new StringBuilder();
        boolean isNeg = false;

        if (num < 0) {
            num = Math.abs(num);
            isNeg = true;
        }

        while (num != 0) {
            res.insert(0, num % 7);
            num /= 7;
        }

        return isNeg ? "-" + res.toString() : res.toString();
    }
}
