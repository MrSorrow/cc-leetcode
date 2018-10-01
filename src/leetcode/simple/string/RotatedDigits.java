package leetcode.simple.string;

/**
 * @description: 788. 旋转数字
 * @link: <a>https://leetcode-cn.com/problems/rotated-digits/</a>
 * @author: guoping wang
 * @date: 2018/10/1 13:15
 * @project: cc-leetcode
 */
public class RotatedDigits {

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isValidSimple(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 个人常规解法：完全按照条件进行编写
     * 118ms 8.13%
     * @param x
     * @return
     */
    private boolean isValid(int x) {
        String xStr = String.valueOf(x);
        if (xStr.contains("3") || xStr.contains("4") || xStr.contains("7")) {
            return false;
        }
        xStr = xStr.replace("2", "*");
        xStr = xStr.replace("5", "2");
        xStr = xStr.replace("*", "5");
        xStr = xStr.replace("6", "*");
        xStr = xStr.replace("9", "6");
        xStr = xStr.replace("*", "9");

        if (Integer.valueOf(xStr) != x) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 个人常规解法：要想变换前后不一样，必须包含25或者69
     * 35ms 44.72%%
     * @param x
     * @return
     */
    private boolean isValidSimple(int x) {
        String xStr = String.valueOf(x);
        if (xStr.contains("3") || xStr.contains("4") || xStr.contains("7")
                || (!xStr.contains("2") && !xStr.contains("5") && !xStr.contains("6") && !xStr.contains("9"))) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RotatedDigits().rotatedDigits(10));
    }
}
