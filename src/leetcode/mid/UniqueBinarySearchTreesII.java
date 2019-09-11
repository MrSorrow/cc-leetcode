package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 95. 不同的二叉搜索树 II
 * @see: <a>https://leetcode-cn.com/problems/unique-binary-search-trees-ii/</a>
 * @author: guoping wang
 * @date: 2019/3/13 9:13
 * @project: cc-leetcode
 */
public class UniqueBinarySearchTreesII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 参考解法：递归解法，从[96. 不同的二叉搜索树]的思路紧承而来
     * 6ms 42.35%
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftLists = generateTrees(start, i - 1);
                List<TreeNode> rightLists = generateTrees(i + 1, end);
                if (leftLists.size() > 0 && rightLists.size() > 0) {
                    for (TreeNode left : leftLists) {
                        for (TreeNode right : rightLists) {
                            TreeNode root = new TreeNode(i);
                            root.left = left;
                            root.right = right;
                            res.add(root);
                        }
                    }
                } else if (leftLists.size() == 0 && rightLists.size() > 0) {
                    for (TreeNode right : rightLists) {
                        TreeNode root = new TreeNode(i);
                        root.right = right;
                        res.add(root);
                    }
                } else if (leftLists.size() > 0) {
                    for (TreeNode left : leftLists) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        res.add(root);
                    }
                } else {
                    res.add(new TreeNode(start));
                }
            }
        }
        return res;
    }

    private List<TreeNode> generateTreesBetter(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftLists = generateTrees(start, i - 1);
                List<TreeNode> rightLists = generateTrees(i + 1, end);
                if (leftLists.size() > 0 && rightLists.size() > 0) {
                    for (TreeNode left : leftLists) {
                        for (TreeNode right : rightLists) {
                            TreeNode root = new TreeNode(i);
                            root.left = left;
                            root.right = right;
                            res.add(root);
                        }
                    }
                }
            }
        } else {
            res.add(null);
        }
        return res;
    }
}
