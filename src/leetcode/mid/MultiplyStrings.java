package leetcode.mid;

/**
 * @description: 43. 字符串相乘
 * @see: <a>https://leetcode-cn.com/problems/multiply-strings/</a>
 * @author: guoping wang
 * @date: 2019/1/7 13:18
 * @project: cc-leetcode
 */
public class MultiplyStrings {

    /**
     * 个人常规解法：相乘法则，利用字符串先位乘再相加
     * 55ms 26.94%
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";

        StringBuilder res = new StringBuilder();

        for (int i = num1.length() - 1; i >= 0; i--) {
            int multi = num1.charAt(i) - '0';

            int extra = 0; StringBuilder sb = new StringBuilder();
            for (int j = num2.length() - 1; j >= 0; j--) {
                int num = multi * (num2.charAt(j) - '0') + extra;
                sb.insert(0, num % 10);
                extra = num / 10;
            }
            if (extra > 0)
                sb.insert(0, extra);

            for (int j = 0; j < num1.length() - i - 1; j++) {
                sb.append(0);
            }

            extra = 0; StringBuilder sbAdd = new StringBuilder();
            for (int j = res.length() - 1, k = sb.length() - 1; j >= 0 || k >= 0; j--, k--) {
                int n1 = j >= 0 ? res.charAt(j) - '0' : 0;
                int n2 = k >= 0 ? sb.charAt(k) - '0' : 0;
                int num = n1 + n2 + extra;
                sbAdd.insert(0, num % 10);
                extra = num / 10;
            }
            if (extra > 0)
                sbAdd.insert(0, extra);
            res = sbAdd;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("98", "9"));
    }
}
