package leetcode.simple.tree;

/**
 * @description: 404.左叶子之和
 * @see: <a>https://leetcode-cn.com/problems/sum-of-left-leaves/</a>
 * @author: guoping wang
 * @date: 2018/11/27 21:28
 * @project: cc-leetcode
 */
public class SumOfLeftLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归的算法，拥有左叶子节点其实就一种情况，其他都可以去掉根节点进行转化
     * 8ms 56.69%
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null) {
            // 存在左子树
            if (root.left != null && root.left.left == null && root.left.right == null) {
                return root.left.val + sumOfLeftLeaves(root.right);
            } else {
                return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
            }
        } else {
            return 0;
        }
    }
}
