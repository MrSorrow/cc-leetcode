package leetcode.simple.string;

/**
 * @description: 696. 计数二进制子串
 * @link: <a>https://leetcode-cn.com/problems/count-binary-substrings/</a>
 * @author: guoping wang
 * @date: 2018/9/30 13:24
 * @project: cc-leetcode
 */
public class CountBinarySubstrings {

    /**
     * 个人常规解法：切分出都是0和1的子串,递归
     * 超时 80/90
     * @param s
     * @return
     */
    public int countBinarySubstringsCir(String s) {
        // 递归条件
        if (!s.contains("0") || !s.contains("1")) {
            return 0;
        }

        int index = 0;
        int count = 0;

        int count1 = 1, count2 = 1;

        // 确定前半部分
        while (index < s.length() - 1) {
            if (s.charAt(index) == s.charAt(index + 1)) {
                index++;
                count1++;
            } else {
                break;
            }
        }

        int nextIndex = index;
        index++;
        // 确定后半部分
        while (index < s.length() - 1) {
            if (s.charAt(index) == s.charAt(index + 1)) {
                index++;
                count2++;
            } else {
                break;
            }
        }
        count += Math.min(count1, count2);

        return count + countBinarySubstringsCir(s.substring(nextIndex + 1));
    }

    /**
     * 个人常规解法：不用递归，在处理第一个的时候，左半部分count为0
     * 22ms 79.91%
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int count = 0;
        int index = 0;
        int lastLength = 0;
        // 这个条件有点讲究
        while (index < s.length()) {
            int length = 1;
            // 找到连续部分
            while (index < s.length() - 1) {
                if (s.charAt(index) == s.charAt(index + 1)) {
                    index++;
                    length++;
                } else {
                    break;
                }
            }
            count += Math.min(lastLength, length);
            lastLength = length;
            index++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountBinarySubstrings().countBinarySubstringsCir("00110"));
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("001101"));
    }
}
