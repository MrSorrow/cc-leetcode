package leetcode.simple.array;

import leetcode.utils.ArrayUtils;

import java.util.HashSet;

/**
 * @description: 888. 公平的糖果交换
 * @link: <a>https://leetcode-cn.com/problems/fair-candy-swap/description/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 上午11:06
 * @project: cc-leetcode
 */
public class FairCandySwap {

    public static void main(String[] args) {
        int[] A = {1, 1};
        int[] B = {2, 2};
        ArrayUtils.printArray(new FairCandySwap().fairCandySwap(A, B));
    }

    /**
     * 个人常规解法：转换为查找问题，寻找查找->B的总和减去A的总和差的一半加上A的数
     * 31ms
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        HashSet<Integer> hashSet = new HashSet<>(B.length);
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
            hashSet.add(B[i]);
        }
        int sub = (sumB - sumA) / 2;
        for (int i = 0; i < A.length; i++) {
            if (hashSet.contains(A[i] + sub)) {
                return new int[]{A[i], A[i] + sub};
            }
        }
        return null;
    }
}
