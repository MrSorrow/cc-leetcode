package leetcode.mid;

/**
 * @description: 328. 奇偶链表
 * @see: <a>https://leetcode-cn.com/problems/odd-even-linked-list/</a>
 * @author: guoping wang
 * @date: 2019/3/26 9:35
 * @project: cc-leetcode
 */
public class OddEvenLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：三个指针，奇指针，偶指针和迭代指针
     * 5ms 80.02%
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode redundancyOdd = new ListNode(0);
        ListNode redundancyEven = new ListNode(0);
        ListNode odd = redundancyOdd, even = redundancyEven;
        boolean isOdd = true;
        // 迭代遍历，构造节点
        for (ListNode iter = head; iter != null; iter = iter.next) {
            if (isOdd) odd = odd.next = iter;
            else even = even.next = iter;
            isOdd = !isOdd;
        }
        // 最后奇偶相连
        odd.next = redundancyEven.next;
        even.next = null;
        return redundancyOdd.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        new OddEvenLinkedList().oddEvenList(node);
    }
}
