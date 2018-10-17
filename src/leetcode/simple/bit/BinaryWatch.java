package leetcode.simple.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 401. 二进制手表
 * @see: <a>https://leetcode-cn.com/problems/binary-watch/</a>
 * @author: guoping wang
 * @date: 2018/10/17 16:32
 * @project: cc-leetcode
 */
public class BinaryWatch {

    /**
     * 不应该去寻找有多少种组合数，而是应该从有限的时钟分钟组合来下手
     * 20ms 42.42%
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    res.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return res;
    }
}
