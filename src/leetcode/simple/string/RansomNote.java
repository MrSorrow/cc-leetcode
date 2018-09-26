package leetcode.simple.string;

import java.util.HashMap;

/**
 * @description: 383. 赎金信
 * @link: <a>https://leetcode-cn.com/problems/ransom-note/</a>
 * @author: guoping wang
 * @date: 2018/9/26 9:13
 * @project: cc-leetcode
 */
public class RansomNote {

    /**
     * 个人常规解法：HashMap存储杂志，然后去取
     * 78ms 14.73%
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstructHashMap(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>(magazine.length());
        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i))) {
                return false;
            }
            if (map.get(ransomNote.charAt(i)) == 1) {
                map.remove(ransomNote.charAt(i));
            } else {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            }
        }
        return true;
    }

    /**
     * 个人常规解法：HashMap慢那么自然用数组计数 (最快算法)
     * 25ms 64.73%
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstructCounter(String ransomNote, String magazine) {
        // ascii码有0-127个
        int[] counter = new int[128];

        for (int i = 0; i < magazine.length(); i++) {
            int c = magazine.charAt(i);
            counter[c]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int c = ransomNote.charAt(i);
            if (counter[c] <= 0) {
                return false;
            } else {
                counter[c]--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstructHashMap("bcjefgecda", "hfebdiicigfjahdddiahdajhaidbdgjihdbhgfbbccfdfggdcacccaebh"));
        System.out.println(new RansomNote().canConstructCounter("bcjefgecda", "hfebdiicigfjahdddiahdajhaidbdgjihdbhgfbbccfdfggdcacccaebh"));
    }
}
