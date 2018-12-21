package leetcode.mid;

/**
 * @description: 3. 无重复字符的最长子串
 * @see: <a>https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/12/21 上午11:42
 * @project: cc-leetcode
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 个人常规解法：利用数组来记录是否有重复，一次遍历应该解决问题
     * 24ms 98.95%
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0, start = 0;
        int[] letters = new int[256]; // ASCII码
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
            if (letters[s.charAt(i)] >= 2) {
                // 重复，则寻找新的start
                for (; start < i;) {
                    letters[s.charAt(start)]--;
                    if (s.charAt(start++) == s.charAt(i))
                        break;
                }
            }
            if (i - start + 1 > max) {
                max = i - start + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    }
}
