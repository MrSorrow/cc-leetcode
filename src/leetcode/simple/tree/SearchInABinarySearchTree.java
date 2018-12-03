package leetcode.simple.tree;

/**
 * @description: 700. 二叉搜索树中的搜索
 * @see: <a>https://leetcode-cn.com/problems/search-in-a-binary-search-tree/</a>
 * @author: guoping wang
 * @date: 2018/12/3 9:47
 * @project: cc-leetcode
 */
public class SearchInABinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归
     * 2ms 100%
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        else if (val > root.val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
}
