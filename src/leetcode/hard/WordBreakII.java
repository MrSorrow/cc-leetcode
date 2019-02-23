package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 140. 单词拆分 II
 * @see: <a>https://leetcode-cn.com/problems/word-break-ii/</a>
 * @author: guoping wang
 * @date: 2019/2/23 15:39
 * @project: cc-leetcode
 */
public class WordBreakII {

    /**
     * 个人常规解法：动态规划，基于题139的基础上不要break，记录下所有的组合
     * 31/39 问题出在某些用例其实最终是不能重组的，所以先进行flags的计算
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List[] records = new List[s.length() + 1];
        records[0] = new ArrayList(1){{add("");}};
        boolean[] flags = new boolean[s.length() + 1];
        flags[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            // 对s.substring(0, i)进行判断与计算所有组合性
            List<String> list = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                if (flags[j] && wordDict.contains(s.substring(j, i))) {
                    if (!flags[i]) flags[i] = true;
                    // s.substring(j, i)可以，那么s.substring(0, i)该循环的组合是s.substring(0, j)的组合加上s.substring(j, i)
                    List record = records[j];
                    for (Object o : record) {
                        String string = o + s.substring(j, i);
                        if (i < s.length())
                            string += " ";
                        list.add(string);
                    }
                }
            }

            records[i] = list;
        }
        return records[s.length()];
    }

    /**
     * 个人常规解法：动态规划，先进行判断
     * 38ms 28%
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreakJudgeFist(String s, List<String> wordDict) {
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

        if (flags[s.length()]) {
            List[] records = new List[s.length() + 1];
            records[0] = new ArrayList(1){{add("");}};
            for (int i = 1; i <= s.length(); i++) {
                // 对s.substring(0, i)进行判断与计算所有组合性
                List<String> list = new ArrayList<>();

                for (int j = 0; j < i; j++) {
                    if (flags[j] && wordDict.contains(s.substring(j, i))) {
                        // s.substring(j, i)可以，那么s.substring(0, i)该循环的组合是s.substring(0, j)的组合加上s.substring(j, i)
                        List record = records[j];
                        for (Object o : record) {
                            String string = o + s.substring(j, i);
                            if (i < s.length())
                                string += " ";
                            list.add(string);
                        }
                    }
                }

                records[i] = list;
            }
            return records[s.length()];
        } else {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> dict = new ArrayList<String>(){{add("apple"); add("pen"); add("applepen"); add("pine"); add("pineapple"); add("aaaaaa"); add("aaaaaaa"); add("aaaaaaaa"); add("aaaaaaaaa"); add("aaaaaaaaaa");}};
        System.out.println(new WordBreakII().wordBreak(s, dict));
    }
}
