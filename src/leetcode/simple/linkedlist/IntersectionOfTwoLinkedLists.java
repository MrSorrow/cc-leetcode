package leetcode.simple.linkedlist;

/**
 * @description: 160. 相交链表
 * @see: <a>https://leetcode-cn.com/problems/intersection-of-two-linked-lists/</a>
 * @author: guoping wang
 * @date: 2018/10/13 22:12
 * @project: cc-leetcode
 */
public class IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 个人常规解法：遍历出两个节点的长度，然后再相减，再进行遍历
     * 2ms 80.22%
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        if (headA == headB) {
            return headA;
        }

        int lengthA = 1, lengthB = 1;
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
            lengthA++;
        }
        node = headB;
        while (node.next != null) {
            node = node.next;
            lengthB++;
        }

        ListNode node1 = headA;
        ListNode node2 = headB;
        int count = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            while (true) {
                if (count > 0) {
                    node1 = node1.next;
                    count--;
                    continue;
                }

                if (node1 == null) {
                    break;
                }

                if (node1 == node2) {
                    return node1;
                } else {
                    node1 = node1.next;
                    node2 = node2.next;
                }
            }
        } else {
            while (true) {
                if (count > 0) {
                    node2 = node2.next;
                    count--;
                    continue;
                }

                if (node2 == null) {
                    break;
                }

                if (node1 == node2) {
                    return node1;
                } else {
                    node1 = node1.next;
                    node2 = node2.next;
                }
            }
        }

        return null;
    }
}
