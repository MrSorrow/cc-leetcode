package leetcode.simple.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 897. 递增顺序查找树
 * @see: <a>https://leetcode-cn.com/problems/increasing-order-search-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/24 21:20
 * @project: cc-leetcode
 */
public class IncreasingOrderSearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：先获取中序遍历的结果，然后构造链
     * 超时 2056/2156
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> midOrder = new ArrayList<>();
        midOrder = getMidOrder(root, midOrder);
        for (int i = 0; i < midOrder.size(); i++) {
            TreeNode node = midOrder.get(i);
            node.left = null;
            if (i == midOrder.size() - 1) {
                node.right = null;
            } else {
                node.right = midOrder.get(i + 1);
            }
        }
        return midOrder.get(0);
    }

    public List<TreeNode> getMidOrder(TreeNode node, List<TreeNode> result) {
        if (node != null) {
            result.addAll(getMidOrder(node.left, result));
            result.add(node);
            result.addAll(getMidOrder(node.right, result));
        }
        return result;
    }

    /**
     * 个人常规解法：直接递归去解
     * 39ms 96.27%
     * @param root
     * @return
     */
    public TreeNode increasingBSTCir(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 获取左边和右边的中序遍历形成的排列树
        TreeNode leftRes = increasingBST(root.left);
        TreeNode rightRes = increasingBST(root.right);

        root.left = null;

        // 获取左边排列树的最后一个节点
        TreeNode leftLast = leftRes;
        while (leftLast != null && leftLast.right != null) {
            leftLast = leftLast.right;
        }
        // 连接上右边排列树，无需判空
        root.right = rightRes;
        // 左边排列树可能为空
        if (leftLast != null) {
            leftLast.right = root;
            return leftRes;
        } else {
            return root;
        }
    }
}
