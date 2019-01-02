package leetcode.mid;

/**
 * @description: 19. 删除链表的倒数第N个节点
 * @see: <a>https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/</a>
 * @author: guoping wang
 * @date: 2018/12/28 22:50
 * @project: cc-leetcode
 */
public class RemoveNthNodeFromEndOfList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：快慢指针
     * 15ms 65.08%
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
            if (fast == null) {
                throw new IllegalArgumentException("wrong n");
            }
        }
        if (fast.next == null) {
            return head.next;
        }
        fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
