package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 139. 单词拆分
 * @see: <a>https://leetcode-cn.com/problems/word-break/</a>
 * @author: guoping wang
 * @date: 2019/2/23 9:08
 * @project: cc-leetcode
 */
public class WordBreak {

    /**
     * 个人常规解法：递归方法，会重复计算
     * 29/36
     * @param s
     * @param wordDict
     * @return
     */
    private boolean wordBreakRecursion(String s, List<String> wordDict) {
        if (s.equals("")) return true;
        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i))) {
                if (wordBreakRecursion(s.substring(i), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 动态规划，逐个字母进行叠加判断
     * 8ms 86.54%
     * @param s
     * @param wordDict
     * @return
     */
    private boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] flags = new boolean[s.length() + 1];
        flags[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // 对s.substring(0, i)进行判断
            for (int j = 0; j < i; j++) {
                if (flags[j] && wordDict.contains(s.substring(j, i))) {
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[s.length()];
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> dict = new ArrayList<String>(){{add("a"); add("aa"); add("aaa"); add("aaaa"); add("aaaaa"); add("aaaaaa"); add("aaaaaaa"); add("aaaaaaaa"); add("aaaaaaaaa"); add("aaaaaaaaaa");}};
        System.out.println(new WordBreak().wordBreakDP(s, dict));
    }
}
