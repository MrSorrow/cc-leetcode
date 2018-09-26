package leetcode.simple.string;

/**
 * @description: 345. 反转字符串中的元音字母
 * @link: <a>https://leetcode-cn.com/problems/reverse-vowels-of-a-string/</a>
 * @author: guoping wang
 * @date: 2018/9/26 8:45
 * @project: cc-leetcode
 */
public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfAString().reverseVowels("leetcode"));
    }

    /**
     * 个人常规解法：首尾指针寻找元音字母并进行反序
     * 5ms 82.98%
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            // 寻找第一个元音字母
            while (start <= end) {
                if (isVowels(charArray[start]) && isVowels(charArray[end])) {
                    break;
                }
                if (!isVowels(charArray[start])) {
                    start++;
                }
                if (!isVowels(charArray[end])) {
                    end--;
                }
            }

            // 如果寻找成功
            if (start <= end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
            }

            start++;
            end--;
        }
        return String.valueOf(charArray);
    }

    public boolean isVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}
