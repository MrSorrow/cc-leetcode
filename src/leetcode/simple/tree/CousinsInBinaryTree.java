package leetcode.simple.tree;

import java.util.LinkedList;

/**
 * @description: 993. 二叉树的堂兄弟节点
 * @see: <a>https://leetcode-cn.com/problems/cousins-in-binary-tree/</a>
 * @author: guoping wang
 * @date: 2019/3/16 22:40
 * @project: cc-leetcode
 */
public class CousinsInBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：二叉树层序遍历
     * 11ms 100%
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        return isCousins(queue, x, y);
    }

    public boolean isCousins(LinkedList<TreeNode> queue, int x, int y) {
        if (queue.isEmpty()) return false;

        // 遍历是否包含x，y
        boolean flagX = false, flagY = false;
        for (TreeNode node : queue) {
            if (node.val == x) flagX = true;
            if (node.val == y) flagY = true;
            if (flagX && flagY) return true;
        }

        // 如果该层没有，则进行下一层
        LinkedList<TreeNode> newQueue = new LinkedList<>();
        for (TreeNode node : queue) {
            if (node.left != null && node.right != null &&
                    ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x))) {
                return false;
            }
            if (node.left != null) newQueue.add(node.left);
            if (node.right != null) newQueue.add(node.right);
        }
        return isCousins(newQueue, x, y);
    }
}
