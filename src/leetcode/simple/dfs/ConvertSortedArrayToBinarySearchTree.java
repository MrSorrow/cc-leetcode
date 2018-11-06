package leetcode.simple.dfs;

/**
 * @description: 108. 将有序数组转换为二叉搜索树
 * @see: <a>https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/6 19:24
 * @project: cc-leetcode
 */
public class ConvertSortedArrayToBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：取中间一个数，作为根节点，递归解决
     * 1ms 99.47%
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if (mid < start || mid > end) return null;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);
        return node;
    }
}
