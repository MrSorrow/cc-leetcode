package leetcode.simple.math;

import java.util.Arrays;

/**
 * @description: 949. 给定数字能组成的最大时间
 * @see: <a>https://leetcode-cn.com/problems/largest-time-for-given-digits/</a>
 * @author: guoping wang
 * @date: 2018/12/9 21:23
 * @project: cc-leetcode
 */
public class LargestTimeForGivenDigits {

    /**
     * 个人常规解法：将24种情况表示出来进行排序
     * 10ms 82.26%
     * @param A
     * @return
     */
    public String largestTimeFromDigits(int[] A) {
        String[] res = new String[24];
        Arrays.sort(A);
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j == i) continue;
                for (int k = 0; k < A.length; k++) {
                    if (k == j || k == i) continue;
                    for (int l = 0; l < A.length; l++) {
                        if (l == k || l == j || l == i) continue;
                        res[index++] = "" + A[i] + A[j] + ":" + A[k] + A[l];
                    }
                }
            }
        }
        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i].compareTo("23:59") <= 0 && res[i].compareTo("00:00") >= 0 && res[i].substring(3).compareTo("59") <= 0)
                return res[i];
        }
        return "";
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println(new LargestTimeForGivenDigits().largestTimeFromDigits(A));
    }
}
