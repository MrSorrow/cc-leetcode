package leetcode.simple.linkedlist;

/**
 * @description: 21. 合并两个有序列表
 * @see: <a>https://leetcode-cn.com/problems/merge-two-sorted-lists/</a>
 * @author: guoping wang
 * @date: 2018/10/12 8:45
 * @project: cc-leetcode
 */
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归算法进行合并，关键在于处理返回值。这是原地算法的赶脚
     * 16ms 53.57%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 新建第三个链表进行归并
     * 11ms 96.78%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsBetter(ListNode l1, ListNode l2) {
        ListNode resNode = null;

        if (l1 == null) {
            return l2;
        }
        if (l2 == null)  {
            return l1;
        }

        if (l1.val >= l2.val) {
            resNode = l2;
            l2 = l2.next;
        } else {
            resNode = l1;
            l1 = l1.next;
        }

        ListNode node = resNode;
        while (true) {
            if (l1 == null) {
                node.next = l2;
                break;
            }
            if (l2 == null)  {
                node.next = l1;
                break;
            }
            if (l1.val >= l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }

        return resNode;
    }
}
