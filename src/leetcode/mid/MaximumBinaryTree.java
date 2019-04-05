package leetcode.mid;

/**
 * @description: 654. 最大二叉树
 * @see: <a>https://leetcode-cn.com/problems/maximum-binary-tree/</a>
 * @author: guoping wang
 * @date: 2019/4/5 18:40
 * @project: cc-leetcode
 */
public class MaximumBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归
     * 7ms 100%
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) return null;

        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[index])
                index = i;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(nums, start, index - 1);
        root.right = constructMaximumBinaryTree(nums, index + 1, end);
        return root;
    }
}
