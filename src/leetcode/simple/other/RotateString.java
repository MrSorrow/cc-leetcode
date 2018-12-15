package leetcode.simple.other;

/**
 * @description: 796. 旋转字符串
 * @see: <a>https://leetcode-cn.com/problems/rotate-string/</a>
 * @author: guoping wang
 * @date: 2018/12/15 14:36
 * @project: cc-leetcode
 */
public class RotateString {

    /**
     * 个人常规解法：挨个进行旋转操作
     * 3ms 90.27%
     * @param A
     * @param B
     * @return
     */
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) return true;
        for (int i = 0; i < A.length(); i++) {
            A = A.substring(1) + A.substring(0, 1);
            if (B.equals(A)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 更好的解法，将两个A拼接
     * @param A
     * @param B
     * @return
     */
    public boolean rotateStringBetter(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) return true;
        A = A + A;
        return A.contains(B);
    }
}
