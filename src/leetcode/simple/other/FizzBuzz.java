package leetcode.simple.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 412. Fizz Buzz
 * @see: <a>https://leetcode-cn.com/problems/fizz-buzz/</a>
 * @author: guoping wang
 * @date: 2018/12/9 22:17
 * @project: cc-leetcode
 */
public class FizzBuzz {


    /**
     * 个人常规解法：判断倍数直接余即可
     * 2ms 99.01%
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i >= 15 && i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i >= 3 && i % 3 == 0) {
                res.add("Fizz");
            } else if (i >= 5 && i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(i + "");
            }
        }
        return res;
    }
}
