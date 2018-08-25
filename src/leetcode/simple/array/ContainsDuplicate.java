package leetcode.simple.array;

import java.util.*;

/**
 * @description: 217. 存在重复元素
 * @link: https://leetcode-cn.com/problems/contains-duplicate/description/
 * @author: guoping wang
 * @date: 2018/8/25 11:01
 * @project: cc-leetcode
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new ContainsDuplicate().containsDuplicateHashMap(nums));
    }

    /**
     * 个人常规解法：hashmap统计是否存在
     * 15ms 71.75%
     * @param nums
     * @return
     */
    public boolean containsDuplicateHashMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                return true;
            } else {
                countMap.put(nums[i], i);
            }
        }
        return false;
    }

    /**
     * 个人算法优化：HashSet
     * 12ms 78.55%
     * @param nums
     * @return
     */
    public boolean containsDuplicateHashSet(int[] nums) {
        Set<Integer> countSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            countSet.add(nums[i]);
        }
        return countSet.size() != nums.length;
    }

    /**
     * 最快算法：排序后查看相邻是否有重复
     * 5ms 97.36% 有点醉，最好的算法竟然先排序
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
