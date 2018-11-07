package leetcode.simple.dfs;

import java.util.List;

/**
 * @description: 559.N叉树的最大深度
 * @see: <a>https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/7 21:29
 * @project: cc-leetcode
 */
public class MaximumDepthOfNAryTree {

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
     * 个人常规解法：递归，和求二叉树的深度是一致的
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 1;
        for (Node child : root.children) {
            int temp = 1 + maxDepth(child);
            max = max >= temp ? max : temp;
        }
        return max;
    }
}
