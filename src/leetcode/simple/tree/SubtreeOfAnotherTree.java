package leetcode.simple.tree;

/**
 * @description: 572.另一个树的子树
 * @see: <a>https://leetcode-cn.com/problems/subtree-of-another-tree/</a>
 * @author: guoping wang
 * @date: 2018/11/29 23:02
 * @project: cc-leetcode
 */
public class SubtreeOfAnotherTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：中序遍历后查看字符串是否包含
     * 不通过 175/176 出错示例 [12] [2]
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtreeWrong(TreeNode s, TreeNode t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder t1 = new StringBuilder();
        getStringOfTree(s, s1);
        getStringOfTree(t, t1);
        if (s1.indexOf(t1.toString()) != - 1) {
            return true;
        }
        return false;
    }

    private void getStringOfTree(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("a");
            return;
        }
        builder.append(node.val);
        getStringOfTree(node.left, builder);
        getStringOfTree(node.right, builder);
    }


    /**
     * 个人常规解法：只能递归进行判断是否是相同子树了
     * 14ms 98.86%
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (check(s, t)) {
            return true;
        }
        if (s != null) {
            if (isSubtree(s.left, t)) {
                return true;
            }
            if (isSubtree(s.right, t)) {
                return true;
            }
        }
        return false;
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t != null) {
            return false;
        } else if (s == null && t == null) {
            return true;
        } else if (t == null && s != null) {
            return false;
        }

        boolean mid = s.val == t.val;
        if (mid) {
            boolean left = check(s.left, t.left);
            boolean right = check(s.right, t.right);
            return left && right;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.left.left = new TreeNode(0);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        System.out.println(new SubtreeOfAnotherTree().isSubtree(s, t));
    }
}
