package leetcode.mid;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 113. 路径总和 II
 * @see: <a>https://leetcode-cn.com/problems/path-sum-ii/</a>
 * @author: guoping wang
 * @date: 2019/3/20 21:59
 * @project: cc-leetcode
 */
public class PathSumII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 个人常规解法：写的很烂的回溯法，回溯三要素：出口、递归、清除状态
     * 3ms 75.79%
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        pathSum(list, root, 0, sum);

        return res;
    }

    private void pathSum(List<Integer> list, TreeNode root, int s, int sum) {
        // 出口条件
        if (root == null) return;
        if (root.right == null && root.left == null) {
            if (s + root.val == sum) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(root.val);
                res.add(temp);
            }
            return;
        }

        list.add(root.val);
        if (root.left != null)
            pathSum(list, root.left, s + root.val, sum);
        if (root.right != null)
            pathSum(list, root.right, s + root.val, sum);

        // 清除状态
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> lists = new PathSumII().pathSum(root, 22);
        ListUtils.printLists(lists);
    }
}
