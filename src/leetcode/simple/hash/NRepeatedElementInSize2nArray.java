package leetcode.simple.hash;

import java.util.HashSet;

/**
 * @description: 961. 重复 N 次的元素
 * @see: <a>https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/</a>
 * @author: guoping wang
 * @date: 2019/3/17 21:36
 * @project: cc-leetcode
 */
public class NRepeatedElementInSize2nArray {

    /**
     * 个人常规解法：数组统计出现次数
     * 11ms 60.6%
     * @param A
     * @return
     */
    public int repeatedNTimesCounter(int[] A) {
        int[] counter = new int[10001];
        for (int i = 0; i < A.length; i++) {
            if (counter[A[i]] > 0) return A[i];
            counter[A[i]] ++;
        }
        return A[0];
    }

    /**
     * 个人常规解法：HashSet统计
     * @param A
     * @return
     */
    public int repeatedNTimes(int[] A) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : A) {
            if (hashSet.contains(i)) {
                return i;
            }
            hashSet.add(i);
        }
        return A[0];
    }
}
