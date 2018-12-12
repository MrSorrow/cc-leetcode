package leetcode.simple.hash;

/**
 * @description: 748. 最短完整词
 * @see: <a>https://leetcode-cn.com/problems/shortest-completing-word/</a>
 * @author: guoping wang
 * @date: 2018/12/12 10:06
 * @project: cc-leetcode
 */
public class ShortestCompletingWord {

    /**
     * 个人常规解法：遍历记录最短
     * 7ms 100%
     * @param licensePlate
     * @param words
     * @return
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licensePlateArr = new int[26];
        licensePlate = licensePlate.toLowerCase();
        for (int i = 0; i < licensePlate.length(); i++) {
            if (Character.isLetter(licensePlate.charAt(i)))
                licensePlateArr[licensePlate.charAt(i) - 'a']++;
        }

        String res = null;
        // 遍历查看words是否包含licensePlate
        for (int i = 0; i < words.length; i++) {
            if (isContain(licensePlateArr, words[i])) {
                if ((res == null) || (res != null && res.length() > words[i].length())) {
                        res = words[i];
                }
            }
        }

        return res;
    }

    /**
     * 通过数组来判断是否是完整词
     * @param licensePlate
     * @param word
     * @return
     */
    public boolean isContain(int[] licensePlate, String word) {
        int[] wordArr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            wordArr[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (licensePlate[i] > wordArr[i]) {
                return false;
            }
        }
        return true;
    }
}
