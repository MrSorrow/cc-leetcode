package leetcode.simple.bst;

/**
 * @description: 783. 二叉搜索树结点最小距离
 * @see: <a>https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/</a>
 * @author: guoping wang
 * @date: 2018/12/5 22:35
 * @project: cc-leetcode
 */
public class MinimumDistanceBetweenBstNodes {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private int min = Integer.MAX_VALUE;
    private int prev = Integer.MIN_VALUE;

    /**
     * 个人常规解法：中序遍历一遍，记录最小值
     * 9ms 97.33%
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        travel(root);
        return min;
    }

    private void travel(TreeNode node) {
        if (node == null) return;
        travel(node.left);
        if (prev != Integer.MIN_VALUE) {
            min = Math.min(min, node.val - prev);
        }
        prev = node.val;
        travel(node.right);
    }
}
