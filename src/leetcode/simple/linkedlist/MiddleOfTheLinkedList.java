package leetcode.simple.linkedlist;

/**
 * @description: 876. 链表中的中间节点
 * @see: <a>https://leetcode-cn.com/problems/middle-of-the-linked-list/</a>
 * @author: guoping wang
 * @date: 2018/10/15 21:51
 * @project: cc-leetcode
 */
public class MiddleOfTheLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：先遍历求长度，再折半遍历
     * 1ms 100%
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        length /= 2;
        node = head;
        for (int i = 0; i < length; i++) {
            node = node.next;
        }

        return node;
    }
}
