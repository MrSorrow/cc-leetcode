package leetcode.mid;

import java.util.Stack;

/**
 * @description: 445. 两数相加 II
 * @see: <a>https://leetcode-cn.com/problems/add-two-numbers-ii/</a>
 * @author: guoping wang
 * @date: 2019/3/30 19:46
 * @project: cc-leetcode
 */
public class AddTwoNumbersII {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：用栈的方式存储节点，然后出栈相加，非常类似两个字符串数字相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        // 遍历入栈
        for (ListNode iterator = l1; iterator != null ; iterator = iterator.next) {
            stack1.push(iterator);
        }
        for (ListNode iterator = l2; iterator != null ; iterator = iterator.next) {
            stack2.push(iterator);
        }

        // 出栈相加
        int bit = 0; // 进位标记
        boolean updateWho = stack1.size() > stack2.size();

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ListNode node1 = stack1.isEmpty() ? null : stack1.pop();
            ListNode node2 = stack2.isEmpty() ? null : stack2.pop();
            int result = bit;
            if (node1 != null) result += node1.val;
            if (node2 != null) result += node2.val;
            bit = result / 10;
            result %= 10;
            // 更新节点
            if (updateWho) node1.val = result;
            else node2.val = result;
        }
        if (bit == 1) {
            ListNode res = new ListNode(1);
            res.next = updateWho ? l1 : l2;
            return res;
        } else {
            return updateWho ? l1 : l2;
        }
    }
}
