package leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 145. 二叉树的后序遍历
 * @see: <a>https://leetcode-cn.com/problems/binary-tree-postorder-traversal/</a>
 * @author: guoping wang
 * @date: 2019/2/21 21:25
 * @project: cc-leetcode
 */
public class BinaryTreePostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归
     * 2ms 33.82%
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.addAll(postorderTraversalRecursion(root.left));
        res.addAll(postorderTraversalRecursion(root.right));
        res.add(root.val);
        return res;
    }

    /**
     * 个人常规解法：利用栈的迭代方法
     * 2ms 33.82%
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }
}
