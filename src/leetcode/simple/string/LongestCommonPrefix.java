package leetcode.simple.string;

/**
 * @description: 14. 最长公共前缀
 * @link: <a>https://leetcode-cn.com/problems/longest-common-prefix/</a>
 * @author: guoping wang
 * @date: 2018/9/24 22:58
 * @project: cc-leetcode
 */
public class LongestCommonPrefix {

    /**
     * 个人常规解法：内外循环循环，对比所有单词的第一个字母，第二个，第三个...
     * 8ms 95.01%
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        int index = 0;
        while (true) {
            if (index >= strs[0].length()) {
                break;
            }
            char c = strs[0].charAt(index);
            boolean stop = false;
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    stop = true;
                    break;
                }
                char f = strs[i].charAt(index);
                if (f != c) {
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            }
            index++;
        }
        return strs[0].substring(0, index);
    }

    /**
     * 简洁的写法:以第一个字符作为前缀
     * 11ms 64.65%
     * @param strs
     * @return
     */
    public String longestCommonPrefixSimple(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                i = -1;
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (i == strs.length - 1) {
                return prefix;
            }
        }
        return "";
    }


    public static void main(String[] args) {
        String[] strs = {"a"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefixSimple(strs));
    }
}
