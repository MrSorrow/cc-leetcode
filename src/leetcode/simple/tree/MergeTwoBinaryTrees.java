package leetcode.simple.tree;

/**
 * @description: 617.合并二叉树
 * @see: <a>https://leetcode-cn.com/problems/merge-two-binary-trees/</a>
 * @author: guoping wang
 * @date: 2018/12/1 11:01
 * @project: cc-leetcode
 */
public class MergeTwoBinaryTrees {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归，合并树主要就是理清各种情况下的状态转换
     * 9ms 95.99%
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode node = null;
        if (t1 != null && t2 != null) {
            node = new TreeNode(t1.val + t2.val);
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);
        } else if (t1 == null && t2 != null) {
            node = new TreeNode(t2.val);
            node.left = t2.left;
            node.right = t2.right;
        } else if (t2 == null && t1 != null) {
            node = new TreeNode(t1.val);
            node.left = t1.left;
            node.right = t1.right;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        new MergeTwoBinaryTrees().mergeTrees(t1, t2);
    }
}
