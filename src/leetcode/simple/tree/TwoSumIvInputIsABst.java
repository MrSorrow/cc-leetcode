package leetcode.simple.tree;

import java.util.HashSet;

/**
 * @description: 653. 两数之和 IV - 输入 BST
 * @see: <a>https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/</a>
 * @author: guoping wang
 * @date: 2018/12/2 16:14
 * @project: cc-leetcode
 */
public class TwoSumIvInputIsABst {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private HashSet<Integer> set = new HashSet<>();

    /**
     * 个人常规解法：HashSet+递归
     * 22ms 87.98%
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }
}
