package leetcode.simple.tree;

/**
 * @description: 606.根据二叉树创建字符串
 * @see: <a>https://leetcode-cn.com/problems/construct-string-from-binary-tree/</a>
 * @author: guoping wang
 * @date: 2018/12/1 10:37
 * @project: cc-leetcode
 */
public class ConstructStringFromBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：递归算法，左空节点的括号对是可以直接去掉的
     * 20ms 83.51%
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        else if (t != null && t.left == null && t.right == null) return t.val + "";
        else if (t != null && t.left == null && t.right != null) return t.val + "()(" + tree2str(t.right) + ")" ;
        else if (t != null && t.left != null && t.right == null) return t.val + "(" + tree2str(t.left) + ")" ;
        else
            return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }
}
