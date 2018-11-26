package leetcode.simple.tree;

/**
 * @description: 226. 翻转二叉树
 * @see: <a>https://leetcode-cn.com/problems/invert-binary-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/26 21:48
 * @project: cc-leetcode
 */
public class InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：交换每一个节点的左右孩子，递归就好了
     * 0ms 100%
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);

        return root;
    }
}
