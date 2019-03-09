package leetcode.mid;

/**
 * @description: 82. 删除排序链表中的重复元素 II
 * @see: <a>https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/</a>
 * @author: guoping wang
 * @date: 2019/3/9 9:49
 * @project: cc-leetcode
 */
public class RemoveDuplicatesFromSortedListII {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：快慢指针
     * 1ms 98.69%
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = null, fast = head, res = null;

        // 快指针不断向前遍历
        while (fast != null) {
            boolean isDuplicate = false;

            while (fast.next != null) {
                if (fast.val == fast.next.val) {
                    isDuplicate = true; // 标记已经重复了
                    fast = fast.next; // 重复的话一直前进
                } else {
                    // 不重复直接退出
                    break;
                }
            }

            ListNode next = fast.next;
            if (!isDuplicate) {
                if (slow == null) {
                    slow = fast;
                    res = slow;
                } else {
                    slow.next = fast;
                    slow = slow.next;
                }
                slow.next = null;
            }
            fast = next;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(head));
    }
}
