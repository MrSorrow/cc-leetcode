package leetcode.simple.bst;

/**
 * @description: 530. 二叉搜索树的最小绝对差
 * @see: <a>https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/</a>
 * @author: guoping wang
 * @date: 2018/12/5 22:04
 * @project: cc-leetcode
 */
public class MinimumAbsoluteDifferenceInBst {

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
    public int getMinimumDifference(TreeNode root) {
        prev = Integer.MIN_VALUE + root.val + 1;
        travel(root);
        return min;
    }

    private void travel(TreeNode node) {
        if (node == null) return;
        travel(node.left);
        if (node.val - prev < min) {
            min = node.val - prev;
        }
        prev = node.val;
        travel(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(new MinimumAbsoluteDifferenceInBst().getMinimumDifference(root));
    }
}
