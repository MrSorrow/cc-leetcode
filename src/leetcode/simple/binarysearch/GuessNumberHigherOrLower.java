package leetcode.simple.binarysearch;

/**
 * @description: 374. 猜数字大小
 * @link: <a>https://leetcode-cn.com/problems/guess-number-higher-or-lower/</a>
 * @author: guoping wang
 * @date: 2018/9/22 21:55
 * @project: cc-leetcode
 */
public class GuessNumberHigherOrLower {

    /**
     * 个人常规解法：二分
     * 1ms 92.36%
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private int guess(int num) {
        return num - 1 > 0 ? 1 : num == 1 ? 0 : -1;
    }

    public static void main(String[] args) {
        System.out.println(new GuessNumberHigherOrLower().guessNumber(10));
    }
}
