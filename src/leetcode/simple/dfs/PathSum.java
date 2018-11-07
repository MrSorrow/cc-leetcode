package leetcode.simple.dfs;

/**
 * @description: 112. 路径总和
 * @see: <a>https://leetcode-cn.com/problems/path-sum/</a>
 * @author: guoping wang
 * @date: 2018/11/7 20:21
 * @project: cc-leetcode
 */
public class PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归，不断的更新sum值和树的节点
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        else if (root.left == null && root.right == null) return root.val == sum;
        else if (root.left == null && root.right != null) return hasPathSum(root.right, sum - root.val);
        else if (root.left != null && root.right == null) return hasPathSum(root.left, sum - root.val);
        else return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
