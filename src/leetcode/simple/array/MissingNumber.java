package leetcode.simple.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @description: 268. 缺失数字
 * @link: <a>https://leetcode-cn.com/problems/missing-number/description/</a>
 * @author: guoping wang
 * @date: 2018/8/27 14:33
 * @project: cc-leetcode
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new MissingNumber().missingNumberSort(nums));
    }

    /**
     * 个人常规解法：hashset查找快
     * 18ms 6.86%
     * @param nums
     * @return
     */
    public int missingNumberHashSet(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        throw new IllegalArgumentException("No missing number!");
    }

    /**
     * 个人常规解法：排序查看
     * 12ms 20.67%
     * @param nums
     * @return
     */
    public int missingNumberSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            if (i >= nums.length || i != nums[i]) {
                return i;
            }
        }
        throw new IllegalArgumentException("No missing number!");
    }

    /**
     * 个人常规解法：和相减
     * 1ms 95.74%
     * @param nums
     * @return
     */
    public int missingNumberSub(int[] nums) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            sum2 += i;
        }
        sum2 += nums.length;
        return sum2 - sum1;
    }

    /**
     * 最优解法：和相减
     *0ms 100%
     * @param nums
     * @return
     */
    public int missingNumberBetterSub(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (nums.length * (nums.length + 1)) / 2 - sum;
    }
}
