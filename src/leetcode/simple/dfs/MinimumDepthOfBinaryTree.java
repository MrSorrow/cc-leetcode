package leetcode.simple.dfs;

/**
 * @description: 111. 二叉树的最小深度
 * @see: <a>https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/6 20:32
 * @project: cc-leetcode
 */
public class MinimumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归，一个节点分四种情况
     * 0ms 100%
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        else if (root.left == null && root.right != null) return 1 + minDepth(root.right);
        else if (root.left != null && root.right == null) return 1 + minDepth(root.left);
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
