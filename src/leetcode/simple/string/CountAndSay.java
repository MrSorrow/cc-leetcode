package leetcode.simple.string;

/**
 * @description: 38. 报数
 * @link: <a>https://leetcode-cn.com/problems/count-and-say/</a>
 * @author: guoping wang
 * @date: 2018/9/25 10:28
 * @project: cc-leetcode
 */
public class CountAndSay {

    /**
     * 个人常规解法：递归，根据n-1计算n
     * 3ms 97.63%
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String s = countAndSay(n - 1);
        StringBuilder stringBuilder = new StringBuilder();

        int index = 0;
        while (index < s.length()) {
            int count = 1;
            while (index < s.length() - 1 && s.charAt(index) == s.charAt(index + 1)) {
                index++;
                count++;
            }
            index++;
            stringBuilder.append(count).append(s.charAt(index - 1));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(2));
    }
}
