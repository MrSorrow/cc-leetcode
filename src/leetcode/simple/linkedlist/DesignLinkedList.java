package leetcode.simple.linkedlist;

/**
 * @description: 707. 设计链表
 * @see: <a>https://leetcode-cn.com/problems/design-linked-list/</a>
 * @author: guoping wang
 * @date: 2018/10/15 21:07
 * @project: cc-leetcode
 */
public class DesignLinkedList {

    /**
     * 个人常规解法：正常设置根节点链表数据结构
     * 99ms 88.23%
     */
    static class MyLinkedList {

        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }

        ListNode head;
        int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = null;
            size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                size++;
                return;
            }
            ListNode node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index <= 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else if (index > size) {
                return;
            } else {
                ListNode newNode = new ListNode(val);
                ListNode node = head;
                for (int i = 0; i < index - 1; i++) {
                    node = node.next;
                }
                newNode.next = node.next;
                node.next = newNode;
                size++;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index == 0) {
                head = head.next;
                size--;
            } else if (index == size - 1) {
                ListNode node = head;
                for (int i = 0; i < index - 1; i++) {
                    node = node.next;
                }
                node.next = null;
                size--;
            } else if (index < size - 1 && index > 0) {
                ListNode node = head;
                for (int i = 0; i < index - 1; i++) {
                    node = node.next;
                }
                node.next = node.next.next;
                size--;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.get(0);
        myLinkedList.get(2);
    }
}
