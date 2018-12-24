package leetcode.mid;

/**
 * @description: 8. 字符串转换整数 (atoi)
 * @see: <a>https://leetcode-cn.com/problems/string-to-integer-atoi/</a>
 * @author: guoping wang
 * @date: 2018/12/24 21:28
 * @project: cc-leetcode
 */
public class StringToIntegerAtoi {

    /**
     * 个人常规解法：正常遍历即可，判断溢出则用try-catch方法，题意要求是遇到符号紧接着的数字字符解析为整数，不能隔着字母
     * 28ms 91.18%
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        int index = 0;
        boolean neg = false;
        StringBuilder sb = new StringBuilder();

        // 判断首字母
        while (index < str.length()) {
            if (str.charAt(index) != ' ') {
                if (str.charAt(index) == '-') {
                    neg = true;
                    index++;
                    break;
                } else if (Character.isDigit(str.charAt(index))) {
                    sb.append(str.charAt(index));
                    index++;
                    break;
                } else if (str.charAt(index) == '+') {
                    index++;
                    break;
                } else {
                    return 0;
                }
            }
            index++;
        }

        // 确定了符号寻找接下来的数字，遇到字母就断了
        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index)))
                sb.append(str.charAt(index++));
            else
                break;
        }

        if ("".equals(sb.toString())) {
            return 0;
        }

        try {
            return neg ? -Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        System.out.println(new StringToIntegerAtoi().myAtoi("+-2"));
    }
}
