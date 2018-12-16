package leetcode.simple.other;

/**
 * @description: 806. 写字符串需要的行数
 * @see: <a>https://leetcode-cn.com/problems/number-of-lines-to-write-string/</a>
 * @author: guoping wang
 * @date: 2018/12/16 20:12
 * @project: cc-leetcode
 */
public class NumberOfLinesToWriteString {

    /**
     * 个人常规解法：每个字符遍历即可
     * 2ms 100%
     * @param widths
     * @param S
     * @return
     */
    public int[] numberOfLines(int[] widths, String S) {
        int line = 1, count = 0;
        // 遍历S
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            count += widths[c - 'a'];
            if (count > 100) {
                line++;
                count = widths[c - 'a'];
            }
        }
        return new int[] {line, count};
    }

    public static void main(String[] args) {

    }
}
