package leetcode.simple.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 872. 叶子相似的树
 * @see: <a>https://leetcode-cn.com/problems/leaf-similar-trees/</a>
 * @author: guoping wang
 * @date: 2018/11/24 21:01
 * @project: cc-leetcode
 */
public class LeafSimilarTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：先求出所有序列，然后再进行比较
     * 2ms 100%
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        res1 = getLeaf(root1, res1);
        res2 = getLeaf(root2, res2);
        if (res1.size() != res2.size()) {
            return false;
        }
        for (int i = 0, length = res1.size(); i < length; i++) {
            if (res1.get(i) != res2.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归求出所有叶子节点序列
     * @param node
     * @param result
     * @return
     */
    public List<Integer> getLeaf(TreeNode node, List<Integer> result) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                // 当前节点为叶子节点
                result.add(node.val);
            } else {
                result = getLeaf(node.left, result);
                result = getLeaf(node.right, result);
            }
        }
        return result;
    }
}
