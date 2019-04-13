package internship.huawei;

import java.util.Scanner;

/**
 * 解析字符串，字符串中包含括号，括号已经匹配好，括号前面的数字代表括号内的字符串重复次数
 * 解析完的字符串再进行倒序输出
 */
public class ParseString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringBuilder sb = solution(line);
        System.out.println(sb.toString());
        sb.reverse();
        System.out.println(sb.toString());
    }

    private static StringBuilder solution(String line) {
        StringBuilder res = new StringBuilder();
        int leftKuoIndex = Integer.MAX_VALUE;
        if (line.indexOf("(") != -1)
            leftKuoIndex = Math.min(line.indexOf("("), leftKuoIndex);
        if (line.indexOf("[") != -1)
            leftKuoIndex = Math.min(line.indexOf("["), leftKuoIndex);
        if (line.indexOf("{") != -1)
            leftKuoIndex = Math.min(line.indexOf("{"), leftKuoIndex);
        if (leftKuoIndex == Integer.MAX_VALUE) leftKuoIndex = -1;
        int rightKuoIndex = leftKuoIndex + 1;

        if (leftKuoIndex == -1) {
            return new StringBuilder(line);
        }

        int leftKuo = 1, rightKuo = 0;

        for (int i = leftKuoIndex + 1; i < line.length(); i++) {
            if (line.charAt(i) == '(' || line.charAt(i) == '[' || line.charAt(i) == '{') {
                leftKuo++;
            }
            if (line.charAt(i) == ')' || line.charAt(i) == ']' || line.charAt(i) == '}') {
                rightKuo++;
            }
            if (leftKuo == rightKuo) {
                rightKuoIndex = i;
                break;
            }
        }

        int digitalIndex = leftKuoIndex - 1;
        while (digitalIndex >= 0 && Character.isDigit(line.charAt(digitalIndex))) {
            digitalIndex--;
        }
        if (Character.isDigit(line.charAt(0))) {
            for (int j = 0; j < Integer.valueOf(line.substring(digitalIndex + 1, leftKuoIndex)); j++) {
                res.append(solution(line.substring(leftKuoIndex + 1, rightKuoIndex)));
            }
        } else {
            // 寻找到数字并解析
            res.append(line.substring(0, digitalIndex + 1));

            for (int j = 0; j < Integer.valueOf(line.substring(digitalIndex + 1, leftKuoIndex)); j++) {
                res.append(solution(line.substring(leftKuoIndex + 1, rightKuoIndex)));
            }
        }

        res.append(solution(line.substring(rightKuoIndex + 1)));
        return res;
    }

//    3(aBc)2(asc)
//    ba3(ad)2(s)A
//    x3(2(a)2(S4(f)))b
}
