package leetcode.mid;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 515. 在每个树行中找最大值
 * @see: <a>https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/</a>
 * @author: guoping wang
 * @date: 2019/4/4 21:46
 * @project: cc-leetcode
 */
public class FindLargestValueInEachTreeRow {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：7ms 89.74%
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        List<TreeNode> layer = new LinkedList<>();
        if (root != null) layer.add(root);

        while (!layer.isEmpty()) {
            List<TreeNode> nextLayer = new LinkedList<>();
            int max = Integer.MIN_VALUE;
            for (TreeNode node : layer) {
                if (node.left != null) nextLayer.add(node.left);
                if (node.right != null) nextLayer.add(node.right);
                if (node.val > max) max = node.val;
            }
            res.add(max);
            layer = nextLayer;
        }

        return res;
    }
}
