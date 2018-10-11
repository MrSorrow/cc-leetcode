package leetcode.learn.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉查找树实现
 * @author: guoping wang
 * @date: 2018/10/10 21:13
 * @project: cc-leetcode
 */
public class BinSearchTreeST<Key extends Comparable<Key>, Value> extends BaseST<Key, Value> {

    private Node root;

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 递归方式实现查找：和一个节点比较，判断相等、左边子树还是右边子树
     * @param key
     * @return
     */
    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = node.key.compareTo(key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            // 节点小于查找的
            return get(node.right, key);
        } else {
            return get(node.left, key);
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 递归插入节点：比较当前节点，如果等于就更新，如果大于就插右子树中，小于就是左子树
     * @param node
     * @param key
     * @param value
     */
    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = node.key.compareTo(key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.right = put(node.right, key, value);
        } else {
            node.left = put(node.left, key, value);
        }
        // 更新node所在子树的节点数
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key min() {
        return min(root).key;
    }

    /**
     * 递归寻找左节点
     * @return
     */
    private Node min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Key max() {
        return max(root).key;
    }

    /**
     * 递归寻找右节点
     * @param node
     * @return
     */
    private Node max(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * 返回对key向下取整的节点
     * @param key
     * @return
     */
    public Node floor(Key key) {
        return floor(root, key);
    }

    /**
     * 递归，如果相等直接返回，如果此节点小于key，说明是此节点或者右子树中的，如果大于key，肯定是左子树的
     * @param node
     * @param key
     * @return
     */
    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = node.key.compareTo(key);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return floor(node.left, key);
        } else {
            // 重点处理之处
            Node t = floor(node.right, key);
            return t == null ? node : t;
        }

    }

    /**
     * 返回对key向上取整的节点
     * @param key
     * @return
     */
    public Node ceiling(Key key) {
        return ceiling(root, key);
    }

    /**
     * 递归，如果相等直接返回，如果此节点小于key，说明是在右子树中的，如果大于key，肯定是此节点或者左子树中的
     * @param node
     * @param key
     * @return
     */
    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = node.key.compareTo(key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return ceiling(node.right, key);
        } else {
            Node t = ceiling(node.left, key);
            return t == null ? node : t;
        }
    }

    /**
     * 寻找排名为k的节点
     * @param k
     * @return
     */
    public Node select(int k) {
        return select(root, k);
    }

    /**
     * 递归寻找：依据节点的数目值
     * @param node
     * @param k
     * @return
     */
    private Node select(Node node, int k) {
        if (node == null) {
            return null;
        }
        if (size(node) == k) {
            return node;
        } else if (size(node) < k) {
            return select(node.right, k - size(node.left) - 1);
        } else {
            return select(node.left, k);
        }
    }

    /**
     * 返回指定key的排名
     * @return
     */
    public int rank(Key key) {
        return rank(root, key);
    }

    /**
     * 返回以node为根节点的树小于key的节点数目：递归统计排名
     * @param node
     * @param key
     * @return
     */
    private int rank(Node node, Key key) {
        if (node == null) {
            return 0;
        }
        int cmp = node.key.compareTo(key);
        if (cmp == 0) {
            return size(node.left);
        } else if (cmp < 0) {
            return size(node.left) + 1 + rank(node.right, key);
        } else {
            return rank(node.left, key);
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    /**
     * 递归寻找左孩子，最终删除后形成新的树形结构
     * @param node
     * @return
     */
    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right; // 好好体会
        }
        node.left = deleteMin(node.left);
        // 更新N
        node.N = size(node.left) + 1 + size(node.right);
        return node;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    /**
     * 递归寻找右孩子，最终删除后形成新的树形结构
     * @param node
     * @return
     */
    private Node deleteMax(Node node) {
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.N = size(node.left) + 1 + size(node.right);
        return node;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Value delete(Key key) {
        Value res = get(key);
        root = delete(root, key);
        return res;
    }

    /**
     * 递归删除某个key的节点
     * @param node
     * @param key
     * @return
     */
    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = node.key.compareTo(key);
        if (cmp < 0) {
            node.right = delete(node.right, key);
        } else if (cmp > 0) {
            node.left = delete(node.left, key);
        } else {
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            } else {
                // 如果要删除节点有两个孩子：先替换成min节点，再重新赋值min的左右孩子
                Node t = node;
                node = min(t.right);
                node.right = deleteMin(t.right);
                node.left = t.left;
            }
        }
        // 更新N
        node.N = size(node.left) + 1 + size(node.right);
        return node;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
        if (node == null) {
            return;
        }

        int cmpl = node.key.compareTo(lo);
        int cmph = node.key.compareTo(hi);

        if (cmph < 0) {
            keys(node.right, queue, lo, hi);
        } else if (cmpl > 0) {
            keys(node.left, queue, lo, hi);
        } else if (cmph <= 0 && cmpl >= 0) {
            queue.add(node.key);
        }
    }

    /**
     * 二叉树的节点类，包含左右孩子，当前节点的key和value，以及以当前节点为根节点的子树上所含有的节点数
     */
    public class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public static void main(String[] args) {
        BinSearchTreeST<String, String> binarySearchST = new BinSearchTreeST<>();
        binarySearchST.put("a", "aa");
        binarySearchST.put("vb", "aa");
        binarySearchST.put("s", "aa");
        binarySearchST.put("a", "bb");
        System.out.println(binarySearchST.delete("a"));
        System.out.println(binarySearchST.contains("a"));
        System.out.println(binarySearchST.contains("s"));
        System.out.println(binarySearchST.size());
    }
}
