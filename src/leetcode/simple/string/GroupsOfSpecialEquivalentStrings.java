package leetcode.simple.string;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @description: 893. 特殊等价字符串组
 * @see: <a>https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/</a>
 * @author: guoping wang
 * @date: 2018/12/6 15:50
 * @project: cc-leetcode
 */
public class GroupsOfSpecialEquivalentStrings {

    /**
     * 个人常规解法：最笨的方法就是一个个比较，其实就是将字符串数组进行分组
     * 99ms 23.26%
     * @param A
     * @return
     */
    public int numSpecialEquivGroups(String[] A) {
        int groups = 0;
        boolean[] flags = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            if (flags[i])
                continue;
            for (int j = i + 1; j < A.length; j++) {
                if (isEquivalentStrings(A[i], A[j])) {
                    flags[j] = true;
                }
            }
            groups++;
        }
        return groups;
    }

    public boolean isEquivalentStrings(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        int[] odd = new int[26];
        int[] even = new int[26];
        // 奇数
        for (int i = 0; i < s.length() / 2; i++) {
            odd[s.charAt(2 * i + 1) - 'a']++;
            odd[t.charAt(2 * i + 1) - 'a']--;
        }
        // 偶数
        for (int i = 0; i < s.length() - s.length() / 2; i++) {
            even[s.charAt(2 * i) - 'a']++;
            even[t.charAt(2 * i) - 'a']--;
        }

        for (int i : odd) {
            if (i != 0) return false;
        }

        for (int i : even) {
            if (i != 0) return false;
        }

        return true;
    }


    /**
     * 更好的表达写法：用HashSet去重，将每个字符串排序好生成新的字符串
     * 15ms 89.53%
     * @param A
     * @return
     */
    public int numSpecialEquivGroupsBetter(String[] A) {
        HashSet<String> res = new HashSet<>();
        for (String a : A) {
            res.add(getSortedEquivalentStrings(a));
        }
        return res.size();
    }

    public String getSortedEquivalentStrings(String s) {
        char[] odd = new char[s.length() / 2];
        char[] even = new char[s.length() - s.length() / 2];
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                even[i / 2] = s.charAt(i);
            } else {
                odd[i / 2] = s.charAt(i);
            }
        }
        Arrays.sort(odd);
        Arrays.sort(even);
        return new String(odd) + new String(even);
    }
}
