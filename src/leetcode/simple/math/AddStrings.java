package leetcode.simple.math;

/**
 * @description: 415.字符串相加
 * @see: <a>https://leetcode-cn.com/problems/add-strings/</a>
 * @author: guoping wang
 * @date: 2018/10/27 20:10
 * @project: cc-leetcode
 */
public class AddStrings {

    /**
     * 个人常规解法：直接按位相加，设置一个进位标识
     * 24ms 79.87%
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sbNum1 = new StringBuilder(num1).reverse();
        StringBuilder sbNum2 = new StringBuilder(num2).reverse();
        StringBuilder sb = new StringBuilder();
        int bitFlag = 0;  // 进位标识
        int i = 0; // 访问索引
        for (; i < sbNum1.length() || i < sbNum2.length(); i++) {
            int num1char = i < sbNum1.length() ? sbNum1.charAt(i) - '0' : 0;
            int num2char = i < sbNum2.length() ? sbNum2.charAt(i) - '0' : 0;
            int bitSum = num1char + num2char + bitFlag;
            bitFlag = bitSum >= 10 ? 1 : 0;
            sb.insert(0, bitSum % 10);
        }
        if (bitFlag == 1) {
            sb.insert(0, bitFlag);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("1", "9"));
    }
}
