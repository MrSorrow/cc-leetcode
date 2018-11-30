package leetcode.simple.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 590. N叉树的后序遍历
 * @see: <a>https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/</a>
 * @author: guoping wang
 * @date: 2018/11/30 10:52
 * @project: cc-leetcode
 */
public class NAryTreePostorderTraversal {

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
     * 个人常规解法：递归后序遍历
     * 5ms 85.64%
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        for (Node child : root.children) {
            res.addAll(postorder(child));
        }
        res.add(root.val);
        return res;
    }
}
