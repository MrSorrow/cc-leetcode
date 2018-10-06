package leetcode.simple.hash;

import java.util.Arrays;

/**
 * @description: 389. 找不同
 * @see: <a>https://leetcode-cn.com/problems/find-the-difference/</a>
 * @author: guoping wang
 * @date: 2018/10/6 15:59
 * @project: cc-leetcode
 */
public class FindTheDifference {

    /**
     * 个人常规解法：对两个字符串进行重新排序，找出第一个不同
     * 12ms 41.32%
     * @param s
     * @param t
     * @return
     */
    public char findTheDifferenceSort(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        Arrays.sort(charS);
        Arrays.sort(charT);

        for (int i = 0; i < charS.length; i++) {
            if (charS[i] != charT[i]) {
                return charT[i];
            }
        }
        return charT[charT.length - 1];
    }

    /**
     * 个人常规解法：只有小写字母，可以用数组统计个数
     * 3ms 100%
     * @param s
     * @param t
     * @return
     */
    public char findTheDifferenceCount(String s, String t) {
        int[] countT = new int[26];

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        for (int i = 0; i < charT.length; i++) {
            countT[charT[i] - 'a']++;
        }

        for (int i = 0; i < charS.length; i++) {
            countT[charS[i] - 'a']--;
        }

        for (int i = 0; i < countT.length; i++) {
            if (countT[i] != 0) {
                return (char) ('a' + i);
            }
        }

        throw new IllegalArgumentException("no exist char");
    }

    /**
     * 找不同就应该想到位运算啊！！
     * 4ms 99.75%
     * @param s
     * @param t
     * @return
     */
    public char findTheDifferenceBit(String s, String t) {
        char diff = 0;
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        for (int i = 0; i < charT.length; i++) {
            diff^=charT[i];
        }

        for (int i = 0; i < charS.length; i++) {
            diff^=charS[i];
        }

        return diff;
    }
}
