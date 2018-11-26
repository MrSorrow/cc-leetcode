package leetcode.simple.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 107. 二叉树的层次遍历 II
 * @see: <a>https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/</a>
 * @author: guoping wang
 * @date: 2018/11/26 20:57
 * @project: cc-leetcode
 */
public class BinaryTreeLevelOrderTraversalII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：从顶向下的遍历，添加list的时候倒序即可
     * 2ms 86.43%
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List<List<TreeNode>> nodeLists = new LinkedList<>();
        if (root != null) {
            List<Integer> rootRow = new ArrayList<>(1);
            rootRow.add(root.val);
            result.add(rootRow);

            List<TreeNode> rootNode = new ArrayList<>(1);
            rootNode.add(root);
            nodeLists.add(rootNode);

            // 从上一层找下一层
            while (!nodeLists.get(0).isEmpty()) {
                List<TreeNode> lastRow = nodeLists.get(0);
                List<TreeNode> treeNodes = new ArrayList<>();
                List<Integer> values = new ArrayList<>();
                for (int i = 0; i < lastRow.size(); i++) {
                    if (lastRow.get(i).left != null) {
                        treeNodes.add(lastRow.get(i).left);
                        values.add(lastRow.get(i).left.val);
                    }
                    if (lastRow.get(i).right != null) {
                        treeNodes.add(lastRow.get(i).right);
                        values.add(lastRow.get(i).right.val);
                    }
                }
                if (!values.isEmpty()) {
                    ((LinkedList<List<Integer>>) result).addFirst(values);
                    ((LinkedList<List<TreeNode>>) nodeLists).addFirst(treeNodes);
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        new BinaryTreeLevelOrderTraversalII().levelOrderBottom(treeNode);
    }
}
