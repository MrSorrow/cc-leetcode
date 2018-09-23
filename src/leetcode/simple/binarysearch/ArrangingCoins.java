package leetcode.simple.binarysearch;

/**
 * @description: 441. 排列硬币
 * @link: <a>https://leetcode-cn.com/problems/arranging-coins/</a>
 * @author: guoping wang
 * @date: 2018/9/23 9:01
 * @project: cc-leetcode
 */
public class ArrangingCoins {

    /**
     * 个人常规解法：二分
     * 34ms 93.90%
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int start =  0;
        int end = n;
        while (start < end) {
            int k = (end - start) / 2 + start;
            if ((int) (n * 1.0 / k * 2) < k + 1) {
                end = k;
            } else if ((int) (n * 1.0 / k * 2) == k + 1) {
                return k;
            } else {
                start = k + 1;
            }
        }
        return end - 1;
    }

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(3));
    }
}
