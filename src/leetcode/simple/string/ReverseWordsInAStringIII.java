package leetcode.simple.string;

/**
 * @description: 557. 反转字符串中的单词 III
 * @link: <a>https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/</a>
 * @author: guoping wang
 * @date: 2018/9/29 10:37
 * @project: cc-leetcode
 */
public class ReverseWordsInAStringIII {

    public static void main(String[] args) {

    }

    /**
     * 个人常规解法：利用API
     * 10ms 93.74%
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            StringBuilder sb1 = new StringBuilder(str);
            sb.append(sb1.reverse()).append(" ");
        }
        return sb.toString().trim();
    }
}
