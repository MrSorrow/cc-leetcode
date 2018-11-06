package leetcode.simple.dfs;

/**
 * @description: 110.平衡二叉树
 * @see: <a>https://leetcode-cn.com/problems/balanced-binary-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/6 20:06
 * @project: cc-leetcode
 */
public class BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：求每一个节点的左右深度差
     * 2ms 66.34%
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(depth(root.left) - depth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
