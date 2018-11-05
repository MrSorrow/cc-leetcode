package leetcode.simple.dfs;

/**
 * @description: 101. 对称二叉树
 * @see: <a>https://leetcode-cn.com/problems/symmetric-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/5 19:58
 * @project: cc-leetcode
 */
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归解法，根节点左子树和右子树进行递归遍历，查看是否对称
     * 10ms 98.24%
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            if (left == right) return true;
            else return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
