package leetcode.simple.tree;

/**
 * @description: 965. 单值二叉树
 * @see: <a>https://leetcode-cn.com/problems/univalued-binary-tree/</a>
 * @author: guoping wang
 * @date: 2019/3/16 22:24
 * @project: cc-leetcode
 */
public class UnivaluedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归解法
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        boolean flag = true;
        if (root.left != null) {
            flag = root.val == root.left.val && isUnivalTree(root.left);
            if (!flag) return false;
        }
        if (root.right != null) {
            flag = root.val == root.right.val && isUnivalTree(root.right);
            if (!flag) return false;
        }
        return true;
    }
}
