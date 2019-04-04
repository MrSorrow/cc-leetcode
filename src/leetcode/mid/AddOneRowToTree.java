package leetcode.mid;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 623. 在二叉树中增加一行
 * @see: <a>https://leetcode-cn.com/problems/add-one-row-to-tree/</a>
 * @author: guoping wang
 * @date: 2019/4/4 22:01
 * @project: cc-leetcode
 */
public class AddOneRowToTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：先确定哪一层，然后构造节点
     * 6ms 99.24%
     * @param root
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        // 特殊情况
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }

        List<TreeNode> layer = new LinkedList<>();
        if (root != null) layer.add(root);

        while (--d > 1) {
            List<TreeNode> nextLayer = new LinkedList<>();
            for (TreeNode node : layer) {
                if (node.left != null) nextLayer.add(node.left);
                if (node.right != null) nextLayer.add(node.right);
            }
            layer = nextLayer;
        }

        // layer为d-1层的节点
        for (TreeNode node : layer) {
            if (node.left != null) {
                TreeNode left = node.left;
                TreeNode n = new TreeNode(v);
                node.left = n;
                n.left = left;
            } else {
                node.left = new TreeNode(v);
            }
            if (node.right != null) {
                TreeNode right = node.right;
                TreeNode n = new TreeNode(v);
                node.right = n;
                n.right = right;
            } else {
                node.right = new TreeNode(v);
            }
        }

        return root;
    }
}
