package leetcode.mid;

/**
 * @description: 142. 环形链表 II
 * @see: <a>https://leetcode-cn.com/problems/linked-list-cycle-ii/</a>
 * @author: guoping wang
 * @date: 2019/2/22 20:25
 * @project: cc-leetcode
 */
public class LinkedListCycleII {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 个人常规解法：快慢指针求解环的大小，再前后指针求解第一次相遇节点
     * 1ms 97.12%
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head.next;
        boolean hasCycle = false;
        int count = 1;
        // 快慢指针求解环的大小
        while (!hasCycle && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                break;
            fast = fast.next;
            count++;
            if (slow == fast) {
                hasCycle = true;
            }
        }

        // 无环
        if (!hasCycle) {
            return null;
        }

        // 前后指针
        ListNode node = head;
        for (int i = 0; i < count; i++) {
            node = node.next;
        }
        while (head != node) {
            head = head.next;
            node = node.next;
        }
        return head;
    }
}
