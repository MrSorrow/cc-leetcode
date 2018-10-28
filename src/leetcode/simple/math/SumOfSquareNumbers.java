package leetcode.simple.math;

/**
 * @description: 633.平方数之和
 * @see: <a>https://leetcode-cn.com/problems/sum-of-square-numbers/</a>
 * @author: guoping wang
 * @date: 2018/10/28 15:27
 * @project: cc-leetcode
 */
public class SumOfSquareNumbers {

    /**
     * 个人常规解法：正常判断是否是开方数
     * 35ms 11.44%
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        if (c==0) return true;
        for (int i = 1; i <= c / i; i++) {
            int num = c - i * i;
            if (num == 0 || (num / Math.round(Math.sqrt(num)) == Math.round(Math.sqrt(num)) && num % Math.round(Math.sqrt(num)) == 0 )) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(0));
    }
}
