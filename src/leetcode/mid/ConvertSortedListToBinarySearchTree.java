package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 109. 有序链表转换二叉搜索树
 * @see: <a>https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/</a>
 * @author: guoping wang
 * @date: 2019/3/20 21:43
 * @project: cc-leetcode
 */
public class ConvertSortedListToBinarySearchTree {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：遍历链表存于ArrayList，然后便可以递归构造树
     * 3ms 35.20%
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (; head != null; head = head.next){
            list.add(head.val);
        }
        return sortedListToBST(list, 0, list.size() - 1);
    }

    private TreeNode sortedListToBST(List<Integer> list, int start, int end) {
        // 递归条件
        if (start > end) return null;

        // 计算根节点的位置
        int mid = (start + end + 1) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedListToBST(list, start, mid - 1);
        root.right = sortedListToBST(list, mid + 1, end);

        return root;
    }
}
