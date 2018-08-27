package leetcode.simple.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @description: 219. 存在重复元素 II
 * @link: https://leetcode-cn.com/problems/contains-duplicate-ii/description/
 * @author: guoping wang
 * @date: 2018/8/25 13:09
 * @project: cc-leetcode
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
        int k = 2;
        int[] nums = {99, 99};
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicateHashmap(nums, k));
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicateBrtterWindow(nums, k));
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicateWindow(nums, k));
    }

    /**
     * 个人常规解法：滑动窗口法
     * 超时 :(
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicateWindow(int[] nums, int k) {
        // 如果不够一个窗口，直接判重即可
        if (nums.length <= k) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i+1]) {
                    return true;
                }
            }
            return false;
        }
        // 窗口滑动
        for (int i = 0; i < nums.length - k; i++) {
            // 窗口内判断是否有重复
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j <= k; j++) {
                hashSet.add(nums[i+j]);
            }
            if (hashSet.size() <= k) {
                return true;
            }
        }
        return false;
    }

    /**
     * 个人常规解法：更正确的滑动窗口法
     * 1163 ms
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicateBrtterWindow(int[] nums, int k) {
        // 窗口滑动
        for (int i = 0; i < nums.length - 1; i++) {
            // 窗口内判断是否有重复
            for (int j = 1; j <= k && i + j < nums.length; j++) {
                if (nums[i] == nums[i + j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 个人解法：hashmap记录索引
     * 13ms 95.43%
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicateHashmap(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]) && (i - hashMap.get(nums[i]) <= k)) {
                return true;
            }
            hashMap.put(nums[i], i);
        }
        return false;
    }
}
