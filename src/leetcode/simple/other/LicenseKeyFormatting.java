package leetcode.simple.other;

/**
 * @description: 482. 密钥格式化
 * @see: <a>https://leetcode-cn.com/problems/license-key-formatting/</a>
 * @author: guoping wang
 * @date: 2018/12/13 13:19
 * @project: cc-leetcode
 */
public class LicenseKeyFormatting {

    /**
     * 个人常规解法：主要就是重组字符串，可能利用数组倒序遍历插入的方式更快
     * 51ms 39.02%
     * @param S
     * @param K
     * @return
     */
    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "");
        if ("".equals(S)) return "";
        int firstLength = S.length() % K;
        firstLength = firstLength == 0 ? K : firstLength;

        StringBuilder res = new StringBuilder(S.substring(0, firstLength));
        for (int i = 0; i < (S.length() - firstLength) / K; i++) {
            res.append("-");
            if (i == (S.length() - firstLength) / K - 1) {
                res.append(S.substring(firstLength + i * K));
            } else {
                res.append(S.substring(firstLength + i * K, firstLength + (i + 1) * K));
            }
        }

        return res.toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("---", 4));
    }
}
