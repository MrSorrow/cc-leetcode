package leetcode.simple.binarysearch;

/**
 * @description: 367. 有效的完全平方数
 * @link: <a>https://leetcode-cn.com/problems/valid-perfect-square/</a>
 * @author: guoping wang
 * @date: 2018/9/22 21:30
 * @project: cc-leetcode
 */
public class ValidPerfectSquare {

    /**
     * 开方后平方
     * 0ms 100%
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        return (int) Math.sqrt(num) * (int) Math.sqrt(num) == num;
    }

    /**
     * 个人常规解法：二分查找
     * 0ms 100%
     * @param num
     * @return
     */
    public boolean isPerfectSquareBS(int num) {
        if (num == 0) {
            return true;
        }
        int start = 1;
        int end = num;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (num / mid == mid && num % mid == 0) {
                return true;
            } else if (num / mid > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquareBS(2147483647));
    }
}
