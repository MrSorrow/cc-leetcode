package leetcode.simple.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 257. 二叉树的所有路径
 * @see: <a>https://leetcode-cn.com/problems/binary-tree-paths/</a>
 * @author: guoping wang
 * @date: 2018/11/7 20:40
 * @project: cc-leetcode
 */
public class BinaryTreePaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归去遍历路径
     * 20ms 43.18%
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            // 空的
        } else if (root.left == null && root.right != null) {
            List<String> paths = binaryTreePaths(root.right);
            for (String path : paths) {
                res.add(root.val + "->" + path);
            }
        } else if (root.right == null && root.left != null) {
            List<String> paths = binaryTreePaths(root.left);
            for (String path : paths) {
                res.add(root.val + "->" + path);
            }
        } else if (root.left == null && root.right == null) {
            res.add(root.val+"");
        } else {
            List<String> paths = binaryTreePaths(root.left);
            for (String path : paths) {
                res.add(root.val + "->" + path);
            }
            paths = binaryTreePaths(root.right);
            for (String path : paths) {
                res.add(root.val + "->" + path);
            }
        }
        return res;
    }

    /**
     * 个人常规解法：递归去遍历路径,更好的写法
     * 11ms 99.68%
     * @param root
     * @return
     */
    public List<String> binaryTreePathsBetter(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val+"");
        }
        if (root.right != null) {
            List<String> paths = binaryTreePathsBetter(root.right);
            for (String path : paths) {
                res.add(root.val + "->" + path);
            }
        }
        if (root.left != null) {
            List<String> paths = binaryTreePathsBetter(root.left);
            for (String path : paths) {
                res.add(root.val + "->" + path);
            }
        }
        return res;
    }
}
