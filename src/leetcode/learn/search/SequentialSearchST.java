package leetcode.learn.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 基于无序链表的顺序查找符号表
 * @author: guoping wang
 * @date: 2018/9/12 21:49
 * @project: cc-leetcode
 */
public class SequentialSearchST<Key extends Comparable<Key>, Value> extends BaseST<Key, Value> {

    public class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 头结点
     */
    private Node head;
    /**
     * 大小
     */
    private int size;

    @Override
    public Value get(Key key) {
        // 顺序查找
        for (Node node = head; head != null; head = head.next) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        size++;
        // 顺序查找是否含有key
        for (Node node = head; head != null; head = head.next) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        // 创建新节点后面接上原来的链表
        head = new Node(key, value, head);
    }

    @Override
    public boolean contains(Key key) {
        for (Node node = head; head != null; head = head.next) {
            if (key.equals(node.key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Value delete(Key key) {
        for (Node node = head; head != null; head = head.next) {
            if (key.equals(node.key)) {
                Value value = node.value;
                node.value = null;
                size--;
                return value;
            }
        }
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> list = new ArrayList<>();
        for (Node node = head; head != null; head = head.next) {
            list.add(node.key);
        }
        return list;
    }
}
