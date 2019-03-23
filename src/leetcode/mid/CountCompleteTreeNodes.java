package leetcode.mid;

/**
 * @description: 222. 完全二叉树的节点个数
 * @see: <a>https://leetcode-cn.com/problems/count-complete-tree-nodes/</a>
 * @author: guoping wang
 * @date: 2019/3/23 20:44
 * @project: cc-leetcode
 */
public class CountCompleteTreeNodes {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
    /**
     * 个人常规解法：递归遍历
     * 2ms 97.81%
     * @param root
     * @return
     */
    public int countNodesIter(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 参考解法：利用完全二叉树的性质
     * 2ms 97.81%
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int l = getDepth(root.left);
        int r = getDepth(root.right);
        if (l == r) {
            // 左子树肯定是完全二叉树的
            return (1 << l) + countNodes(root.right);
        } else {
            // 右子树肯定是完全二叉树
            return (1 << r) + countNodes(root.left);
        }
    }

    /**
     * 获取树的深度
     * @param root
     * @return
     */
    public int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}
