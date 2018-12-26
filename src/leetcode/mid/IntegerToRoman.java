package leetcode.mid;

import java.util.HashMap;

/**
 * @description: 12. 整数转罗马数字
 * @see: <a>https://leetcode-cn.com/problems/integer-to-roman/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/12/26 上午9:02
 * @project: cc-leetcode
 */
public class IntegerToRoman {

    /**
     * 个人常规解法：分情况拼接字符串
     * 113ms 19.69%
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        StringBuilder sb = new StringBuilder();
        int div = 1;
        while (num != 0) {
            int digital = num % 10;

            // 将对应的数转成希腊字母
            switch (digital) {
                case 0:
                    break;
                case 1:
                case 5:
                    sb.insert(0, map.get(digital * div));
                    break;
                case 2:
                    sb.insert(0, map.get(div));
                    sb.insert(0, map.get(div));
                    break;
                case 3:
                    sb.insert(0, map.get(div));
                    sb.insert(0, map.get(div));
                    sb.insert(0, map.get(div));
                    break;
                case 4:
                    sb.insert(0, map.get(5 * div));
                    sb.insert(0, map.get(div));
                    break;
                case 6:
                    sb.insert(0, map.get(div));
                    sb.insert(0, map.get(5 * div));
                    break;
                case 7:
                    sb.insert(0, map.get(div));
                    sb.insert(0, map.get(div));
                    sb.insert(0, map.get(5 * div));
                    break;
                case 8:
                    sb.insert(0, map.get(div));
                    sb.insert(0, map.get(div));
                    sb.insert(0, map.get(div));
                    sb.insert(0, map.get(5 * div));
                    break;
                case 9:
                    sb.insert(0, map.get(div * 10));
                    sb.insert(0, map.get(div));
                    break;
            }

            num /= 10;
            div *= 10;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(3));
    }
}
