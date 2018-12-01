package leetcode.simple.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 637. 二叉树的层平均值
 * @see: <a>https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/</a>
 * @author: guoping wang
 * @date: 2018/12/1 15:01
 * @project: cc-leetcode
 */
public class AverageOfLevelsInBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：迭代法
     * 8ms 90.21%
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();

        // 当前行
        List<TreeNode> currentRow = new ArrayList<TreeNode>() {{add(root);}};

        while (!currentRow.isEmpty()) {
            // 下一行
            List<TreeNode> nextRow = new ArrayList<>();
            // 平均值
            double average = 0.;
            for (TreeNode node : currentRow) {
                if (node != null) {
                    if (node.left != null) nextRow.add(node.left);
                    if (node.right != null) nextRow.add(node.right);
                    average += node.val;
                }
            }
            res.add(average / currentRow.size());
            currentRow = nextRow;
        }
        return res;
    }
}
