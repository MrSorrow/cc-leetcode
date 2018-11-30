package leetcode.simple.tree;

/**
 * @description: 563.二叉树的坡度
 * @see: <a>https://leetcode-cn.com/problems/binary-tree-tilt/</a>
 * @author: guoping wang
 * @date: 2018/11/30 10:15
 * @project: cc-leetcode
 */
public class BinaryTreeTilt {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int sum = 0;

    /**
     * 个人常规解法：为了加速，其实可以后序遍历，同时每次应该返回当前节点的总和，防止重复计算
     * 5ms 98.26%
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        findandRecordTilt(root);
        return sum;
    }

    public int findandRecordTilt(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = findandRecordTilt(node.left);
        int right = findandRecordTilt(node.right);

        // 当前节点的坡度
        sum += Math.abs(left - right);
        return left + right + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new BinaryTreeTilt().findTilt(root));
    }
}
