package leetcode.simple.math;

/**
 * @description: 171. Excel表序列号
 * @see: <a>https://leetcode-cn.com/problems/excel-sheet-column-number/</a>
 * @author: guoping wang
 * @date: 2018/10/23 13:10
 * @project: cc-leetcode
 */
public class ExcelSheetColumnNumber {

    /**
     * 个人常规解法：相当于26进制的数
     * 4ms 41.54%
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        char[] charArray = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[charArray.length - i - 1];
            int n = c - 'A' + 1;
            sum = sum + n * (int) Math.pow(26, i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
    }
}
