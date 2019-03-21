package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 114. 二叉树展开为链表
 * @see: <a>https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/</a>
 * @author: guoping wang
 * @date: 2019/3/21 9:20
 * @project: cc-leetcode
 */
public class FlattenBinaryTreeToLinkedList {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：先序遍历
     * 19ms 17.73%
     * @param root
     */
    public void flattenIterator(TreeNode root) {
        List<TreeNode> list = flattenPreOrderIterator(root);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).left = null;
            if (i < list.size() - 1)
                list.get(i).right = list.get(i + 1);
            else
                list.get(i).right = null;
        }
    }

    private List<TreeNode> flattenPreOrderIterator(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root != null) {
            res.add(root);
            res.addAll(flattenPreOrderIterator(root.left));
            res.addAll(flattenPreOrderIterator(root.right));
        }
        return res;
    }

    /**
     * 个人常规解法：使用递归的方式，耗时在每次都需要寻找左子树中先序遍历的最后一个节点
     * 20ms 12.37%
     * @param root
     */
    public void flatten(TreeNode root) {
        flattenRoot(root);
    }

    /**
     * 个人常规解法：先序遍历的构造链表
     * @param root
     */
    public TreeNode flattenRoot(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;

        TreeNode lastRightInLeftSubTree = findLastRightInLeftSubTree(root);
        if (lastRightInLeftSubTree != null) {
            lastRightInLeftSubTree.right = flattenRoot(root.right);
            root.right = flattenRoot(root.left);
            root.left = null;
        } else {
            root.right = flattenRoot(root.right);
        }

        return root;
    }

    /**
     * 寻找左子树中先序遍历的最后一个节点
     * @param root
     * @return
     */
    TreeNode findLastRightInLeftSubTree(TreeNode root) {
        root = root.left;
        while (root != null && root.right != null) {
            root = root.right;
        }
        return root;
    }

    /**
     * 最优写法：思路是一样的，递归
     * @param root
     */
    public void flattenBest(TreeNode root) {
        if (root == null)
            return;
        flattenBest(root.left);
        flattenBest(root.right);
        if (root.left != null) {
            TreeNode left = root.left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(6);
        new FlattenBinaryTreeToLinkedList().flattenRoot(root);
    }
}
