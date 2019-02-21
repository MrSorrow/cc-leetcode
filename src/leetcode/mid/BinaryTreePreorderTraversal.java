package leetcode.mid;

import leetcode.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 144. 二叉树的前序遍历
 * @see: <a>https://leetcode-cn.com/problems/binary-tree-preorder-traversal/</a>
 * @author: guoping wang
 * @date: 2019/2/21 20:41
 * @project: cc-leetcode
 */
public class BinaryTreePreorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归
     * 1ms 86.31%
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        res.addAll(preorderTraversalRecursion(root.left));
        res.addAll(preorderTraversalRecursion(root.right));
        return res;
    }

    /**
     * 个人常规解法：按照题意迭代思路，利用好栈
     * 2ms 25.36%
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        ListUtils.printLists(new BinaryTreePreorderTraversal().preorderTraversal(root));
    }
}
