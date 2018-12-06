package leetcode.simple.string;

import java.util.HashSet;

/**
 * @description: 804. 唯一摩尔斯密码词
 * @see: <a>https://leetcode-cn.com/problems/unique-morse-code-words/</a>
 * @author: guoping wang
 * @date: 2018/12/6 14:43
 * @project: cc-leetcode
 */
public class UniqueMorseCodeWords {

    /**
     * 个人常规解法：利用HashSet去重即可
     * 6ms 99.47%
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> resultSet = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(codes[word.charAt(i) - 'a']);
            }
            resultSet.add(sb.toString());
        }

        return resultSet.size();
    }
}
