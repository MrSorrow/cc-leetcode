package leetcode.mid;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 236. 二叉树的最近公共祖先
 * @see: <a>https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/</a>
 * @author: guoping wang
 * @date: 2019/3/24 22:01
 * @project: cc-leetcode
 */
public class LowestCommonAncestorOfABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：不断向下判断是否包含
     * 1059ms 1.85%
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (contains(root.left, p) && contains(root.left, q)) {
                root = root.left;
                continue;
            } else if (contains(root.right, p) && contains(root.right, q)) {
                root = root.right;
                continue;
            } else {
                break;
            }
        }
        return root;
    }

    private boolean contains(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        else return contains(root.left, p) || contains(root.right, p);
    }

    /**
     * 个人常规解法：得到p q在二叉树中位置，然后计算公共父节点
     * 29/31 此中解法树的深度不能超过31，因为int会溢出
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorPos(TreeNode root, TreeNode p, TreeNode q) {
        int P = 0, Q = 0;
        HashMap<Integer, TreeNode> allNodes = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> num = new LinkedList<>();
        if (root != null) {queue.offer(root); num.offer(1);}
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer pos = num.poll();
            // 保存所有节点，准备用于最后返回公共父节点
            allNodes.put(pos, node);
            // 记录p q位置
            if (p == node) P = pos;
            if (q == node) Q = pos;
            // 找到p q位置可以退出了
            if (P > 0 && Q > 0) break;
            // 入队新的子节点，如果为空左右孩子赋值为null
            if (node.left != null) {queue.offer(node.left); num.offer(pos * 2);}
            if (node.right != null) {queue.offer(node.right); num.offer(pos * 2 + 1);}
        }
        // 计算公共父节点位置
        while (P != Q) {
            if (P > Q) P /= 2;
            if (P < Q) Q /= 2;
        }
        return allNodes.get(P);
    }

    /**
     * 递归解法，算法劣势在于多次查询需要多次递归遍历
     * 15ms 71.85%
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorRecu(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestorRecu(root.left, p, q);
        TreeNode right = lowestCommonAncestorRecu(root.right, p, q);
        if (left != null && right != null) {
            // 左右子树都有返回节点
            return root;
        } else if (left != null && right == null) {
            // 左子树返回
            return left;
        } else if (right != null && left == null) {
            // 右子树返回
            return right;
        } else {
            // 两边都没有则返回null
            return null;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        TreeNode p = root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        TreeNode q = root.left.left.left = new TreeNode(4);
        new LowestCommonAncestorOfABinaryTree().lowestCommonAncestorPos(root, p, q);
    }

}
