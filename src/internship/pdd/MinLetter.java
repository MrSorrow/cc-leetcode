package internship.pdd;

import java.util.Scanner;

/**
 * @description: 输出 字母去重后字母序最小 的第一个字母
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/3/9 9:22 PM
 * @project: cc-leetcode
 */
public class MinLetter {


    /**
     * 已知大小写的52个字母，随机抽取一些字母组成字符串，
     * 对该字符串去重，也就是只允许同一字母大小写只出现一个，
     * 求去重后的各种组合，开头字母Ascii码最小的那个组合，输出该组合的第一个字母
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.toLowerCase();

        char min = 'z';

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean hasSame = false;
            for (int j = i + 1; j < str.length(); j++) {
                if (c == str.charAt(j)) {
                    hasSame = true;
                    break;
                }
            }
            if (!hasSame) {
                if (c < min) min = c;
                break;
            } else {
                if (c < min) min = c;
            }
        }

        System.out.print(min);
    }
}
