package leetcode.simple.bit;

/**
 * @description: 405. 数字转换为十六进制数
 * @see: <a>https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/</a>
 * @author: guoping wang
 * @date: 2018/10/18 22:11
 * @project: cc-leetcode
 */
public class ConvertANumberToHexadecimal {

    /**
     * 个人常规解法：JDK中的方法
     * 7ms 86.53%
     * @param num
     * @return
     */
    public String toHexJdk(int num) {
        return Integer.toHexString(num);
    }

    /**
     * 个人常规解法：二进制的统计，末尾向高位进行
     * 5ms 98.99%
     * @param num
     * @return
     */
    public String toHexRight(int num) {
        if (num == 0) return "0";

        String[] strs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                int bit = (num >> j) & 1;
                sum += (bit << j);
            }

            stringBuilder.insert(0, strs[sum]);
            num >>>= 4;
        }


        // 去除左边的0
        int index = 0;
        for (; index < stringBuilder.length(); index++) {
            if (stringBuilder.charAt(index) != '0') {
                break;
            }
        }
        return stringBuilder.substring(index);
    }

    /**
     * 个人常规解法：二进制的统计，高位向末位进行
     * 7ms 86.53%
     * @param num
     * @return
     */
    public String toHexLeft(int num) {
        if (num == 0) return "0";

        String[] strs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        StringBuilder stringBuilder = new StringBuilder();

        boolean hasNotZeroNum = false;
        for (int i = 0; i < 8; i++) {

            int sum = 0;
            for (int j = 3; j >= 0; j--) {
                int bit = ((num << (i * 4 + j)) & 0x80000000) >>> 31;
                sum += (bit << (3 - j));
            }

            if (sum == 0) {
                if (hasNotZeroNum) {
                    stringBuilder.append(0);
                }
            } else {
                stringBuilder.append(strs[sum]);
                hasNotZeroNum = true;
            }
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(new ConvertANumberToHexadecimal().toHexLeft(26));
    }
}
