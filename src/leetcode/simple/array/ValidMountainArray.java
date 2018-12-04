package leetcode.simple.array;

/**
 * @description: 941. 有效的山脉数组
 * @see: <a>https://leetcode-cn.com/problems/valid-mountain-array/</a>
 * @author: guoping wang
 * @date: 2018/12/4 13:44
 * @project: cc-leetcode
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3 || A[0] >= A[1] || A[A.length - 1] >= A[A.length - 2]) return false;
        // 标记是否到达山峰
        boolean hasTop = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (!hasTop) {
                if (A[i] >= A[i + 1]) {
                    hasTop = true;
                }
            } else {
                if (A[i] <= A[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 1};
        System.out.println(new ValidMountainArray().validMountainArray(nums));
    }
}
