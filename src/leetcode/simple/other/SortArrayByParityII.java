package leetcode.simple.other;

import leetcode.utils.ArrayUtils;

/**
 * @description: 922. 按奇偶排序数组 II
 * @see: <a>https://leetcode-cn.com/problems/sort-array-by-parity-ii/</a>
 * @author: guoping wang
 * @date: 2018/12/16 22:51
 * @project: cc-leetcode
 */
public class SortArrayByParityII {

    /**
     * 个人常规解法：直接数值的奇偶赋值即可，维护两个指针
     * 6ms 99.65%
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        for (int i = 0, odd = 1, even = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[even] = A[i];
                even += 2;
            } else {
                res[odd] = A[i];
                odd += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 7};
        ArrayUtils.printIntArray(new SortArrayByParityII().sortArrayByParityII(nums));
    }
}
