package leetcode.mid;

import java.util.HashMap;

/**
 * @description: 138. 复制带随机指针的链表
 * @see: <a>https://leetcode-cn.com/problems/copy-list-with-random-pointer/</a>
 * @author: guoping wang
 * @date: 2019/2/24 14:12
 * @project: cc-leetcode
 */
public class CopyListWithRandomPointer {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    /**
     * 个人常规解法：HashMap缓存已有的节点
     * 2ms 82.74%
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Integer, Node> map = new HashMap<>();
        Node headCopy = new Node(head.val, null, null);
        map.put(head.val, headCopy);

        Node iter = headCopy;
        while (head != null && (head.next != null || head.random != null)) {
            if (head.next != null) {
                Node next = null;
                if (map.containsKey(head.next.val)) {
                    next = map.get(head.next.val);
                } else {
                    next = new Node(head.next.val, null, null);
                    map.put(head.next.val, next);
                }
                iter.next = next;
            }
            if (head.random != null) {
                Node random = null;
                if (map.containsKey(head.random.val)) {
                    random = map.get(head.random.val);
                } else {
                    random = new Node(head.random.val, null, null);
                    map.put(head.random.val, random);
                }
                iter.random = random;
            }
            head = head.next;
            iter = iter.next;
        }

        return headCopy;
    }

    public static void main(String[] args) {
        Node node2 = new Node(-1, null, null);
        Node node1 = new Node(2, node2, node2);
        node2.random = node2;
        Node copyRandomList = new CopyListWithRandomPointer().copyRandomList(node2);
        System.out.println(copyRandomList);

    }
}
