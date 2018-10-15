package leetcode.simple.linkedlist;

import java.util.Stack;

/**
 * @description: 234. 回文链表
 * @see: <a>https://leetcode-cn.com/problems/palindrome-linked-list/</a>
 * @author: guoping wang
 * @date: 2018/10/15 19:19
 * @project: cc-leetcode
 */
public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：堆栈存储
     * 5ms 42.29%
     * @param head
     * @return
     */
    public boolean isPalindromeStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.add(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 个人常规解法：其实就是比较数字是否是反的
     * 2ms 80.99%
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = head.val;
            head = head.next;
        }
        for (int i = 0; i < length / 2; i++) {
            if (nums[i] != nums[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
