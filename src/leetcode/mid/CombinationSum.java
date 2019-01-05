package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 39. 组合总和
 * @see: <a>https://leetcode-cn.com/problems/combination-sum/</a>
 * @author: guoping wang
 * @date: 2019/1/5 15:59
 * @project: cc-leetcode
 */
public class CombinationSum {

    /**
     * 深度优先搜索，和题40是一样的，只是遍历的时候是否包含当前节点
     * 16ms 78.31%
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), candidates, target, 0, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> list, int[] candidates, int target, int current, int start) {
        if (current > target) {
            return;
        } else if (current == target) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                // 去重
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                dfs(res, list, candidates, target, current + candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
}
