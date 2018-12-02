package leetcode.simple.tree;

/**
 * @description: 671. 二叉树中第二小的节点
 * @see: <a>https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/</a>
 * @author: guoping wang
 * @date: 2018/12/2 18:38
 * @project: cc-leetcode
 */
public class SecondMinimumNodeInABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归，考虑到所有的组合情况
     * 2ms 100%
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) return -1;
        if (root.val == root.left.val && root.val == root.right.val) {
            int left = findSecondMinimumValue(root.left);
            int right = findSecondMinimumValue(root.right);
            if (left == -1) return right;
            else if (right == -1) return left;
            else return Math.min(left, right);
        } else {
            if (root.left.val == root.val) {
                int left = findSecondMinimumValue(root.left);
                if (left != -1) return Math.min(root.right.val, left);
                else return root.right.val;
            }
            else if (root.right.val == root.val) {
                int right = findSecondMinimumValue(root.right);
                if (right != -1) return Math.min(root.left.val, right);
                else return root.left.val;
            }
            else return Math.min(root.left.val, root.right.val);
        }
    }
}
