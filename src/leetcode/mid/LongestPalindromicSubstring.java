package leetcode.mid;

/**
 * @description: 5. 最长回文子串
 * @see: <a>https://leetcode-cn.com/problems/longest-palindromic-substring/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/12/21 下午1:06
 * @project: cc-leetcode
 */
public class LongestPalindromicSubstring {

    /**
     * 个人常规解法：动态规划
     * 186ms 17.09%
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String[] res = new String[s.length() + 1];
        res[0] = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    String sub = i != s.length() - 1 ? s.substring(j, i + 1) : s.substring(j);
                    if (isPalindrome(sub)) {
                        res[i + 1] = sub.length() > res[i].length() ? sub : res[i];
                        break;
                    }
                }
            }
            if (res[i + 1] == null) {
                res[i + 1] = 1 > res[i].length() ? s.charAt(i)+"" : res[i];
            }
        }

        return res[s.length()];
    }

    private boolean isPalindrome(String sub) {
        for (int i = 0; i < sub.length() / 2; i++) {
            if (sub.charAt(i) != sub.charAt(sub.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaaa"));
    }
}
