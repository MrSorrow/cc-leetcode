package leetcode.mid;

/**
 * @description: 86. 分隔链表
 * @see: <a>https://leetcode-cn.com/problems/partition-list/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/3/10 9:37 AM
 * @project: cc-leetcode
 */
public class PartitionList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：构造两个链表，最后再相连即可
     * 1ms 84.18%
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = null, sIterator = null, big = null, bIterator = null;

        while (head != null) {
            if (head.val < x) {
                if (small == null) {
                    small = head;
                    sIterator = head;
                } else {
                    sIterator.next = head;
                    sIterator = sIterator.next;
                }
            } else {
                if (big == null) {
                    big = head;
                    bIterator = head;
                } else {
                    bIterator.next = head;
                    bIterator = bIterator.next;
                }
            }
            head = head.next;
        }

        if (small == null) {
            return big;
        } else if (big == null) {
            return small;
        } else {
            sIterator.next = big;
            bIterator.next = null;
            return small;
        }
    }
}
