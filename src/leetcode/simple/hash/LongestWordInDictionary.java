package leetcode.simple.hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @description: 720. 词典中最长的单词
 * @see: <a>https://leetcode-cn.com/problems/longest-word-in-dictionary/</a>
 * @author: guoping wang
 * @date: 2018/10/11 8:51
 * @project: cc-leetcode
 */
public class LongestWordInDictionary {

    /**
     * 个人常规解法：TreeSet实现长度及字典序排序
     * 25ms 81.22%
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        // 自定义key排序规则的TreeSet
        TreeSet<String> dataSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return 1;
                } else if (o1.length() > o2.length()) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        dataSet.addAll(Arrays.asList(words));

        // TreeSet的遍历
        for (String s : dataSet) {
            boolean isSatisfied = true;
            for (int i = 0; i < s.length(); i++) {
                if (!dataSet.contains(s.substring(0, i + 1))) {
                    isSatisfied = false;
                    break;
                }
            }
            if (isSatisfied) {
                return s;
            } else {
                continue;
            }
        }

        throw new IllegalArgumentException("no solution!");
    }

    /**
     * 个人常规解法：TreeSet实现长度及字典序排序，排除的时候倒序更快
     * 19ms 85.28%
     * @param words
     * @return
     */
    public String longestWordBetter(String[] words) {
        // 自定义key排序规则的TreeSet
        TreeSet<String> dataSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return 1;
                } else if (o1.length() > o2.length()) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        dataSet.addAll(Arrays.asList(words));

        // TreeSet的遍历
        for (String s : dataSet) {
            boolean isSatisfied = true;
            for (int i = s.length(); i > 0; i--) {
                if (!dataSet.contains(s.substring(0, i))) {
                    isSatisfied = false;
                    break;
                }
            }
            if (isSatisfied) {
                return s;
            } else {
                continue;
            }
        }

        throw new IllegalArgumentException("no solution!");
    }


    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(new LongestWordInDictionary().longestWord(words));
    }
}
