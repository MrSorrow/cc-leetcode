package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 199. 二叉树的右视图
 * @see: <a>https://leetcode-cn.com/problems/binary-tree-right-side-view/</a>
 * @author: guoping wang
 * @date: 2019/3/22 11:05
 * @project: cc-leetcode
 */
public class BinaryTreeRightSideView {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：层序遍历
     * 3ms 51.57%
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> layer = new ArrayList<>();
        if (root != null) layer.add(root);

        while (!layer.isEmpty()) {
            // 添加结果
            res.add(layer.get(layer.size() - 1).val);

            List<TreeNode> nextLayer = new ArrayList<>();
            for (TreeNode node : layer) {
                if (node.left != null) {
                    nextLayer.add(node.left);
                }
                if (node.right != null) {
                    nextLayer.add(node.right);
                }
            }
            layer = nextLayer;
        }
        return res;
    }
}
