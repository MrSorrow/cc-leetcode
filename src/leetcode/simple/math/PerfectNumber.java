package leetcode.simple.math;

/**
 * @description: 507.完美数
 * @see: <a>https://leetcode-cn.com/problems/perfect-number/</a>
 * @author: guoping wang
 * @date: 2018/10/27 21:33
 * @project: cc-leetcode
 */
public class PerfectNumber {

    /**
     * 个人常规解法：求出所有的其他因数相加
     * 14ms 66.10%
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                sum = sum + i;
                if (num % i != i) {
                    sum = sum + num / i;
                }
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectNumber().checkPerfectNumber(28));
    }
}
