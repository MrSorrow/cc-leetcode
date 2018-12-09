package leetcode.simple.math;

/**
 * @description: 942. 增减字符串匹配
 * @see: <a>https://leetcode-cn.com/problems/di-string-match/</a>
 * @author: guoping wang
 * @date: 2018/12/9 21:14
 * @project: cc-leetcode
 */
public class DiStringMatch {

    /**
     * 个人常规解法：理解题意，其实就是一个顺序一个倒序
     * 7ms 92.65%
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {
        int[] res = new int[S.length() + 1];
        int front = 0, tail = S.length();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                res[i] = front++;
            } else {
                res[i] = tail--;
            }
        }
        res[S.length()] = tail;
        return res;
    }
}
