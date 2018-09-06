package leetcode.simple.array;

/**
 * @description: 896. 单调数列
 * @link: <a>https://leetcode-cn.com/problems/monotonic-array/description/</a>
 * @author: guoping wang
 * @date: 2018/9/6 12:43
 * @project: cc-leetcode
 */
public class MonotonicArray {

    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 4};
        System.out.println(new MonotonicArray().isMonotonic(nums));
    }

    /**
     * 个人常规解法：遍历判断
     * 28ms
     * @param A
     * @return
     */
    public boolean isMonotonic(int[] A) {
        boolean up = true, down = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                up = false;
                break;
            }
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                down = false;
                break;
            }
        }
        return up || down;
    }
}
