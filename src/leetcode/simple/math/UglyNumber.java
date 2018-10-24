package leetcode.simple.math;

/**
 * @description: 263. 丑数
 * @see: <a>https://leetcode-cn.com/problems/ugly-number/</a>
 * @author: guoping wang
 * @date: 2018/10/24 17:14
 * @project: cc-leetcode
 */
public class UglyNumber {

    /**
     * 个人解法：进行质因数分解，一直除下去
     * 1ms 100%
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num != 1) {
            if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
                num = num % 2 == 0 ? num / 2 : num % 3 == 0 ? num / 3 : num / 5;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(6));
    }
}
