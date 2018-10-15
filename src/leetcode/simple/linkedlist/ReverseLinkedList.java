package leetcode.simple.linkedlist;

import java.util.Stack;

/**
 * @description: 206. 反转链表
 * @see: <a>https://leetcode-cn.com/problems/reverse-linked-list/</a>
 * @author: guoping wang
 * @date: 2018/10/15 18:42
 * @project: cc-leetcode
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 个人常规解法：堆栈存放每个节点然后重组
     * 2ms 8.87%
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        if (stack.isEmpty()) {
            return null;
        }

        ListNode resNode = stack.pop(), node = resNode;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null; // 断开链表，不可或缺
        return resNode;
    }

    /**
     * 个人常规解法：递归
     * 25ms 3.36%
     * @param head
     * @return
     */
    public ListNode reverseListCir(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next != null) {
            ListNode node = head.next;
            head.next = null;

            ListNode res = reverseList(node);
            node = res;
            while (node.next != null) {
                node = node.next;
            }
            node.next = head;
            return res;
        } else {
            return head;
        }
    }

    /**
     * 更好的递归
     * 0ms 100%
     * @param head
     * @return
     */
    public ListNode reverseListCirBest(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head.next;
        head.next = null;

        ListNode res = reverseList(node);
        node.next = head;
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

        System.out.println(new ReverseLinkedList().reverseList(head));
    }
}
