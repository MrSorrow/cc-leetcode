package leetcode.mid;

import utils.ListUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 652. 寻找重复的子树
 * @see: <a>https://leetcode-cn.com/problems/find-duplicate-subtrees/</a>
 * @author: guoping wang
 * @date: 2019/4/5 15:05
 * @project: cc-leetcode
 */
public class FindDuplicateSubtrees {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 参考解法：这种递归解法还是有点问题的，整个过程添加节点还是同一棵树每一个节点都添加了，而最正确的做法应该是同一棵树加一次就完了
     * 样例来说，其实4是在遍历右子树的最左侧的4时添加的，其实不应该添加该4，而是后面3的右子树节点4
     * 例如main方法中的测试用例，注释掉一个4，则会发现答案错误
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        findDuplicateSubtrees(root, res, map);
        return res;
    }

    private StringBuilder findDuplicateSubtrees(TreeNode root, List<TreeNode> res, HashMap<String, Integer> map) {
        if (root == null) return new StringBuilder("$"); // 空节点用$表示
        StringBuilder left = findDuplicateSubtrees(root.left, res, map);
        StringBuilder right = findDuplicateSubtrees(root.right, res, map);

        StringBuilder key = new StringBuilder(root.val+"").append(left).append(right);
        map.put(key.toString(), map.getOrDefault(key.toString(), 0) + 1);
        if (map.get(key.toString()) == 2)
            res.add(root);
        return key;
    }


    /**
     * 个人常规解法：递归成左子树、右子树、左右子树三种情况
     * 113/168
     * @param
     * @return
     */
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        List<TreeNode> res = new LinkedList<>();
//        if (root == null || root.left == null || root.right == null)
//            return res;
//
//        List<TreeNode> left = findDuplicateSubtrees(root.left);
//        List<TreeNode> right = findDuplicateSubtrees(root.right);
//        res.addAll(left);
//        res.addAll(right);
//
//        // 左子树和右子树有相等
//        HashSet<TreeNode> leftAndRight = findDuplicateSubtrees(root.left, root.right);
//        res.addAll(leftAndRight);
//        return res;
//    }
//
//    private HashSet<TreeNode> findDuplicateSubtrees(TreeNode left, TreeNode right) {
//        HashSet<TreeNode> res = new HashSet<>();
//        if (left == null || right == null) return res;
//
//        // BFS，判断是否相同
//        boolean isDuplicate = true;
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        stack.addFirst(left);
//        stack.addFirst(right);
//
//        while (!stack.isEmpty()) {
//            TreeNode nodeL = stack.pollLast();
//            TreeNode nodeR = stack.pollLast();
//            if (nodeL.val != nodeR.val) {
//                isDuplicate = false;
//                break;
//            } else {
//                if (nodeL.left != null && nodeR.left != null) {stack.addFirst(nodeL.left); stack.addFirst(nodeR.left);}
//                else if (nodeL.left != null || nodeR.left != null) {isDuplicate = false; res.clear(); break;}
//                if (nodeL.right != null && nodeR.right != null) {stack.addFirst(nodeL.right); stack.addFirst(nodeR.right);}
//                else if (nodeL.right != null || nodeR.right != null) {isDuplicate = false; res.clear(); break;}
//            }
//        }
//
//        if (isDuplicate) {
//            res.add(left);
//        } else {
//            HashSet<TreeNode> l1 = findDuplicateSubtrees(left.left, right);
//            HashSet<TreeNode> l2 = findDuplicateSubtrees(left.right, right);
//            HashSet<TreeNode> l3 = findDuplicateSubtrees(left, right.left);
//            HashSet<TreeNode> l4 = findDuplicateSubtrees(left, right.right);
//            res.addAll(l1);
//            res.addAll(l2);
//            res.addAll(l3);
//            res.addAll(l4);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        List<TreeNode> duplicateSubtrees = new FindDuplicateSubtrees().findDuplicateSubtrees(root);
        ListUtils.printLists(duplicateSubtrees);
    }
}
