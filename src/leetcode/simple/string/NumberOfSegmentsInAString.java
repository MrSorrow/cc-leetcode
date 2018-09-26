package leetcode.simple.string;

/**
 * @description: 434. 字符串中的单词数
 * @link: <a>https://leetcode-cn.com/problems/number-of-segments-in-a-string/</a>
 * @author: guoping wang
 * @date: 2018/9/26 16:00
 * @project: cc-leetcode
 */
public class NumberOfSegmentsInAString {

    /**
     * 个人常规解法：正则表达式
     * 5ms 7.33%
     * @param s
     * @return
     */
    public int countSegmentsRegular(String s) {
        s = s.replaceAll("\\s{1,}", " ").trim();
        return s.equals("") ? 0 : s.split(" ").length;
    }

    /**
     * 个人常规解法：连续字符是单词，根据空格来计数
     * 2ms 98.04%
     * @param s
     * @return
     */
    public int countSegments(String s) {
        int count = 0;
        boolean hasBlank = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (hasBlank) {
                    count++;
                }
                hasBlank = false;
            } else {
                hasBlank = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSegmentsInAString().countSegmentsRegular(""));
        System.out.println(new NumberOfSegmentsInAString().countSegments(" , pu-blic int cou "));
    }
}
