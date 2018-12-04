package leetcode.simple.array;

/**
 * @description: 905. 按奇偶排序数组
 * @see: <a>https://leetcode-cn.com/problems/sort-array-by-parity/</a>
 * @author: guoping wang
 * @date: 2018/12/4 13:36
 * @project: cc-leetcode
 */
public class SortArrayByParity {

    /**
     * 个人常规解法：复制一个数组，首尾进行插入奇偶数
     * 14ms 89.54%
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int front = 0, tail = A.length - 1;
        for (int num : A) {
            if (num % 2 == 0) {
                res[front++] = num;
            } else {
                res[tail--] = num;
            }
        }
        return res;
    }
}
