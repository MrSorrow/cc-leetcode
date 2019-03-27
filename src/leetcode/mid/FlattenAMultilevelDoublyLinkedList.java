package leetcode.mid;

/**
 * @description: 430. 扁平化多级双向链表
 * @see: <a>https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/</a>
 * @author: guoping wang
 * @date: 2019/3/27 22:07
 * @project: cc-leetcode
 */
public class FlattenAMultilevelDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    /**
     * 个人常规解法：递归解法
     * 3ms 64.24%
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        Node[] res = flattenNode(head);
        return res == null ? null : res[0];
    }

    /**
     * 将head之后的节点进行扁平化，扁平当前节点，返回头尾
     * @param head
     * @return Node[2] Node[0]表示返回当前节点的头，Node[1]的尾
     */
    private Node[] flattenNode(Node head) {
        Node[] res = new Node[2];
        if (head == null) return null;

        Node[] childs = flattenNode(head.child);
        Node[] nexts = flattenNode(head.next);
        res[0] = head;  // 返回头是当前节点
        if (childs == null && nexts == null) {
            res[1] = head;
        } else if (childs != null && nexts == null) {
            head.next = childs[0];
            childs[0].prev = head;
            res[1] = childs[1];
        } else if (nexts != null && childs == null) {
            head.next = nexts[0];
            nexts[0].prev = head;
            res[1] = nexts[1];
        } else {
            head.next = childs[0];
            childs[0].prev = head;
            childs[1].next = nexts[0];
            nexts[0].prev = childs[1];
            res[1] = nexts[1];
        }
        head.child = null;
        return res;
    }
}
