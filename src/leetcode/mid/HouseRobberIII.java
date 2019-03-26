package leetcode.mid;

/**
 * @description: 337. 打家劫舍 III
 * @see: <a>https://leetcode-cn.com/problems/house-robber-iii/</a>
 * @author: guoping wang
 * @date: 2019/3/26 16:12
 * @project: cc-leetcode
 */
public class HouseRobberIII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归解法，当前根节点选或者不选，主要因为重复解决子问题，所以很慢
     * 928ms 28.75%
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int notChooseRoot = rob(root.left) + rob(root.right);
        int chooseRoot = root.val;
        if (root.left != null) chooseRoot += (rob(root.left.left) + rob(root.left.right));
        if (root.right != null) chooseRoot += (rob(root.right.left) + rob(root.right.right));
        return Math.max(chooseRoot, notChooseRoot);
    }

    /**
     * 动态规划解法：每个节点都有选与不选两种情况，记录下自己的选与不选的结果值，这样上层节点可以利用记录值计算结果，其实重点是如何实现这个动归过程
     * 2ms 82.19%
     * @param root
     * @return
     */
    public int[] robDp(TreeNode root) {
        if (root == null) return new int[2]; // 无论选与不选，都是0

        int[] res = new int[2];  // 0保存未选择root的，1保存选择root的
        int[] left = robDp(root.left);
        int[] right = robDp(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);  // 当前节点不抢的最大值
        res[1] = root.val + left[0] + right[0];  // 当前节点抢的最大值
        return res;
    }

    public int robDpRes(TreeNode root) {
        int[] res = robDp(root);
        return Math.max(res[0], res[1]);
    }
}
