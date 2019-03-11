package leetcode.mid;


import java.util.LinkedList;

/**
 * @description: 92. 反转链表 II
 * @see: <a>https://leetcode-cn.com/problems/reverse-linked-list-ii/</a>
 * @author: guoping wang
 * @date: 2019/3/10 18:55
 * @project: cc-leetcode
 */
public class ReverseLinkedListII {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：利用栈来添加，正好实现翻转
     * 4/44 内存超限
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetweenStack(ListNode head, int m, int n) {
        LinkedList<ListNode> stack = new LinkedList<>();
        int count = 1;
        ListNode iterator = head, front = null;

        while (iterator != null) {
            if (count < m) {
                front = iterator;
            }

            if (count > n) {
                while (!stack.isEmpty()) {
                    if (front == null) {
                        front = stack.pop();
                        head = front;
                    } else {
                        front.next = stack.pop();
                        front = front.next;
                    }
                }
                front.next = iterator;
                break;
            }

            // 判断指定范围区域节点
            if (count >= m && count <= n) {
                stack.push(iterator);
            }

            // 更新
            count++;
            iterator = iterator.next;
        }

        while (!stack.isEmpty()) {
            if (front == null) {
                front = stack.pop();
                head = front;
            } else {
                front.next = stack.pop();
                front = front.next;
            }
        }

        return head;
    }

    /**
     * 参考解法：遇见一个就前插，最前面先加一个冗余节点
     * 3ms 82.93%
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode iterator = new ListNode(1), front = null;
        iterator.next = head;
        head = iterator;

        while (iterator != null) {
            if (count > m && count <= n) {
                ListNode next = iterator.next;

                iterator.next = next.next;
                next.next = front.next;
                front.next = next;

            } else if (count < m) {
                front = iterator;
                iterator = iterator.next;
            } else if (count > n) {
                break;
            }
            // 更新
            count++;
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        new ReverseLinkedListII().reverseBetween(head, 1, 2);
    }
}
