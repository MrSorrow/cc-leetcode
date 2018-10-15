package leetcode.simple.linkedlist;

/**
 * @description: 237. 删除链表中的节点
 * @see: <a>https://leetcode-cn.com/problems/delete-node-in-a-linked-list/</a>
 * @author: guoping wang
 * @date: 2018/10/15 20:48
 * @project: cc-leetcode
 */
public class DeleteNodeInALinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：后面一个值赋值给前面
     * 0ms 100.00%
     * @param node
     */
    public void deleteNode(ListNode node) {

        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
            } else {
                node = node.next;
            }
        }
    }
}
