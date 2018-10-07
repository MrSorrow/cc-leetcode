package leetcode.simple.hash;

import java.util.HashMap;

/**
 * @description: 290. 单词模式
 * @see: <a>https://leetcode-cn.com/problems/word-pattern/</a>
 * @author: guoping wang
 * @date: 2018/10/6 16:57
 * @project: cc-leetcode
 */
public class WordPattern {

    /**
     * 个人常规解法：HashMap存储映射规则,abba就应该dog cat cat dog
     * 2ms 61.69%
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> mapperC2S = new HashMap<>();
        HashMap<String, Character> mapperS2C = new HashMap<>();

        char[] patterns = pattern.toCharArray();
        String[] strs = str.split(" ");

        if (patterns.length != strs.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            // 如果包含映射规则，则判断是否一致
            if (mapperC2S.containsKey(patterns[i])) {
                if (!mapperC2S.get(patterns[i]).equals(strs[i])) {
                    return false;
                }
            } else {
                if (mapperS2C.containsKey(strs[i]) && !mapperS2C.get(strs[i]).equals(patterns[i])) {
                    return false;
                }
                mapperC2S.put(patterns[i], strs[i]);
                mapperS2C.put(strs[i], patterns[i]);
            }
        }

        return true;
    }

    /**
     * 个人常规解法：数组存储映射规则,abba就应该dog cat cat dog
     * 2ms 61.69%
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPatternArray(String pattern, String str) {
        String[] mapperC2S = new String[58];
        HashMap<String, Character> mapperS2C = new HashMap<>();

        char[] patterns = pattern.toCharArray();
        String[] strs = str.split(" ");

        if (patterns.length != strs.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            // 如果包含映射规则，则判断是否一致
            if (mapperC2S[patterns[i] - 'A'] != null) {
                if (!mapperC2S[patterns[i] - 'A'].equals(strs[i])) {
                    return false;
                }
            } else {
                if (mapperS2C.containsKey(strs[i]) && !mapperS2C.get(strs[i]).equals(patterns[i])) {
                    return false;
                }
                mapperC2S[patterns[i] - 'A'] = strs[i];
                mapperS2C.put(strs[i], patterns[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog dog dog dog"));
        System.out.println(new WordPattern().wordPatternArray("abba", "dog dog dog dog"));
    }
}
