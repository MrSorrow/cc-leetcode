package leetcode.mid;

/**
 * @description: 2. 两数相加
 * @see: <a>https://leetcode-cn.com/problems/add-two-numbers/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/12/18 下午9:14
 * @project: cc-leetcode
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private int extra;

    /**
     * 个人常规解法：递归解法，带上进位
     * 28ms 97.02%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return extra == 0 ? null : new ListNode(1);
        } else if (l1 == null && l2 != null) {
            if (extra == 0) {
                return l2;
            } else {
                extra = 0;
                return addTwoNumbers(new ListNode(1), l2.next);
            }
        } else if (l2 == null && l1 != null) {
            if (extra == 0) {
                return l1;
            } else {
                extra = 0;
                return addTwoNumbers(new ListNode(1), l1.next);
            }
        } else {
            ListNode node = new ListNode((l1.val + l2.val + extra) % 10);
            if (l1.val + l2.val + extra >= 10) extra = 1;
            else extra = 0;
            node.next = addTwoNumbers(l1.next, l2.next);
            return node;
        }
    }
}
