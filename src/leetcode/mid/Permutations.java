package leetcode.mid;

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
}
