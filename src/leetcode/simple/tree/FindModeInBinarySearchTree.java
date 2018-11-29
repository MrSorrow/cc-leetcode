package leetcode.simple.tree;

import leetcode.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 501.二叉搜索树中的众数
 * @see: <a>https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/28 21:38
 * @project: cc-leetcode
 */
public class FindModeInBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        private TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：现将二叉搜索树进行遍历的得到有序的list，然后进行寻找众数
     * 20ms 32.91%
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        List<Integer> sortListOfTree = getSortListOfTree(root);
        if (sortListOfTree.size() == 0) return new int[0];
        if (sortListOfTree.size() == 1) return new int[] {root.val};

        List<Integer> resList = new ArrayList<>();

        int maxCount = 0, curCount = 1, index = 1;
        while (index < sortListOfTree.size()) {
            if (sortListOfTree.get(index).equals(sortListOfTree.get(index - 1))) {
                curCount++;
            } else {
                if (curCount > maxCount) {
                    maxCount = curCount;
                    resList.clear();
                    resList.add(sortListOfTree.get(index - 1));
                } else if (curCount == maxCount) {
                    resList.add(sortListOfTree.get(index - 1));
                }
                curCount = 1;
            }
            index++;
            if (index >= sortListOfTree.size()) {
                if (curCount > maxCount) {
                    maxCount = curCount;
                    resList.clear();
                    resList.add(sortListOfTree.get(index - 1));
                } else if (curCount == maxCount) {
                    resList.add(sortListOfTree.get(index - 1));
                }
            }
        }

        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public List<Integer> getSortListOfTree(TreeNode node) {
        List<Integer> res =  new ArrayList<>();
        if (node == null) {
            return res;
        }
        res.addAll(getSortListOfTree(node.left));
        res.add(node.val);
        res.addAll(getSortListOfTree(node.right));
        return res;
    }


    /**
     * 相同的思路，不需要中转成list再进行统计,直接递归遍历
     * 2ms 100%
     * @param root
     * @return
     */
    public int[] findModeDirect(TreeNode root) {
        travel(root);
        if (current >= max) {
            if (current > max) {
                res.clear();
            }
            if (prev != null)
                res.add(prev.val);
        }

        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    List<Integer> res = new ArrayList<>();
    int max = 0, current = 0;
    TreeNode prev = null;

    public void travel(TreeNode node) {
        if (node == null) {
            return;
        }
        travel(node.left);

        // 中间节点处理
        if (prev == null) {
            current++;
        } else {
            if (prev.val == node.val) {
                current++;
            } else {
                if (current >= max) {
                    if (current > max) {
                        res.clear();
                        max = current;
                    }
                    res.add(prev.val);
                }
                current = 1;
            }
        }
        prev = node;
        travel(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = null;
//        root.right = new TreeNode(2);
//        root.right.right = new TreeNode(3);
        ArrayUtils.printIntArray(new FindModeInBinarySearchTree().findModeDirect(root));
    }
}
