package recruitment.ctrip;

import java.util.Scanner;

/**
 * @description:
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/9/4 6:44 PM
 * @project: cc-leetcode
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main1 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
    ******************************开始写代码******************************/
    static ListNode partition(ListNode head, int m) {
        ListNode headPrev = new ListNode(Integer.MIN_VALUE);
        headPrev.next = head;
        ListNode pre = headPrev;
        ListNode cur = head;
        ListNode left = null;
        ListNode right = null;
        while (cur != null) {
            if (cur.val <= m) {
                if (left == null) {
                    left = cur;
                    right = cur;
                } else {
                    right.next = cur;
                    right = cur;
                }
                pre.next = cur.next;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        if (right == null) {
            return headPrev.next;
        } else {
            right.next = headPrev.next;
            return left;
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        for (int i = 0; i < 3; i++) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}
