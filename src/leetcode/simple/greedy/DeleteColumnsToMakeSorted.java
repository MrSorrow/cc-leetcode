package leetcode.simple.greedy;

/**
 * @description: 944. 删列造序
 * @see: <a>https://leetcode-cn.com/problems/delete-columns-to-make-sorted/</a>
 * @author: guoping wang
 * @date: 2018/12/11 20:45
 * @project: cc-leetcode
 */
public class DeleteColumnsToMakeSorted {

    /**
     * 个人常规解法：其实就是统计A的字符串对应位置有多少没有非降序排列的
     * 23ms 79.89%
     * @param A
     * @return
     */
    public int minDeletionSize(String[] A) {
        int count = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j+1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
