package leetcode.mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 94. 二叉树的中序遍历
 * @see: <a>https://leetcode-cn.com/problems/binary-tree-inorder-traversal/</a>
 * @author: guoping wang
 * @date: 2019/3/12 16:27
 * @project: cc-leetcode
 */
public class BinaryTreeInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归写法
     * 1ms 85.94%
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalRecu(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        res.addAll(inorderTraversalRecu(root.left));
        res.add(root.val);
        res.addAll(inorderTraversalRecu(root.right));
        return res;
    }

    /**
     * 参考解法：非递归写法
     * 1. 将当前非空节点入栈
     * 2. 如果左子节点不为空，则继续将左子节点入栈
     * 3. 如果左子节点为空，则抛出栈顶节点并记录 val 值，然后将其右子节点入栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode father = stack.pop();
                res.add(father.val);
                node = father.right;
            }
        }

        return res;
    }

    public List<Integer> inorderTraversalAnother(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return res;

        stack.push(root);

        while (true) {
            if (root.left == null) {
                if (stack.isEmpty()) {
                    return res;
                }
                TreeNode node = stack.pop();
                res.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                    root = node.right;
                }
            } else {
                stack.push(root.left);
                root = root.left;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        new BinaryTreeInorderTraversal().inorderTraversalAnother(root);
    }
}
