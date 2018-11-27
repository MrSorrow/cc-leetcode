package leetcode.simple.tree;

/**
 * @description: 235.二叉搜索树的最近公共祖先
 * @see: <a>https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/27 21:16
 * @project: cc-leetcode
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：二叉搜索树，本身是有一定顺序的，递归去寻找一个节点的值在两者之间的即可
     * 11ms 65.34%
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else if (p.val == root.val || q.val == root.val) {
                return p.val == root.val ? p : q;
            } else {
                return root;
            }
        } else {
            return null;
        }
    }


    /**
     * 同样的算法，更好的表达
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorBetter(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
