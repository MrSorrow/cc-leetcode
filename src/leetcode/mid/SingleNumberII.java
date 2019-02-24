package leetcode.mid;

/**
 * @description: 137. 只出现一次的数字 II
 * @see: <a>https://leetcode-cn.com/problems/single-number-ii/</a>
 * @author: guoping wang
 * @date: 2019/2/24 15:24
 * @project: cc-leetcode
 */
public class SingleNumberII {

    /**
     * 数字逻辑电路解法，真的6啊，参考https://blog.csdn.net/jiangxiewei/article/details/82227451
     * 2ms 79.39%
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int temp = (a & ~b & ~num) + (~a & b & num);
            b = (~a & b & ~num) + (~a & ~b & num);
            a = temp;
        }
        return b;
    }
}
