package leetcode.simple.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description: 136. 只出现一次的数字
 * @link: <a>https://leetcode-cn.com/problems/single-number/</a>
 * @author: guoping wang
 * @date: 2018/10/4 22:07
 * @project: cc-leetcode
 */
public class SingleNumber {

    /**
     * 个人常规解法：两次HashMap
     * 28ms 19.98%
     * @param nums
     * @return
     */
    public int singleNumberTwiceHashMap(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        for (Integer key : hashMap.keySet()) {
            if (hashMap.get(key) == 1) {
                return key;
            }
        }

        throw new IllegalArgumentException("没有出现仅一次的数字");
    }

    /**
     * 个人常规解法：一次hash
     * 21ms 24.28%
     * @param nums
     * @return
     */
    public int singleNumberOnceHashMap(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.remove(nums[i]);
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        if (hashMap.size() == 1) {
            for (Integer key : hashMap.keySet()) {
                return key;
            }
        }

        throw new IllegalArgumentException("没有出现仅一次的数字");
    }

    /**
     * 个人常规解法：排序寻找出现一次的
     * 5ms 48.62%
     * @param nums
     * @return
     */
    public int singleNumberSort(int[] nums) {
        Arrays.sort(nums);

        int index = 0;
        while (index < nums.length) {
            if (index == nums.length - 1 || nums[index] != nums[index + 1]) {
                return nums[index];
            } else {
                index += 2;
            }
        }

        throw new IllegalArgumentException("没有出现仅一次的数字");
    }

    /**
     * 最快算法：位运算，出现两次的抑或就为0,0和一个数抑或则还是那个数
     * 1ms 99.85%
     * @param nums
     */
    public int singleNumberBit(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(new SingleNumber().singleNumberSort(nums));
    }
}
