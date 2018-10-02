package leetcode.simple.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @description: 819. 最常见的单词
 * @link: <a>https://leetcode-cn.com/problems/most-common-word/</a>
 * @author: guoping wang
 * @date: 2018/10/2 8:35
 * @project: cc-leetcode
 */
public class MostCommonWord {

    /**
     * 常规解法：haspmap统计次数，找出最大
     * 44ms 36.40%
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWordMap(String paragraph, String[] banned) {

        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replace("!", " ");
        paragraph = paragraph.replace("?", " ");
        paragraph = paragraph.replace("'", "");
        paragraph = paragraph.replace(",", " ");
        paragraph = paragraph.replace(";", " ");
        paragraph = paragraph.replace(".", " ");

        paragraph = paragraph.replaceAll("\\s{1,}", " ");

        for (String ban : banned) {
            paragraph = paragraph.replace(ban + " ", "");
        }

        for (String ban : banned) {
            paragraph = paragraph.replace(ban, "");
        }

        HashMap<String, Integer> map = new HashMap<>();
        String[] pars = paragraph.split(" ");
        String res = null;
        int max = 0;
        for (String par : pars) {
            if (map.containsKey(par)) {
                map.put(par, map.get(par) + 1);
            } else {
                map.put(par, 1);
            }
            if (map.get(par) > max) {
                max = map.get(par);
                res = par;
            }
        }
        return res;
    }

    /**
     * 个人常规解法：用正则解决问题替换标点符号
     * 60ms 23.90%
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWordReg(String paragraph, String[] banned) {

        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[!?',;.]", " ");
        paragraph = paragraph.replaceAll("\\s{1,}", " ");

        paragraph += " ";
        for (String ban : banned) {
            paragraph = paragraph.replace(ban + " ", "");
        }

        HashMap<String, Integer> map = new HashMap<>();
        String[] pars = paragraph.split(" ");
        String res = null;
        int max = 0;
        for (String par : pars) {
            if (map.containsKey(par)) {
                map.put(par, map.get(par) + 1);
            } else {
                map.put(par, 1);
            }
            if (map.get(par) > max) {
                max = map.get(par);
                res = par;
            }
        }
        return res;
    }

    /**
     * 用正则解决问题替换标点符号，先不进行去除ban中的字符
     * 39ms 43.38%
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWordFast(String paragraph, String[] banned) {

        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[!?',;.]", " ").trim();
        paragraph = paragraph.replaceAll("\\s{1,}", " ");

        HashSet<String> set = new HashSet<>(banned.length);
        set.addAll(Arrays.asList(banned));

        HashMap<String, Integer> map = new HashMap<>();
        String[] pars = paragraph.split(" ");
        String res = null;

        int max = 0;
        for (String par : pars) {
            if (set.contains(par)) {
                continue;
            }
            if (map.containsKey(par)) {
                map.put(par, map.get(par) + 1);
            } else {
                map.put(par, 1);
            }
            if (map.get(par) > max) {
                max = map.get(par);
                res = par;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b,b,b,c, c!";
        String[] banned = {"a"};
        System.out.println(new MostCommonWord().mostCommonWordMap(paragraph, banned));
        System.out.println(new MostCommonWord().mostCommonWordReg(paragraph, banned));
        System.out.println(new MostCommonWord().mostCommonWordFast(paragraph, banned));
    }
}
