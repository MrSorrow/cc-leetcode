package leetcode.mid;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 103. 二叉树的锯齿形层次遍历
 * @see: <a>https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/</a>
 * @author: guoping wang
 * @date: 2019/3/18 22:27
 * @project: cc-leetcode
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：和102类似 {@link BinaryTreeLevelOrderTraversal}
     * 2ms 69.65%
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        List<TreeNode> layer = new LinkedList<>();
        if (root != null) layer.add(root);

        int reverse = -1;

        while (!layer.isEmpty()) {
            LinkedList<TreeNode> nextLayer = new LinkedList<>();
            LinkedList<Integer> values = new LinkedList<>();
            for (TreeNode node : layer) {
                values.add(node.val);
                // 理清这一段逻辑，一直都用前插法，只不过插孩子的次序不一样
                if (reverse > 0) {
                    if (node.right != null) nextLayer.add(0, node.right);
                    if (node.left != null) nextLayer.add(0, node.left);
                } else {
                    if (node.left != null) nextLayer.add(0, node.left);
                    if (node.right != null) nextLayer.add(0, node.right);
                }
            }
            res.add(values);
            reverse *= -1;
            layer = nextLayer;
        }
        return res;
    }
}
