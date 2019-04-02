package leetcode.mid;

/**
 * @description: 513. 找树左下角的值
 * @see: <a>https://leetcode-cn.com/problems/find-bottom-left-tree-value/</a>
 * @author: guoping wang
 * @date: 2019/4/2 22:08
 * @project: cc-leetcode
 */
public class FindBottomLeftTreeValue {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：dfs的方法
     * 1ms 100%
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        int[] res = findBottomLeftValueAndDepth(root);
        return res[0];
    }

    private int[] findBottomLeftValueAndDepth(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return null;
        } else {
            int[] left = findBottomLeftValueAndDepth(root.left);
            int[] right = findBottomLeftValueAndDepth(root.right);
            if (left == null && right == null) {
                res[0] = root.val;
                res[1] = 1;
                return res;
            }  else if (left != null && (right == null || left[1] >= right[1])) {
                res[0] = left[0];
                res[1] = left[1] + 1;
            } else {
                res[0] = right[0];
                res[1] = right[1] + 1;
            }
        }
        return res;
    }
}
