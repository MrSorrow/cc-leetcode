package leetcode.mid;

/**
 * @description: 61. 旋转链表
 * @see: <a>https://leetcode-cn.com/problems/rotate-list/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/1/20 上午11:32
 * @project: cc-leetcode
 */
public class RotateList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：快慢指针定位节点，然后进行旋转
     * 5261ms 0.96%
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // 先找出目标节点
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            if (fast.next == null) {
                fast = head;
            } else {
                fast = fast.next;
            }
        }
        if (fast == head) return head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 旋转
        ListNode res = slow.next;
        fast.next = head;
        slow.next = null;
        return res;
    }

    /**
     * 个人常规解法：先统计节点数目，然后根据数目知道位置
     * 10ms 91.06%
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRightBetter(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode node = head;
        int count = 1;
        while (node.next != null) {
            node = node.next;
            count++;
        }
        if (count == 1) return head;
        k = k % count;
        if (k == 0) return head;
        ListNode res = head;
        for (int i = 0; i < count - k - 1; i++) {
            res = res.next;
        }


        // 旋转
        ListNode nodeRes = res.next;
        node.next = head;
        res.next = null;
        return nodeRes;
    }
}
