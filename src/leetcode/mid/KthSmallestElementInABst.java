package leetcode.mid;

/**
 * @description: 230. 二叉搜索树中第K小的元素
 * @see: <a>https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/</a>
 * @author: guoping wang
 * @date: 2019/3/23 21:47
 * @project: cc-leetcode
 */
public class KthSmallestElementInABst {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：统计左子树个数，判断在哪
     * 1ms 90.49%
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        int l = getNum(root.left);
        if (l + 1 == k) return root.val;
        else if (l >= k) return kthSmallest(root.left, k);
        else return kthSmallest(root.right, k - l - 1);
    }

    private int getNum(TreeNode root) {
        if (root == null) return 0;
        return 1 + getNum(root.left) + getNum(root.right);
    }
}
