package leetcode.simple.hash;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 500. 键盘行
 * @see: <a>https://leetcode-cn.com/problems/keyboard-row/</a>
 * @author: guoping wang
 * @date: 2018/10/8 10:05
 * @project: cc-leetcode
 */
public class KeyboardRow {

    /**
     * 个人常规解法：用三个HashSet存储
     * 4ms 49.33
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        char[] c1 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] c2 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',};
        char[] c3 = {'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        HashSet<Character> row1 = new HashSet<>();
        HashSet<Character> row2 = new HashSet<>();
        HashSet<Character> row3 = new HashSet<>();

        for (char c : c1) {
            row1.add(c);
            row1.add((char) (c + 'A' - 'a'));
        }
        for (char c : c2) {
            row2.add(c);
            row2.add((char) (c + 'A' - 'a'));
        }
        for (char c : c3) {
            row3.add(c);
            row3.add((char) (c + 'A' - 'a'));
        }

        List<String> resList = new ArrayList<>();
        for (String word : words) {
            if ("".equals(word)) {
                continue;
            }
            if (word.length() == 1) {
                resList.add(word);
                continue;
            }
            if (row1.contains(word.charAt(0))) {
                for (int i = 1; i < word.length(); i++) {
                    if (!row1.contains(word.charAt(i))) {
                        break;
                    }
                    if (i == word.length() - 1) {
                        resList.add(word);
                    }
                }

            }
            if (row2.contains(word.charAt(0))) {
                for (int i = 1; i < word.length(); i++) {
                    if (!row2.contains(word.charAt(i))) {
                        break;
                    }
                    if (i == word.length() - 1) {
                        resList.add(word);
                    }
                }
            }
            if (row3.contains(word.charAt(0))) {
                for (int i = 1; i < word.length(); i++) {
                    if (!row3.contains(word.charAt(i))) {
                        break;
                    }
                    if (i == word.length() - 1) {
                        resList.add(word);
                    }
                }
            }
        }

        return resList.toArray(new String[resList.size()]);
    }

    /**
     * 个人常规优化：hashset意味着可以用数组
     * 2ms 99.70%
     * @param words
     * @return
     */
    public String[] findWordsArray(String[] words) {
        char[] c1 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] c2 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',};
        char[] c3 = {'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        int[] row1 = new int[58];
        int[] row2 = new int[58];
        int[] row3 = new int[58];

        for (char c : c1) {
            row1[c - 'A']++;
            row1[c - 'a']++;
        }
        for (char c : c2) {
            row2[c - 'A']++;
            row2[c - 'a']++;
        }
        for (char c : c3) {
            row3[c - 'A']++;
            row3[c - 'a']++;
        }

        List<String> resList = new ArrayList<>();
        for (String word : words) {
            if ("".equals(word)) {
                continue;
            }
            if (word.length() == 1) {
                resList.add(word);
                continue;
            }
            if (row1[word.charAt(0) - 'A'] != 0) {
                for (int i = 1; i < word.length(); i++) {
                    if (row1[word.charAt(i) - 'A'] == 0) {
                        break;
                    }
                    if (i == word.length() - 1) {
                        resList.add(word);
                    }
                }

            }
            if (row2[word.charAt(0) - 'A'] != 0) {
                for (int i = 1; i < word.length(); i++) {
                    if (row2[word.charAt(i) - 'A'] == 0) {
                        break;
                    }
                    if (i == word.length() - 1) {
                        resList.add(word);
                    }
                }
            }
            if (row3[word.charAt(0) - 'A'] != 0) {
                for (int i = 1; i < word.length(); i++) {
                    if (row3[word.charAt(i) - 'A'] == 0) {
                        break;
                    }
                    if (i == word.length() - 1) {
                        resList.add(word);
                    }
                }
            }
        }

        return resList.toArray(new String[resList.size()]);
    }


    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        ArrayUtils.printStringArray(new KeyboardRow().findWords(words));
        ArrayUtils.printStringArray(new KeyboardRow().findWordsArray(words));
    }
}
