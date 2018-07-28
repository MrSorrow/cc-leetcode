package leetcode.simple.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @link <a>https://leetcode-cn.com/problems/two-sum/description/</a>
 * @author Kingdompin@163.com
 * @date 2018/7/28 上午12:50
 */
public class TwoSum {

    /**
     * 暴力解法
     */
    public int[] twoSumViolence(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
                continue;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 暴力解法减轻 31ms 41.0%
     */
    public int[] twoSumLessViolence(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            if (nums[i] <= target) {
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[i] + nums[j] == target){
                        return new int[]{i, j};
                    }
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 哈希表法(两次) 12ms 56.22%
     */
    public int[] twoSumTwiceHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            // key为值，value为索引
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 哈希表法(一次) 11ms 58.47%
     */
    public int[] twoSumOneHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, target - nums[i]};
            }
            // 后放入map是为什么得注意？用例：【3，2，4】 6 / 【2，3】 6
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
