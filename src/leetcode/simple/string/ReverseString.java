package leetcode.simple.string;

/**
 * @description: 344. 反转字符串
 * @author: guoping wang
 * @date: 2018/9/26 8:37
 * @project: cc-leetcode
 */
public class ReverseString {

    /**
     * 个人常规解法：直接API
     * 4ms 48.44%
     * @param s
     * @return
     */
    public String reverseString(String s) {
        StringBuilder res = new StringBuilder(s);
        return res.reverse().toString();
    }
}
