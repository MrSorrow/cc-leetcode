package leetcode.simple.other;

/**
 * @description: 953. 验证外星语词典
 * @see: <a>https://leetcode-cn.com/problems/verifying-an-alien-dictionary/</a>
 * @author: guoping wang
 * @date: 2018/12/16 11:19
 * @project: cc-leetcode
 */
public class VerifyingAnAlienDictionary {

    /**
     * 个人常规解法：用数组记录顺序用于比较
     * 6ms 88.89%
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        int[] letterSort = new int[26];
        for (int i = 0, sort = 1; i < order.length(); i++) {
            letterSort[order.charAt(i) - 'a'] = sort++;
        }
        for (int i = 0; i < words.length - 1; i++) {
            // 比较两个字符串
            char[] charArray1 = words[i].toCharArray();
            char[] charArray2 = words[i + 1].toCharArray();
            for (int j = 0; j < charArray1.length && j < charArray2.length; j++) {
                if (letterSort[charArray1[j] - 'a'] > letterSort[charArray2[j] - 'a']) {
                    return false;
                } else if (letterSort[charArray1[j] - 'a'] > letterSort[charArray2[j] - 'a']) {
                    break;
                }
                if (j == charArray2.length - 1 && j != charArray1.length - 1) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        String[] words = {"apple", "app"};
        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(words, order));
    }
}
