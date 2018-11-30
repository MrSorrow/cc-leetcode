package leetcode.simple.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 589.N叉树的前序遍历
 * @see: <a>https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/</a>
 * @author: guoping wang
 * @date: 2018/11/30 10:37
 * @project: cc-leetcode
 */
public class NAryTreePreorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 个人常规解法：递归
     * 5ms 85.10%
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        for (Node child : root.children) {
            res.addAll(preorder(child));
        }
        return res;
    }
}
