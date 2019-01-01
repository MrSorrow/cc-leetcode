package leetcode.mid;

/**
 * @description: 24. 两两交换链表中的节点
 * @see: <a>https://leetcode-cn.com/problems/swap-nodes-in-pairs/</a>
 * @author: guoping wang
 * @date: 2019/1/1 16:03
 * @project: cc-leetcode
 */
public class SwapNodesInPairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归
     * 2ms 100%
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node = head.next;
        head.next = node.next;
        node.next = head;
        head.next = swapPairs(head.next);

        return node;
    }
}
