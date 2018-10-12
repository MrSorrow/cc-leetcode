package leetcode.simple.linkedlist;

/**
 * @description: 141. 环形链表
 * @see: <a>https://leetcode-cn.com/problems/linked-list-cycle/</a>
 * @author: guoping wang
 * @date: 2018/10/12 9:43
 * @project: cc-leetcode
 */
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 个人常规解法：快慢指针
     * 1ms 80.15%
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow != null && fast != null) {
                if (slow.equals(fast)) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }
}