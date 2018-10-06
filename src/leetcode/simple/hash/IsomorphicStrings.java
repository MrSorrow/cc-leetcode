package leetcode.simple.hash;

import java.util.HashMap;

/**
 * @description: 205. 同构字符串
 * @see: <a>https://leetcode-cn.com/problems/isomorphic-strings/</a>
 * @author: guoping wang
 * @date: 2018/10/6 15:50
 * @project: cc-leetcode
 */
public class IsomorphicStrings {

    /**
     * 个人常规解法：hashMap存储映射规则，关键在于题意，要求不能单边的一对多
     * 24ms 40.96
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphicMap(String s, String t) {
        return isIsomorphicSub(s, t) && isIsomorphicSub(t, s);
    }

    public boolean isIsomorphicSub(String s, String t) {
        HashMap<Character, Character> mapperS = new HashMap<>();

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        if (charS.length != charT.length) {
            return false;
        }

        // 每一个字符进行对比，如果相同直接过，如果不同则进行替换
        for (int i = 0; i < charS.length; i++) {
            if (mapperS.containsKey(charS[i])) {
                if (!mapperS.get(charS[i]).equals(charT[i])) {
                    return false;
                }
            } else {
                mapperS.put(charS[i], charT[i]);
            }
        }
        return true;
    }

    /**
     * 个人常规解法：当然映射关系的存储hashMap存一定是慢的，所以用数组
     * 3ms 99.71%
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphicArray(String s, String t) {
        return isIsomorphicSub2(s, t) && isIsomorphicSub2(t, s);
    }

    public boolean isIsomorphicSub2(String s, String t) {
        int[] mapper = new int[128];
        for (int i = 0; i < mapper.length; i++) {
            mapper[i] = -1;
        }

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        if (charS.length != charT.length) {
            return false;
        }

        // 每一个字符进行对比，如果相同直接过，如果不同则进行替换
        for (int i = 0; i < charS.length; i++) {
            if (mapper[charS[i]] > -1) {
                if (mapper[charS[i]] != charT[i]) {
                    return false;
                }
            } else {
                mapper[charS[i]] = charT[i];
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphicMap("ab", "aa"));
        System.out.println(new IsomorphicStrings().isIsomorphicArray("ab", "aa"));
    }
}
