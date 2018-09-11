package leetcode.simple.sort;

import java.util.Arrays;

/**
 * @description: 242. 有效的字母异位词
 * @link: <a>https://leetcode-cn.com/problems/valid-anagram/description/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 下午1:30
 * @project: cc-leetcode
 */
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagramBest("anagram", "nagaram"));
    }

    /**
     * 个人常规解法：字符重排序
     * 264ms 3.85
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        String[] sArray = s.split("");
        String[] tArray = t.split("");
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for (int i = 0; i < sArray.length; i++) {
            if (!sArray[i].equals(tArray[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 个人常规排序：底层调用快排
     * 10ms 36.85%
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramFast(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != (tArray[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 统计字母出现次数
     * 4ms 90.84%
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramBest(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int[] sCount = new int[26];
        int[] tCount = new int[26];

        for (int i = 0; i < sArray.length; i++) {
            sCount[sArray[i] - 97]++;
            tCount[tArray[i] - 97]++;
        }

        for (int i = 0; i < sCount.length; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }
        return true;
    }
}
