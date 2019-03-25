package sword2offer;

import java.util.ArrayList;

/**
 * @description: 6. 从尾到头打印链表
 * @see: <a>https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035</a>
 * @author: guoping wang
 * @date: 2019/3/25 20:14
 * @project: cc-leetcode
 */
public class PrintListFromTailToHead {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode != null) {
            res.add(0, listNode.val);
            listNode = listNode.next;
        }
        return res;
    }
}
