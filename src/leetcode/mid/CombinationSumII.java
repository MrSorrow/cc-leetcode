package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 40. 组合总和 II
 * @see: <a>https://leetcode-cn.com/problems/combination-sum-ii/</a>
 * @author: guoping wang
 * @date: 2019/1/5 10:50
 * @project: cc-leetcode
 */
public class CombinationSumII {

    /**
     * 个人常规解法：递归解法，通过每个数组的元素的选择与不选来递归解法
     * 190ms 2.48%
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return new ArrayList<>(combinationSum2(candidates, target, 0));
    }

    /**
     * 个人常规解法：先裁剪整个数组，因为都是正整数，所以筛选出少于target的
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2Crop(int[] candidates, int target) {
        int count = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) count++;
        }
        int[] candidatesCopy = new int[count];
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) candidatesCopy[--count] = candidates[i];
        }
        Arrays.sort(candidatesCopy);
        return new ArrayList<>(combinationSum2(candidatesCopy, target, 0));
    }

    /**
     * 参考解法：深度优先搜索/回溯
     * 26ms 59.21%
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2DFS(int[] candidates, int target) {
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
                dfs(res, list, candidates, target, current + candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public HashSet<List<Integer>> combinationSum2(int[] candidates, int target, int start) {
        HashSet<List<Integer>> res = new HashSet<>();
        if (target < 0 || start > candidates.length - 1) {
            return res;
        }
        if (start == candidates.length - 1) {
            if (candidates[start] == target) {
                List<Integer> element = new ArrayList<>();
                element.add(target);
                res.add(element);
            }
        } else {
            if (candidates[start] == target) {
                List<Integer> element = new ArrayList<>();
                element.add(target);
                res.add(element);
            }
            HashSet<List<Integer>> list1 = combinationSum2(candidates, target - candidates[start], start + 1);
            for (List<Integer> list : list1) {
                list.add(candidates[start]);
            }
            HashSet<List<Integer>> list2 = combinationSum2(candidates, target, start + 1);
            res.addAll(list1);
            res.addAll(list2);
        }
        return res;
    }

    public static void main(String[] args) {
        int target = 8;
        int[] candidates = {1, 1, 3, 4, 5};
        new CombinationSumII().combinationSum2DFS(candidates, target);
    }
}
