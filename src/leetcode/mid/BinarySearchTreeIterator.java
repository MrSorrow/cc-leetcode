package leetcode.mid;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: 173. 二叉搜索树迭代器
 * @see: <a>https://leetcode-cn.com/problems/binary-search-tree-iterator/</a>
 * @author: guoping wang
 * @date: 2019/3/22 9:45
 * @project: cc-leetcode
 */
public class BinarySearchTreeIterator {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：中序遍历
     */
    class BSTIteratorInOrder {

        private LinkedList<Integer> list;
        private Iterator iterator;

        public BSTIteratorInOrder(TreeNode root) {
            list = new LinkedList<>();
            inOrder(root);
            iterator = list.listIterator();
        }

        private void inOrder(TreeNode node) {
            if (node == null) return;
            inOrder(node.left);
            list.add(node.val);
            inOrder(node.right);
        }

        /** @return the next smallest number */
        public int next() {
            return (int) iterator.next();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

    /**
     * 参考解法：将左节点入栈，空间复杂度O(h)
     */
    class BSTIterator {

        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            for (; root != null; root = root.left) {
                stack.push(root);
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            int res = node.val;
            if ((node = node.right) != null) {
                for (; node != null; node = node.left) {
                    stack.push(node);
                }
            }
            return res;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
