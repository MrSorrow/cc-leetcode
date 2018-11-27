package leetcode.simple.tree;

/**
 * @description: 437.路径总和 III
 * @see: <a>https://leetcode-cn.com/problems/path-sum-iii/</a>
 * @author: guoping wang
 * @date: 2018/11/27 21:43
 * @project: cc-leetcode
 */
public class PathSumIII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归，每个根节点转化为四种情况，其中根节点包含的情况必须后面的节点是连续包含的，所以有pathSumMustChooseOne函数
     * 21ms 81.14%
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root != null && sum == root.val) {
            return 1 + pathSum(root.left, sum) + pathSum(root.right, sum)
                    + pathSumMustChooseOne(root.left, 0) + pathSumMustChooseOne(root.right, 0);
        } else if (root == null) {
            return 0;
        }
        int res = 0;
        res += pathSumMustChooseOne(root.left, sum - root.val);
        res += pathSumMustChooseOne(root.right, sum - root.val);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    public int pathSumMustChooseOne(TreeNode root, int sum) {
        if (root != null && sum == root.val) {
            return 1 + pathSumMustChooseOne(root.left, 0) + pathSumMustChooseOne(root.right, 0);
        } else if (root == null) {
            return 0;
        }
        int res = 0;
        res += pathSumMustChooseOne(root.left, sum - root.val);
        res += pathSumMustChooseOne(root.right, sum - root.val);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(-1);
        root.right.left = new TreeNode(-2);
        System.out.println(new PathSumIII().pathSum(root, -2));
    }
}
