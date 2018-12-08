package leetcode.simple.dynamicprogram;

/**
 * @description: 303. 区域和检索 - 数组不可变
 * @see: <a>https://leetcode-cn.com/problems/range-sum-query-immutable/</a>
 * @author: guoping wang
 * @date: 2018/12/8 9:36
 * @project: cc-leetcode
 */
public class RangeSumQueryImmutable {

    class NumArray {

        private int[] records;

        public NumArray(int[] nums) {
            records = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                records[i + 1] = records[i] + nums[i];
            }
        }

        /**
         * 个人常规解法：动归，由于会多次调用sumRange方法，所以需要记录中间值
         * 153ms 98.38%
         * @param i
         * @param j
         * @return
         */
        public int sumRange(int i, int j) {
            // record 1-n 的下标存储了值
            i = Math.max(i, 0);
            i = Math.min(i, records.length - 2);
            j = Math.max(j, 0);
            j = Math.min(j, records.length - 2);
            return records[j + 1] - records[i];
        }
    }
}
