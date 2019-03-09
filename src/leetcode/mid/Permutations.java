package leetcode.mid;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 46. 全排列
 * @see: <a>https://leetcode-cn.com/problems/permutations/</a>
 * @author: guoping wang
 * @date: 2019/1/6 10:45
 * @project: cc-leetcode
 */
public class Permutations {

    /**
     * 个人常规解法：递归解法
     * 6ms 47.42%
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    private List<List<Integer>> permute(int[] nums, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length - 1) {
            List<Integer> ele = new ArrayList<Integer>(){{add(nums[start]);}};
            res.add(ele);
        } else if (start > nums.length - 1) {
            // pass
        } else {
            List<List<Integer>> list = permute(nums, start + 1);
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j <= list.get(i).size(); j++) {
                    List<Integer> ele = new ArrayList<>(list.get(i));
                    ele.add(j, nums[start]);
                    res.add(ele);
                }
            }
        }
        return res;
    }

    /**
     * 参考解法：深度优先搜索解法
     * 3ms 96.02%
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteDFS(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] flags = new boolean[nums.length];
        dfs(res, new ArrayList<Integer>(), flags, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, boolean[] flags, int[] nums, int start) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!flags[i]) {
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
        int[] nums = {1, 2, 3};
        ListUtils.printLists(new Permutations().permuteDFS(nums));
    }
}
