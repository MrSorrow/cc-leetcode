package leetcode.mid;

/**
 * @description: 106. 从中序与后序遍历序列构造二叉树
 * @see: <a>https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/</a>
 * @author: guoping wang
 * @date: 2019/3/19 20:26
 * @project: cc-leetcode
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归解法，后序的最后一个节点就是根节点，然后在中序中寻找划分出左子树和右子树
     * 19ms 67.72%
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) return null;

        // 寻找中序中的根节点位置
        int index = iStart;
        for (; index <= iEnd; index++) {
            if (inorder[index] == postorder[pEnd])
                break;
        }

        // 构造树
        TreeNode root = new TreeNode(postorder[pEnd]);
        root.left = buildTree(inorder, iStart, index - 1, postorder, pStart, pStart - iStart + index - 1);
        root.right = buildTree(inorder, index + 1, iEnd, postorder, pStart - iStart + index, pEnd - 1);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(inorder, postorder);
        System.out.println(root);
    }
}
