package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 413. 等差数列划分
 * @see: <a>https://leetcode-cn.com/problems/arithmetic-slices/</a>
 * @author: guoping wang
 * @date: 2019/4/27 8:59
 * @project: cc-leetcode
 */
public class ArithmeticSlices {

    /**
     * 个人常规解法：遍历一遍即可，统计所有的等差数列长度，然后再统计所有个数
     * 1ms 96.71%
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;

        // A的长度大于3
        List<Integer> counter = new ArrayList<>();

        int lastGap = A[1] - A[0], start = 0, end = 1;
        for (int i = 2; i < A.length; i++) {
            int gap = A[i] - A[i - 1];

            if (gap == lastGap) {
                end = i;
            } else {
                // 每次遇到不一样的差，需判断是否要记录
                if (end - start >= 2) {
                    counter.add(end - start + 1);
                }
                lastGap = gap;
                start = i - 1;
            }
        }
        // 最后一个连续的等差数列可能没统计 需要进行统计
        if (end - start >= 2) {
            counter.add(end - start + 1);
        }

        int res = 0;
        for (Integer i : counter) {
            res += ((i - 2) * (i - 1)) / 2;
        }
        return res;
    }

    /**
     * 参考解法：动态规划
     * 如果i位置的元素的是等差数列，则以i结尾的等差数列个数=以i-1结尾的等差数列个数+1
     * 即dp[i] = dp[i - 1] + 1
     * 1ms 96.71%
     * @param A
     * @return
     */
    public int numberOfArithmeticSlicesDp(int[] A) {
        int[] dp = new int[A.length];

        for (int i = 2; i < A.length; i++) {
            // 如果i是等差数列
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i -  1] + 1;
            }
        }

        int res = 0;
        for (int i : dp) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3, 4};
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(A));
    }
}
