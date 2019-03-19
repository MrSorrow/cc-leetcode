package leetcode.mid;

/**
 * @description: 105. 从前序与中序遍历序列构造二叉树
 * @see: <a>https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/</a>
 * @author: guoping wang
 * @date: 2019/3/19 20:04
 * @project: cc-leetcode
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归解法，前序可以知道第一个节点为根节点，然后去中序得到左子树和右子树分别包含哪些元素，继续递归处理
     * 26ms 55.18%
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) return null;

        // 寻找到根节点元素位置
        int index = iStart;
        for (; index <= iEnd; index++) {
            if (inorder[index] == preorder[pStart])
                break;
        }

        // 构建树，并递归构造
        TreeNode root = new TreeNode(preorder[pStart]);
        root.left = buildTree(preorder, pStart + 1,index - iStart + pStart, inorder, iStart, index - 1);
        root.right = buildTree(preorder, index - iStart + pStart + 1, pEnd, inorder, index + 1, iEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);
        System.out.println(root);
    }
}
