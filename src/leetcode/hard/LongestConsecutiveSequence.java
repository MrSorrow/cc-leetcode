package leetcode.hard;

import java.util.HashMap;

/**
 * @description: 128. 最长连续序列
 * @see: <a>https://leetcode-cn.com/problems/longest-consecutive-sequence/</a>
 * @author: guoping wang
 * @date: 2019/3/2 21:25
 * @project: cc-leetcode
 */
public class LongestConsecutiveSequence {

    /**
     * 个人常规解法：用数组计数
     * 执行出错，遇到最小值真的是Integer.MIN_VALUE，数组就分配不了了
     * @param nums
     * @return
     */
    public int longestConsecutiveArrayCount(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (min > num) min = num;
            if (max < num) max = num;
        }
        int[] array = new int[max - min + 1];
        for (int num : nums) {
            array[num - min] = 1;
        }

        // 寻找最大连续数组
        int res = 0, count = 0;
        for (int i : array) {
            if (i <= 0) {
                if (count > res) res = count;
                count = 0;
            } else {
                count++;
            }
        }
        return res;
    }

    /**
     * 参考解法：利用HashMap保存更新每个数字的最大连续长度，满足O(n)复杂度，空间换时间
     * 14ms 56.41%
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> record = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (!record.containsKey(num)) {
                // 关键是这个更新规则：新增了一个点，那么拼接起来的时候两个端点一定要全部更新

                int left = record.getOrDefault(num - 1, 0); // 左侧有没有?
                int right = record.getOrDefault(num + 1, 0); // 右侧有没有?
                int value = left + right + 1;
                record.put(num, value);
                if (res < value) res = value;

                // 更新开始
                if (left > 0) record.put(num - left, value);
                if (right > 0) record.put(num + right, value);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }
}
