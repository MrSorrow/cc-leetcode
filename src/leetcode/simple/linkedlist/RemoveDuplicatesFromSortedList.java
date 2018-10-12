package leetcode.simple.linkedlist;

/**
 * @description: 83. 删除排序链表中的重复元素
 * @see: <a>https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/</a>
 * @author: guoping wang
 * @date: 2018/10/12 9:30
 * @project: cc-leetcode
 */
public class RemoveDuplicatesFromSortedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：按顺序去遍历去重
     * 1ms 98.69%
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }
}
