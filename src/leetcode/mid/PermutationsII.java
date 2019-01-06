package leetcode.mid;

import leetcode.utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 47. 全排列 II
 * @see: <a>https://leetcode-cn.com/problems/permutations-ii/</a>
 * @author: guoping wang
 * @date: 2019/1/6 11:12
 * @project: cc-leetcode
 */
public class PermutationsII {

    /**
     * 个人常规解法：46题排列的去重结果
     * 26ms 38.12%
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        return new ArrayList<>(permute(nums, 0));
    }

    private HashSet<List<Integer>> permute(int[] nums, int start) {
        HashSet<List<Integer>> res = new HashSet<>();
        if (start == nums.length - 1) {
            List<Integer> ele = new ArrayList<Integer>(){{add(nums[start]);}};
            res.add(ele);
        } else if (start > nums.length - 1) {
            // pass
        } else {
            HashSet<List<Integer>> set = permute(nums, start + 1);
            for (List<Integer> list: set) {
                for (int j = 0; j <= list.size(); j++) {
                    List<Integer> ele = new ArrayList<>(list);
                    ele.add(j, nums[start]);
                    res.add(ele);
                }
            }
        }
        return res;
    }

    /**
     * 参考解法：DFS
     * 4ms 98.47%
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUniqueDFS(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] flags = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), flags, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, boolean[] flags, int[] nums, int start) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!flags[i]) {
                    //  去重判断，需要之前相同的用过才能使用现在的，否则之前没用的话，用现在的相当于用之前的
                    if (i > 0 && nums[i] == nums[i - 1] && !flags[i - 1]) {
                        continue;
                    }
                    list.add(nums[i]);
                    flags[i] = true;
                    dfs(res, list, flags, nums, start + 1);
                    list.remove(list.size() - 1);
                    flags[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        ListUtils.printLists(new PermutationsII().permuteUniqueDFS(nums));
    }
}
