package leetcode.simple.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 728.自除数
 * @see: <a>https://leetcode-cn.com/problems/self-dividing-numbers/</a>
 * @author: guoping wang
 * @date: 2018/10/28 16:00
 * @project: cc-leetcode
 */
public class SelfDividingNumbers {

    /**
     * 个人常规解法：正常的按照题目要求，数字的每一位进行判断
     * 7ms 63.42
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            // 判断每一个数
            int num = i;
            boolean isselfDividingNumber = true;
            while (num != 0) {
                if (num % 10 == 0) {
                    isselfDividingNumber = false;
                } else if (i % (num % 10) != 0) {
                    isselfDividingNumber = false;
                }
                num /= 10;
            }
            if (isselfDividingNumber) {
                res.add(i);
            }
        }
        return res;
    }
}
