package leetcode.mid;

/**
 * @description: 147. 对链表进行插入排序
 * @see: <a>https://leetcode-cn.com/problems/insertion-sort-list/</a>
 * @author: guoping wang
 * @date: 2019/2/21 20:21
 * @project: cc-leetcode
 */
public class InsertionSortList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归的插入写法
     * 37ms 62.94%
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node = head.next;
        head.next = null;

        // 排序
        node = insertionSortList(node);

        // node插入head
        if (node.val >= head.val) {
            head.next = node;
            return head;
        } else {
            ListNode iter = node;
            while (iter.next != null && iter.next.val < head.val) {
                iter = iter.next;
            }
            head.next = iter.next;
            iter.next = head;
            return node;
        }
    }
}
