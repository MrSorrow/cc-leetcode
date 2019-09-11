package recruitment.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/7/11 2:52 PM
 * @project: cc-leetcode
 */
public class Main1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        // 存放每一层
        List<TreeNode> layer = new LinkedList<>();
        // 先处理第一层
        if (root != null) layer.add(root);

        while (!layer.isEmpty()) {
            List<Integer> layerValues = new ArrayList<>(layer.size());
            // 用于存放下一层
            List<TreeNode> nextLayer = new LinkedList<>();

            for (TreeNode node : layer) {
                layerValues.add(node.val); // 添加当前层的值

                // 获取下一层
                if (node.left != null) nextLayer.add(node.left);
                if (node.right != null) nextLayer.add(node.right);
            }
            res.add(layerValues);

            // 赋值
            layer = nextLayer;
        }
        return res;
    }




}
