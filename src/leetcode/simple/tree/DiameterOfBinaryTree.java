package leetcode.simple.tree;

/**
 * @description: 543.二叉树的直径
 * @see: <a>https://leetcode-cn.com/problems/diameter-of-binary-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/29 22:32
 * @project: cc-leetcode
 */
public class DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归
     * 17ms 40.24%
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int mid = getDepthOfTree(root.left) + getDepthOfTree(root.right);
        return Math.max(left, right) > mid ? Math.max(left, right) : mid;
    }

    /**
     * 获取深度
     * @param node
     * @return
     */
    public int getDepthOfTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepthOfTree(node.left), getDepthOfTree(node.right)) + 1;
    }

    /**
     * 更好的写法：不需要每次求那么多深度
     * 5ms 100%
     * @param root
     * @return
     */
    public int diameterOfBinaryTreeBetter(TreeNode root) {
        if (root == null)
            return 0;
        depth(root);
        return temp;
    }

    int temp = 0;

    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);

        // 保存下当前能够达到的最大路径长度
        if (left + right > temp)
            temp = left + right;
        // 返回仅仅返回的是单个边的长度+当前节点，因为走到上层节点肯定不可能用左右两边了，只能选取长的那个边
        return Math.max(left, right) + 1;
    }
}
