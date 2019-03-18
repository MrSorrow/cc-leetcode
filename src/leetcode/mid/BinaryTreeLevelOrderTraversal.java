package leetcode.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 102. 二叉树的层次遍历
 * @see: <a>https://leetcode-cn.com/problems/binary-tree-level-order-traversal/</a>
 * @author: guoping wang
 * @date: 2019/3/18 22:11
 * @project: cc-leetcode
 */
public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：层序遍历，每次用一个新的集合存储
     * 2ms 68.09%
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> layer = new LinkedList<>();
        if (root != null) layer.add(root);

        while (!layer.isEmpty()) {
            List<Integer> layerValues = new ArrayList<>(layer.size());
            List<TreeNode> nextLayer = new LinkedList<>();

            for (TreeNode node : layer) {
                layerValues.add(node.val); // 添加当前层的值

                // 获取下一层
                if (node.left != null) nextLayer.add(node.left);
                if (node.right != null) nextLayer.add(node.right);
            }
            res.add(layerValues);
            layer = nextLayer;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        new BinaryTreeLevelOrderTraversal().levelOrder(root);
    }
}
