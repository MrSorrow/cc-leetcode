package leetcode.simple.string;

import java.util.Arrays;

/**
 * @description: 443. 压缩字符串
 * @link: <a>https://leetcode-cn.com/problems/string-compression/</a>
 * @author: guoping wang
 * @date: 2018/9/26 17:08
 * @project: cc-leetcode
 */
public class StringCompression {

    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(new StringCompression().compress(chars));
    }

    /**
     * 个人常规解法：遍历压缩
     * 5ms 99.68%
     * @param chars
     * @return
     */
    public int compress(char[] chars) {

        int length = 0;

        // 用于统计每个单词的个数
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
            } else {
                chars[length++] = chars[i]; // 先加上字符占位,并赋值
                if (count > 1) {
                    // 长度计算公式 next_length = length + (字符占位 + count位数)

                    // 再加上count位数
                    char[] countArr = String.valueOf(count).toCharArray();
                    for (int j = 0; j < countArr.length; j++) {
                        chars[length++] = countArr[j];
                    }
                    count = 1;
                }
            }
        }

        return length;
    }
}
