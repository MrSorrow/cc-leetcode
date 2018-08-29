package leetcode.simple.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @description:  532. 数组中的K-diff数对
 * @link: <a>https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/description/</a>
 * @author: guoping wang
 * @date: 2018/8/28 13:04
 * @project: cc-leetcode
 */
public class KDiffPairsInAnArray {

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 0;
        System.out.println(new KDiffPairsInAnArray().findPairsTravel(nums, k));
        System.out.println(new KDiffPairsInAnArray().findPairsFindBetter(nums, k));
        System.out.println(new KDiffPairsInAnArray().findPairsFindBetterAndBetter(nums, k));
        System.out.println(new KDiffPairsInAnArray().findPairsFindFast(nums, k));
    }

    /**
     * 个人常规解法：遍历所有情况，存入hashset去重
     * 很荣幸超时  66/76
     * @param nums
     * @param k
     * @return
     */
    public int findPairsTravel(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    hashSet.add(Math.max(nums[i], nums[j]));
                }
            }
        }
        return hashSet.size();
    }

    /**
     * 个人解法，遍历一次，然后查找更快 两次哈希
     * 33ms 48.23%
     * @param nums
     * @param k
     * @return
     */
    public int findPairsFindBetter(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        // 存入数组的值和索引
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        // 检索目标数
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i] - k) && hashMap.get(nums[i] - k) != i) {
                hashSet.add(nums[i] - k);
            }
            if ((hashMap.containsKey(nums[i] + k) && hashMap.get(nums[i] + k) != i)) {
                hashSet.add(nums[i]);
            }
        }
        return hashSet.size();
    }

    /**
     * 个人解法，遍历一次，然后查找更快 一次哈希
     * 31ms 57.08%
     * @param nums
     * @param k
     * @return
     */
    public int findPairsFindBetterAndBetter(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        // 存入数组的值和索引
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // 检索目标数
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i] - k) && hashMap.get(nums[i] - k) != i) {
                hashSet.add(nums[i] - k);
            }
            if ((hashMap.containsKey(nums[i] + k) && hashMap.get(nums[i] + k) != i)) {
                hashSet.add(nums[i]);
            }
            hashMap.put(nums[i], i);
        }
        return hashSet.size();
    }

    /**
     * 最快算法：排序完，然后快慢指针
     * 14ms 98.67%
     */
    public int findPairsFindFast(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Arrays.sort(nums);

        int slowIndex = 0;
        int fastIndex = 1;
        int count = 0;

        while (fastIndex < nums.length) {
            if (nums[fastIndex] - nums[slowIndex] < k) {
                fastIndex++;
            } else if (nums[fastIndex] - nums[slowIndex] == k) {
                count++;
                // 快指针快速前进到下一个不相等的
                int temp = nums[fastIndex];
                while (fastIndex < nums.length && nums[fastIndex] == temp) {
                    fastIndex++;
                }
            } else {
                slowIndex++;
            }
            // 防止慢指针追上快指针
            if (fastIndex == slowIndex) {
                fastIndex++;
            }
        }
        return count;
    }
}
