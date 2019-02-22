package leetcode.mid;

/**
 * @description: 143. 重排链表
 * @see: <a>https://leetcode-cn.com/problems/reorder-list/</a>
 * @author: guoping wang
 * @date: 2019/2/22 14:20
 * @project: cc-leetcode
 */
public class ReorderList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：保存数组进行重组
     * 4ms 77.20%
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode iter = head;
        int num = 0;
        while (iter != null) {
            iter = iter.next;
            num++;
        }
        // 存入数组
        ListNode[] nodes = new ListNode[num];
        num = 0;
        iter = head;
        while (iter != null) {
            nodes[num++] = iter;
            iter = iter.next;
        }

        // 重组
        for (int i = 0; i < nodes.length; i++) {
            if (i < nodes.length / 2)
                nodes[i].next = nodes[nodes.length - i - 1];
            else if (i == nodes.length / 2)
                nodes[i].next = null;
            else
                nodes[i].next = nodes[nodes.length - i];
        }
    }
}
