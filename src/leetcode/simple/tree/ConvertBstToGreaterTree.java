package leetcode.simple.tree;


/**
 * @description: 538. 把二叉搜索树转换为累加树
 * @see: <a>https://leetcode-cn.com/problems/convert-bst-to-greater-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/28 22:29
 * @project: cc-leetcode
 */
public class ConvertBstToGreaterTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归解法，其实就是先求所有节点总和，然后进行减去当前结点的值，注意更新总和
     * 10ms 96.54%
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        int sum = getSumOfTree(root);
        updateTreeVal(root, sum);
        return root;
    }

    public int getSumOfTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + getSumOfTree(node.left) + getSumOfTree(node.right);
    }

    /**
     * 核心实现过程
     * @param node
     * @param value
     * @return
     */
    public int updateTreeVal(TreeNode node, int value) {
        if (node == null) return value;
        int nextValue = updateTreeVal(node.left, value);
        int temp = node.val;
        node.val = nextValue;
        nextValue -= temp;
        return updateTreeVal(node.right, nextValue);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        TreeNode treeNode = new ConvertBstToGreaterTree().convertBST(root);
    }

}
