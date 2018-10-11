package leetcode.simple.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 884. 两句话中的不常见单词
 * @see: <a>https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/</a>
 * @author: guoping wang
 * @date: 2018/10/11 9:58
 * @project: cc-leetcode
 */
public class UncommonWordsFromTwoSentences {

    /**
     * 个人常规解法：题目就是寻找总共出现一次的单词
     * 7ms 96.77%
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences(String A, String B) {
        String[] aStrs = A.split(" ");
        String[] bStrs = B.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (String aStr : aStrs) {
            if (map.containsKey(aStr)) {
                map.put(aStr, map.get(aStr) + 1);
            } else {
                map.put(aStr, 1);
            }
        }

        for (String bStr : bStrs) {
            if (map.containsKey(bStr)) {
                map.put(bStr, map.get(bStr) + 1);
            } else {
                map.put(bStr, 1);
            }
        }

        List<String> res = new ArrayList<>();

        // 遍历hashMap寻找只有一次的
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                res.add(s);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
