package leetcode.simple.string;

/**
 * @description: 387. 字符串中的第一个唯一字符
 * @link: <a>https://leetcode-cn.com/problems/first-unique-character-in-a-string/</a>
 * @author: guoping wang
 * @date: 2018/9/26 9:56
 * @project: cc-leetcode
 */
public class FirstUniqueCharacterInAString {

    /**
     * 个人常规解法：数组计数再寻找第一个
     * 12ms 93.21%
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        char[] array = s.toCharArray();
        int[] counter = new int[128];
        int index = -1;

        // 统计字符
        for (int i = 0; i < array.length; i++) {
            counter[array[i]]++;
        }

        // 寻找第一个唯一字符
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 1) {
                char c = (char) i;
                if (s.indexOf(c) < index || index == -1) {
                    index = s.indexOf(c);
                }
            }
        }

        return index;
    }

    /**
     * 最快的算法：查看26个字母第一个索引是否与最后一次索引相同
     * 6ms 100%
     * @param s
     * @return
     */
    public int firstUniqCharFast(String s) {
        int res = -1;
        for (char i = 'a'; i <= 'z'; i++) {
            int firstIndex = s.indexOf(i);
            // 如果存在这个字母且唯一，需要更新res
            if (firstIndex != -1 && firstIndex == s.lastIndexOf(i)) {
                res = res == -1 ? firstIndex : Math.min(firstIndex, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterInAString().firstUniqChar("loveleetcode"));
    }
}
