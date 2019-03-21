package leetcode.mid;

/**
 * @description: 116. 填充每个节点的下一个右侧节点指针
 * @see: <a>https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/</a>
 * @author: guoping wang
 * @date: 2019/3/21 19:14
 * @project: cc-leetcode
 */
public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 个人常规解法：层序遍历可以解决
     * 1ms 54.67%
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) return root;

        Node first = root;
        while (first.left != null) {

            // 一层进行遍历进行下一层的串接
            for (Node node = null, iter = first; iter != null; iter = iter.next) {
                if (node != null) node.next = iter.left;
                iter.left.next = iter.right;
                node = iter.right;
            }

            // 接着下一层
            first = first.left;
        }

        return root;
    }
}
