package leetcode.mid;

import java.util.*;

/**
 * @description: 127. 单词接龙
 * @see: <a>https://leetcode-cn.com/problems/word-ladder/</a>
 * @author: guoping wang
 * @date: 2019/3/2 22:39
 * @project: cc-leetcode
 */
public class WordLadder {

    /**
     * 个人常规解法：可以变成一个图的最短路径问题，用BFS解决
     * 1343ms 4.46%
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 记录访问情况
        HashMap<String, Boolean> visited = new HashMap<>(wordList.size() + 2);
        visited.put(beginWord, false);
        for (String word : wordList) {
            visited.put(word, false);
        }
        // 记录BFS的长度
        LinkedList<Integer> steps = new LinkedList<>();
        // BFS所用的队列
        Queue<String> queue = new LinkedList<>();
        // 从beginWord出发，入队
        queue.add(beginWord);
        // 第一步
        steps.add(1);

        while (!queue.isEmpty()) {
            // 出队一个进行BFS探索
            String s = queue.remove();
            int step = steps.remove();
            for (String word : wordList) {
                if (!visited.get(word) && canTransform(word, s)) {
                    if (word.equals(endWord)) {
                        return step + 1;
                    } else {
                        queue.add(word);
                        steps.add(step + 1);  // 设置第几轮BFS
                        visited.put(word, true);  // 更新访问情况
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 个人常规解法：可以变成一个图的最短路径问题，用BFS解决，将steps融入visited
     * 1056ms 8.74%
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthBetter(String beginWord, String endWord, List<String> wordList) {
        // 记录访问情况
        HashMap<String, Integer> visited = new HashMap<>(wordList.size() + 2);
        // BFS所用的队列
        Queue<String> queue = new LinkedList<>();
        // 从beginWord出发，入队
        queue.add(beginWord);
        visited.put(beginWord, 1);

        while (!queue.isEmpty()) {
            // 出队一个进行BFS探索
            String s = queue.remove();
            int step = visited.get(s);
            for (String word : wordList) {
                if (!visited.containsKey(word) && canTransform(word, s)) {
                    if (word.equals(endWord)) {
                        return step + 1;
                    } else {
                        queue.add(word);
                        visited.put(word, step + 1);  // 更新访问情况
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 判断是否能转换
     * @param from
     * @param to
     * @return
     */
    public boolean canTransform(String from, String to) {
        if (from.length() != to.length()) return false;
        int count = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i))
                count++;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(new WordLadder().ladderLengthBetter(beginWord, endWord, wordList));
    }
}
