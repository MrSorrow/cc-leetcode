package leetcode.simple.binarysearch;

/**
 * @description: 69. x 的平方根
 * @link: <a>https://leetcode-cn.com/problems/sqrtx/</a>
 * @author: guoping wang
 * @date: 2018/9/22 19:15
 * @project: cc-leetcode
 */
public class Sqrtx {

    /**
     * 个人常规解法：直接API
     * 29ms 91.94%
     * @param x
     * @return
     */
    public int mySqrtCommon(int x) {
        double sqrt = Math.sqrt(x);
        return (int) sqrt;
    }

    /**
     * 最快的二分查找：最好不要用 mid*mid < x 来判断，用 x/mid > mid 更快
     * @param x
     * @return
     */
    public int mySqrtFast(int x) {
        int start = 0;
        int end = x;
        while (start < end) {
            int mid = (start + end) / 2;
            if (x / mid > mid) {
                start = mid + 1;
            } else if (x / mid == mid) {
                return mid;
            } else {
                end = mid;
            }
        }
        return end - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrtx().mySqrtFast(2147395599));
    }
}
