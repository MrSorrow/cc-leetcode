package leetcode.simple.string;

/**
 * @description: 67. 二进制求和
 * @link: <a>https://leetcode-cn.com/problems/add-binary/</a>
 * @author: guoping wang
 * @date: 2018/9/25 14:23
 * @project: cc-leetcode
 */
public class AddBinary {

    /**
     * 个人常规解法：按照正常的相加进位计算结果O(n)
     * 3ms 89.97%
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int l = Math.min(a.length(), b.length());
        int m = Math.max(a.length(), b.length());

        // 进位标记
        int add = 0;

        // 两者相加
        for (int i = 0; i < l; i++) {
            char ai = a.charAt(a.length() - 1 - i);
            char bi = b.charAt(b.length() - 1 - i);
            int bitRes = ai - '0' + bi - '0' + add;
            if (bitRes > 1) {
                add = 1;
                res.append(bitRes % 2);
            } else {
                add = 0;
                res.append(bitRes);
            }
        }

        // 处理字符串剩下的
        for (int i = l; i < m; i++) {
            char ai;
            if (a.length() > b.length()) {
                ai = a.charAt(a.length() - 1 - i);
            } else {
                ai = b.charAt(b.length() - 1 - i);
            }

            int bitRes = ai - '0' + add;
            if (bitRes > 1) {
                add = 1;
                res.append(0);
            } else {
                add = 0;
                res.append(bitRes);
            }
        }

        if (add == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }
}
