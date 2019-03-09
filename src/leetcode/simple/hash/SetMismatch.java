package leetcode.simple.hash;

import utils.ArrayUtils;

/**
 * @description: 645. 错误的集合
 * @see: <a>https://leetcode-cn.com/problems/set-mismatch/</a>
 * @author: guoping wang
 * @date: 2018/10/10 12:38
 * @project: cc-leetcode
 */
public class SetMismatch {

    /**
     * 个人常规解法：用数组计数，然后寻找缺失与重复的值
     * 6ms 100%
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] counter = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }
        for (int i = 1; i < counter.length; i++) {
            if (counter[i] == 0) {
                res[1] = i;
            } else if (counter[i] > 1) {
                res[0] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        ArrayUtils.printIntArray(new SetMismatch().findErrorNums(nums));
    }
}
