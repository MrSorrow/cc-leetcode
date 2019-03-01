package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 129. 求根到叶子节点数字之和
 * @see: <a>https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/</a>
 * @author: guoping wang
 * @date: 2019/2/27 21:58
 * @project: cc-leetcode
 */
public class SumRootToLeafNumbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     * 个人常规解法：递归遍历
     * 3ms 22.31%
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        List<String> res = travel(root);
        int num = 0;
        for (String s : res) {
            if(!"".equals(s))
                num += Integer.valueOf(s);
        }
        return num;
    }

    private List<String> travel(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root != null && root.left == null && root.right == null) {
            res.add(root.val+"");
            return res;
        }
        List<String> left = travel(root.left);
        List<String> right = travel(root.right);
        for (String s : left) {
            res.add(root.val + s);
        }
        for (String s : right) {
            res.add(root.val + s);
        }
        return res;
    }

    int sum = 0;
    /**
     * 受到其他解法启发，其实直接DFS可以解决
     * 0ms 100%
     * @param root
     * @return
     */
    public int sumNumbersDirect(TreeNode root) {
        if(root == null)
            return 0;
        sumNumbersDirect(root, root.val);
        return sum;
    }

    public void sumNumbersDirect(TreeNode root, int num) {
        if (root.left != null) {
            sumNumbersDirect(root.left, 10 * num + root.left.val);
        }
        if (root.right != null) {
            sumNumbersDirect(root.right, 10 * num + root.right.val);
        }
        if (root.left == null && root.right == null) {
            sum += num;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new SumRootToLeafNumbers().sumNumbersDirect(root));
    }
}
