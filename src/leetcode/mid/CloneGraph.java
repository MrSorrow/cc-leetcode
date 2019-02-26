package leetcode.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @description: 133. 克隆图
 * @see: <a>https://leetcode-cn.com/problems/clone-graph/</a>
 * @author: guoping wang
 * @date: 2019/2/26 9:36
 * @project: cc-leetcode
 */
public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * 个人常规解法：利用HashMap保存节点并记录节点是否访问完成
     * 11ms 19.91%
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Integer, Node> map = new HashMap<>();
        HashMap<Integer, Boolean> handled = new HashMap<>();

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            // 记录该节点已经处理过
            handled.put(n.val, true);
            // 拷贝节点本身
            Node nCopy = null;
            if (map.containsKey(n.val)) {
                nCopy = map.get(n.val);
            } else {
                nCopy = new Node(n.val, null);
                map.put(n.val, nCopy);
            }
            // 拷贝邻居
            ArrayList<Node> neighbors = new ArrayList<>(n.neighbors.size());
            for (Node neighbor : n.neighbors) {
                Node neighborCopy = null;
                if (map.containsKey(neighbor.val)) {
                    neighborCopy = map.get(neighbor.val);
                } else {
                    neighborCopy = new Node(neighbor.val, null);
                    map.put(neighbor.val, neighborCopy);
                }
                neighbors.add(neighborCopy);
                if (!handled.containsKey(neighbor.val))
                    stack.push(neighbor);
            }
            nCopy.neighbors = neighbors;
        }
        return map.get(node.val);
    }

}
