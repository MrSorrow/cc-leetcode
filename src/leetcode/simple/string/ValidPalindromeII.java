package leetcode.simple.string;

/**
 * @description: 680. 验证回文字符串 Ⅱ
 * @link: https://leetcode-cn.com/problems/valid-palindrome-ii/
 * @author: guoping wang
 * @date: 2018/9/29 11:05
 * @project: cc-leetcode
 */
public class ValidPalindromeII {

    /**
     * 个人常规解法：寻找第一个对称位置不相等的字符，删除二者之一
     * 64ms 17.25%
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int index = -1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                index = i;
                break;
            }
        }

        // 本身就是回文串
        if (index == -1) {
            return true;
        }

        StringBuilder r1 = new StringBuilder(s).replace(index, index + 1, "");
        if (r1.reverse().toString().equals(r1.reverse().toString())) {
            return true;
        }
        StringBuilder r2 = new StringBuilder(s).replace(s.length() - index - 1, s.length() - index, "");
        if (r2.reverse().toString().equals(r2.reverse().toString())) {
            return true;
        }
        return false;
    }

    /**
     * 个人常规解法：寻找第一个对称位置不相等的字符，删除二者之一
     * 50ms 34.75%
     * @param s
     * @return
     */
    public boolean validPalindromeBetter(String s) {
        int start = -1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                start = i;
                break;
            }
        }

        // 本身就是回文串
        if (start == -1) {
            return true;
        }

        int end = s.length() - start - 1;

        if (isReverse(s.substring(start, end)) || isReverse(s.substring(start + 1, end + 1))) {
            return true;
        }

        return false;
    }

    /**
     * 是否是回文
     * @param substring
     * @return
     */
    private boolean isReverse(String substring) {
        for (int i = 0; i < substring.length() / 2; i++) {
            if (substring.charAt(i) != substring.charAt(substring.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII().validPalindrome("eddze"));
        System.out.println(new ValidPalindromeII().validPalindromeBetter("eddze"));
    }
}
