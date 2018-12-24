package leetcode.mid;

/**
 * @description: 6. Z 字形变换
 * @see: <a>https://leetcode-cn.com/problems/zigzag-conversion/</a>
 * @author: guoping wang
 * @date: 2018/12/24 20:40
 * @project: cc-leetcode
 */
public class ZigzagConversion {

    /**
     * 个人常规解法：计算转换公式，发现规律
     * 54ms 67.17%
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder res = new StringBuilder();
        // 行数上
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = 0; 2 * (numRows - 1) * j + i < s.length(); j++) {
                    res.append(s.charAt(2 * (numRows - 1) * j + i));
                }
            } else {
                for (int j = 0; (numRows - 1) * j < s.length(); j++) {
                    // 下标
                    int index = j % 2 == 0 ? (numRows - 1) * j + i : (numRows - 1) * (j + 1) - i;
                    if (index < s.length()) {
                        res.append(s.charAt(index));
                    }
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("A", 1));
    }
}
