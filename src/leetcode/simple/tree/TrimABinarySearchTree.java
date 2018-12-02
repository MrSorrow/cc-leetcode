package leetcode.simple.tree;

/**
 * @description: 669. 修剪二叉搜索树
 * @see: <a>https://leetcode-cn.com/problems/trim-a-binary-search-tree/</a>
 * @author: guoping wang
 * @date: 2018/12/2 17:10
 * @project: cc-leetcode
 */
public class TrimABinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 个人常规解法：递归，左子树优先顶替父节点
     * 4ms 99.05%
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val <= R && root.val >= L) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        } else {
            TreeNode left = trimBST(root.left, L, R);
            if (left != null) return left;
            else return trimBST(root.right, L, R);
        }
    }
}
