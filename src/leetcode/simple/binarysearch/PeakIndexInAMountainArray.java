package leetcode.simple.binarysearch;

/**
 * @description: 852. 山脉数组的峰顶索引
 * @link: <a>https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/</a>
 * @author: guoping wang
 * @date: 2018/9/24 20:38
 * @project: cc-leetcode
 */
public class PeakIndexInAMountainArray {

    public static void main(String[] args) {

    }

    /**
     * 个人常规解法：O(N)
     * 3ms 93.76%
     * @param A
     * @return
     */
    public int peakIndexInMountainArrayOn(int[] A) {
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 个人常规解法：二分
     * 2ms 100%
     * @param A
     * @return
     */
    public int peakIndexInMountainArrayBs(int[] A) {
        int start = 1, end = A.length -  2;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] <= A[mid + 1]) {
                start = mid + 1;
            } else if (A[mid] <= A[mid - 1]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
