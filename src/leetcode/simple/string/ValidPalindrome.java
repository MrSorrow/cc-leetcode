package leetcode.simple.string;

/**
 * @description: 125. 验证回文串
 * @link: <a>https://leetcode-cn.com/problems/valid-palindrome/</a>
 * @author: guoping wang
 * @date: 2018/9/25 21:18
 * @project: cc-leetcode
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindromeOn("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindromeRegular("0P"));
    }

    /**
     * 个人常规解法：首位指针一齐遍历判断是否相等
     * 8ms 73.87%
     * @param s
     * @return
     */
    public boolean isPalindromeOn(String s) {
        s= s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {

            // 寻找两边的第一个字母数字
            while (start <= end) {
                if (isNumOrLetter(s.charAt(start)) && isNumOrLetter(s.charAt(end))) {
                    break;
                }
                if (!isNumOrLetter(s.charAt(start))) {
                    start++;
                }
                if (!isNumOrLetter(s.charAt(end))) {
                    end--;
                }
            }

            // 对比是否相等
            if (start <= end && s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    private boolean isNumOrLetter(char c) {
        if ((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0')){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 正则表达式替换
     * 41ms 13.21%
     * @param s
     * @return
     */
    public boolean isPalindromeRegular(String s) {
        s = s.replaceAll("[^a-z^A-Z^0-9]", "");
        s = s.toLowerCase();
        StringBuilder reverse = new StringBuilder(s);
        reverse = reverse.reverse();
        if (s.equals(reverse.toString())) {
            return true;
        } else {
            return false;
        }
    }
}
