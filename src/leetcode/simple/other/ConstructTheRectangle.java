package leetcode.simple.other;

import utils.ArrayUtils;

/**
 * @description: 492. 构造矩形
 * @see: <a>https://leetcode-cn.com/problems/construct-the-rectangle/</a>
 * @author: guoping wang
 * @date: 2018/12/15 14:01
 * @project: cc-leetcode
 */
public class ConstructTheRectangle {

    /**
     * 个人常规解法：area开始往下试探
     * 465ms 3.64%
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        if (area == 1) return new int[]{1, 1};
        int[] res = new int[2];
        int sub = area;

        for (int i = area; area / i <= i; i--) {
            if (area % i == 0 && (i - area / i) < sub) {
                res[0] = i;
                res[1] = area / i;
            }
        }
        return res;
    }

    /**
     * 个人常规解法：开方后进行试探
     * 3ms 100%
     * @param area
     * @return
     */
    public int[] constructRectangleSqrt(int area) {
        int[] res = new int[2];
        int sqrt = (int) Math.sqrt(area);
        for (int i = sqrt; i >= 1; i--) {
            if (area % i == 0) {
                res[1] = i;
                res[0] = area / i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayUtils.printIntArray(new ConstructTheRectangle().constructRectangleSqrt(4));
    }
}
