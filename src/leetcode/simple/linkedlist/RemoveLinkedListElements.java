package leetcode.simple.linkedlist;

/**
 * @description: 203. 移除链表元素
 * @see: <a>https://leetcode-cn.com/problems/remove-linked-list-elements/</a>
 * @author: guoping wang
 * @date: 2018/10/13 22:41
 * @project: cc-leetcode
 */
public class RemoveLinkedListElements {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 递归，最快
     * 1ms 100%
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsBest(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 个人常规解法：原地算法，遍历时进行跳跃链接
     * 5ms 89.77%
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        while (node != null) {
            if (head.val == val) {
                head = head.next;
                node = head;
                continue;
            }

            ListNode temp = node.next;
            // 寻找连接点
            while (temp != null && temp.val == val) {
                temp = temp.next;
            }
            // 连接
            node.next = temp;
            node = temp;
        }
        return head;
    }

    /**
     * 个人常规解法：非原地算法
     * 5ms 89.77%
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsFaster(ListNode head, int val) {
        ListNode res = null;
        ListNode node = null;
        boolean hasAssign = false;

        while (head != null) {
            if (head.val != val) {
                if (!hasAssign) {
                    hasAssign = true;
                    node = head;
                    res = node;
                } else {
                    node.next = head;
                    node = node.next;
                }
            }

            head = head.next;
        }

        // 清空后面跟着的
        if (node != null) {
            node.next = null;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }

        System.out.println(new RemoveLinkedListElements().removeElementsFaster(null, 6));
    }
}
