package leetcode.simple.dfs;

/**
 * @description: 100. 相同的树
 * @see: <a>https://leetcode-cn.com/problems/same-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/5 19:51
 * @project: cc-leetcode
 */
public class SameTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归检索，理论上算一个中序遍历的判断是否相同
     * 5ms 66.04%
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == q) {
                return true;
            } else {
                return false;
            }
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
