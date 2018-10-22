package leetcode.simple.math;

/**
 * @description: 168. Excel表列名称
 * @see: <a>https://leetcode-cn.com/problems/excel-sheet-column-title/</a>
 * @author: guoping wang
 * @date: 2018/10/22 22:18
 * @project: cc-leetcode
 */
public class ExcelSheetColumnTitle {

    /**
     * 个人常规解法：不停的除以26，除的尽的话要减去一个26，因为末尾Z能表示掉一个26
     * 0ms 100%
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            if (n % 26 != 0) {
                sb.insert(0, (char) (n % 26 + 'A' - 1));
            } else {
                sb.insert(0, 'Z');
                n -= 26;  // 这里要减去1个26
            }
            n /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(26));
    }
}
