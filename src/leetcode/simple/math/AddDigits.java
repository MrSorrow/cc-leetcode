package leetcode.simple.math;

/**
 * @description: 258. 各位相加
 * @see: <a>https://leetcode-cn.com/problems/add-digits/</a>
 * @author: guoping wang
 * @date: 2018/10/23 17:05
 * @project: cc-leetcode
 */
public class AddDigits {

    /**
     * 个人常规解法：递归实现结果
     * 6ms 17.28%
     * @param num
     * @return
     */
    public int addDigitsCir(int num) {
        if (num < 10) {
            return num;
        }
        int nextNum = 0;
        while (num != 0) {
            nextNum += (num % 10);
            num /= 10;
        }
        return addDigitsCir(nextNum);
    }

    /**
     * 个人常规解法：遍历相加每逢超时直接取个位
     * 6ms 17.28%
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            int i = sum % 10;
            sum = i + sum / 10;
            num /= 10;
        }
        return sum;
    }

    /**
     * 最好算法：算9的余数
     * 1ms 100%
     * @param num
     * @return
     */
    public int addDigitsBest(int num) {
        return num == 0 ? 0 : num % 9 == 0 ? 9 : num % 9;
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigitsBest(38));
    }
}
