package leetcode.simple.hash;

import leetcode.utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 438. 找到字符串中所有字母异位词
 * @see: <a>https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/</a>
 * @author: guoping wang
 * @date: 2018/10/7 12:19
 * @project: cc-leetcode
 */
public class FindAllAnagramsInAString {

    /**
     * 个人常规解法：不断截取和p长度一致的子串判断是否是异位的，是否异位用排序判断
     * 超时 35/36
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        p = String.valueOf(pChars);

        // 不断截取和p长度一致的子串判断是否是异位的
        for (int i = 0; i <= s.length() - p.length(); i++) {
            char[] chars = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(chars);
            if (p.equals(String.valueOf(chars))) {
                res.add(i);
            }
        }

        return res;
    }

    /**
     * 个人常规解法：不断截取和p长度一致的子串判断是否是异位的，是否异位用计数判断
     * 518ms 17.46%
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagramsBetter(String s, String p) {

        List<Integer> res = new ArrayList<>();

        char[] pChars = p.toCharArray();
        int[] pCounter = new int[26];
        for (int i = 0; i < pChars.length; i++) {
            pCounter[pChars[i] - 'a']++;
        }

        // 不断截取和p长度一致的子串判断是否是异位的
        for (int i = 0; i <= s.length() - p.length(); i++) {
            // 拷贝pCounter
            int[] pCounterCopy = new int[26];
            System.arraycopy(pCounter, 0, pCounterCopy, 0, 26);

            for (int j = i; j < i + p.length(); j++) {
                pCounterCopy[s.charAt(j) - 'a']--;
                if (pCounterCopy[s.charAt(j) - 'a'] < 0) {
                    break;
                }
                if (j == i + p.length() - 1) {
                    res.add(i);
                }
            }
        }

        return res;
    }

    /**
     * 个人常规解法：不断截取和p长度一致的子串判断是否是异位的，是否异位用计数判断，想着截取可以优化
     * 486ms 17.91%
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagramsBetterAndBetter(String s, String p) {

        List<Integer> res = new ArrayList<>();

        char[] pChars = p.toCharArray();
        int[] pCounter = new int[26];
        for (int i = 0; i < pChars.length; i++) {
            pCounter[pChars[i] - 'a']++;
        }

        // 不断截取和p长度一致的子串判断是否是异位的
        for (int i = 0; i <= s.length() - p.length(); i++) {
            // 拷贝pCounter
            int[] pCounterCopy = new int[26];
            System.arraycopy(pCounter, 0, pCounterCopy, 0, 26);

            for (int j = i; j < i + p.length(); j++) {
                pCounterCopy[s.charAt(j) - 'a']--;
                if (pCounterCopy[s.charAt(j) - 'a'] < 0) {
                    if (pCounter[s.charAt(j) - 'a'] <= 0) {
                        i = j;
                    }
                    break;
                }
                if (j == i + p.length() - 1) {
                    res.add(i);
                }
            }
        }

        return res;
    }

    /**
     * 个人常规解法：不断截取和p长度一致的子串判断是否是异位的，是否异位用计数判断，不用每次拷贝pCounter
     * 13ms 96.15%
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagramsBest(String s, String p) {

        List<Integer> res = new ArrayList<>();

        char[] pChars = p.toCharArray();
        int[] pCounter = new int[26];
        for (int i = 0; i < pChars.length; i++) {
            pCounter[pChars[i] - 'a']++;
        }

        // 不断截取和p长度一致的子串判断是否是异位的
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {

            // 先处理右侧
            char rightChar = s.charAt(right);
            if (pCounter[rightChar - 'a'] >= 1) {
                count--;
            }
            pCounter[rightChar - 'a']--; // 无论有没有，都减去1，没有的就会变成负数，有的就会>=0
            right++;

            if (count == 0) {
                res.add(left);
            }

            // 再处理左侧
            if (right - left >= p.length()) { // 等于的时候已经超了
                char leftChar = s.charAt(left);
                if (pCounter[leftChar - 'a'] >= 0) { // 减的没加回来之前大于等于0，意思就是该元素减过了不为负的肯定就是p中的，p中的元素那就得加回来
                    count++;
                }
                pCounter[leftChar - 'a']++; // 减的数字加回来
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ListUtils.printLists(new FindAllAnagramsInAString().findAnagrams("abab", "ab"));
        ListUtils.printLists(new FindAllAnagramsInAString().findAnagramsBetter("cbaebabacd", "abc"));
        ListUtils.printLists(new FindAllAnagramsInAString().findAnagramsBetterAndBetter("cbaebabacd", "abc"));
        ListUtils.printLists(new FindAllAnagramsInAString().findAnagramsBest("cbaebabacd", "abc"));
    }
}
