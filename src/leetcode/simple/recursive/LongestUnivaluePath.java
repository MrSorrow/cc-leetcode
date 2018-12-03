package leetcode.simple.recursive;

/**
 * @description: 687. 最长同值路径
 * @see: <a>https://leetcode-cn.com/problems/longest-univalue-path/</a>
 * @author: guoping wang
 * @date: 2018/12/3 9:53
 * @project: cc-leetcode
 */
public class LongestUnivaluePath {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 由于求的是节点数目，所以需要减去1
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        return longestUnivaluePathCir(root) - 1;
    }

    /**
     * 个人常规解法：递归算法，当前节点在与不在路径之中
     * 19ms 13.65%
     * @param root
     * @return
     */
    public int longestUnivaluePathCir(TreeNode root) {
        if (root == null) return 0;

        int includeRoot = 1 + singlelongestUnivaluePath(root.left, root.val) + singlelongestUnivaluePath(root.right, root.val);
        int left = 0, right = 0;
        if (root.left != null)
            left = longestUnivaluePathCir(root.left);
        if (root.right != null)
            right = longestUnivaluePathCir(root.right);
        return Math.max(includeRoot, Math.max(left, right));
    }

    /**
     * 返回单边最大长度
     * @param node
     * @param val
     * @return
     */
    public int singlelongestUnivaluePath(TreeNode node, int val) {
        if (node != null && node.val == val)
            return 1 + Math.max(singlelongestUnivaluePath(node.left, val), singlelongestUnivaluePath(node.right, val));
        else
            return 0;
    }



    private int max = 0;

    public int longestUnivaluePathBetterCir(TreeNode root) {
        longestUnivaluePathBetterCir(root, 0);
        return max;
    }

    /**
     * 更好的递归：每一个节点去判断组成的路径长度，记录最大的长度
     * @param node 当前节点
     * @param val 父节点的值
     * @return
     */
    public int longestUnivaluePathBetterCir(TreeNode node, int val) {
        if (node == null) return 0;
        int left = longestUnivaluePathBetterCir(node.left, node.val);
        int right = longestUnivaluePathBetterCir(node.right, node.val);
        if (left + right > max)
            max = left + right;
        return node.val == val ? Math.max(left, right) + 1 : 0;
    }
}
