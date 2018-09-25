package leetcode.simple.string;

/**
 * @description: 28. 实现strStr()
 * @link: <a>https://leetcode-cn.com/problems/implement-strstr/</a>
 * @author: guoping wang
 * @date: 2018/9/25 9:40
 * @project: cc-leetcode
 */
public class ImplementStrstr {

    /**
     * 个人常规解法：直接API啊
     * 6ms 83.30%
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {

    }
}
