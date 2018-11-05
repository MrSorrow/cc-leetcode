package leetcode.simple.dfs;

/**
 * @description: 104. 二叉树的最大深度
 * @see: <a>https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/5 20:09
 * @project: cc-leetcode
 */
public class MaximumDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：更好的递归
     * 0ms 100%
     * @param root
     * @return
     */
    public int maxDepthCir(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthCir(root.left), maxDepthCir(root.right));
    }

    /**
     * 个人常规解法：写的不是很利索的递归解法
     * 0ms 100%
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int depth = 0, currentDepth = 0;
        return maxDepth(root, currentDepth, depth);
    }

    private int maxDepth(TreeNode node, int currentDepth, int depth) {
        if (currentDepth > depth) {
            depth = currentDepth;
        }
        if (node == null) {
            return depth;
        }
        currentDepth++;
        int leftDepth = maxDepth(node.left, currentDepth, depth);
        int rightDepth = maxDepth(node.right, currentDepth, depth);
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root));
    }
}
