package leetcode.simple.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 429. N叉树的层序遍历
 * @see: <a>https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/</a>
 * @author: guoping wang
 * @date: 2018/11/26 21:26
 * @project: cc-leetcode
 */
public class NAryTreeLevelOrderTraversal {

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
     * 个人常规解法：按顺序遍历即可
     * 7ms 84.28
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        List<List<Node>> nodeLists = new LinkedList<>();
        if (root != null) {
            nodeLists.add(new ArrayList<Node>() {{add(root);}});
            result.add(new ArrayList<Integer>() {{add(root.val);}});

            for (;;) {
                List<Node> lastRowNodes = nodeLists.get(nodeLists.size() - 1);
                List<Node> currentRowNodes = new ArrayList<>();
                List<Integer> currentValues = new ArrayList<>();

                for (int i = 0; i < lastRowNodes.size(); i++) {
                    for (Node node : lastRowNodes.get(i).children) {
                        if (node != null) {
                            currentRowNodes.add(node);
                            currentValues.add(node.val);
                        }
                    }
                }
                if (currentRowNodes.isEmpty()) {
                    break;
                } else {
                    result.add(currentValues);
                    nodeLists.add(currentRowNodes);
                }
            }
        }
        return result;
    }
}
