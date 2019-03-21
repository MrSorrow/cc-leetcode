package leetcode.mid;

/**
 * @description: 117. 填充每个节点的下一个右侧节点指针 II
 * @see: <a>https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/</a>
 * @author: guoping wang
 * @date: 2019/3/21 19:44
 * @project: cc-leetcode
 */
public class PopulatingNextRightPointersInEachNodeII {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int _val) {val = _val;}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /**
     * 个人常规解法：层序遍历
     * 7ms 8.95%
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Node first = root;

        while (first != null) {
            Node node = null;
            // 遍历该层链表，构造下一层的链表，node用来下一层横向迭代器，iter是该层的横向迭代器
            for (Node iter = first; iter != null; iter = iter.next) {
                if (iter.left != null) {
                    if (node == null) first = node = iter.left;
                    else node = node.next = iter.left;
                }
                if (iter.right != null) {
                    if (node == null) first = node = iter.right;
                    else node = node.next = iter.right;
                }
            }
            if (node == null) break;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        new PopulatingNextRightPointersInEachNodeII().connect(root);
    }
}
