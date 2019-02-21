package leetcode.mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 148. 排序链表
 * @see: <a>https://leetcode-cn.com/problems/sort-list/</a>
 * @author: guoping wang
 * @date: 2019/2/20 22:01
 * @project: cc-leetcode
 */
public class SortList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：加入集合进行排序，不符合题意原本要求
     * 16ms 27.02%
     * @param head
     * @return
     */
    public ListNode sortListCollectionSort(ListNode head) {
        if (head == null) return head;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        // 排序
        Collections.sort(list);
        ListNode res = new ListNode(list.get(0));
        ListNode iter = res;
        for (int i = 1; i < list.size(); i++) {
            iter.next = new ListNode(list.get(i));
            iter = iter.next;
        }
        return res;
    }

    /**
     * 个人常规解法：插入排序
     * 1665ms 1%
     * @param head
     * @return
     */
    public ListNode sortListInsertSort(ListNode head) {
        if (head == null) return head;
        ListNode res = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            // 插入排序
            int val = head.val;
            ListNode iter = res;
            if (val < iter.val) {
                res = new ListNode(val);
                res.next = iter;
            } else {
                while (iter.next != null && val >= iter.next.val) {
                    iter = iter.next;
                }
                ListNode next = iter.next;
                iter.next = new ListNode(val);
                iter.next.next = next;
            }

            // 遍历下一个节点
            head = head.next;
        }
        return res;
    }

    /**
     * 最优解法：归并算法
     * 8ms 70.79%
     * @param head
     * @return
     */
    public ListNode sortListMergeSort(ListNode head) {
        // 没有或仅有一个元素就是对的
        if (head == null || head.next == null) return head;

        // 快慢指针寻找中间节点
        ListNode fast = head, slow = head;
        boolean flag = false;
        while (fast.next != null) {
            fast = fast.next;
            if (flag) {
                slow = slow.next;
            }
            flag = !flag;
        }
        // 前一半为head 后一半为last
        ListNode last = slow.next;
        slow.next = null;

        // 排序两段列表
        head = sortListMergeSort(head);
        last = sortListMergeSort(last);

        // 归并
        if (head == null) return last;
        if (last == null) return head;

        ListNode res = null;
        if (head.val < last.val) {
            res = head;
            head = head.next;
        } else {
            res = last;
            last = last.next;
        }
        ListNode iter = res;
        while (head != null && last != null) {
            if (head.val < last.val) {
                iter.next = head;
                head = head.next;
            } else {
                iter.next = last;
                last = last.next;
            }
            iter = iter.next;
        }
        if (head != null) iter.next = head;
        if (last != null) iter.next = last;

        return res;
    }
}
