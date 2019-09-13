package sword2offer;

import java.util.Arrays;

/**
 * @description: 7. 重建二叉树
 * @see: <a>https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/9/13 2:24 PM
 * @project: cc-leetcode
 */
public class ReConstructBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 递归写法
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }

        // 先找出根元素
        TreeNode root = new TreeNode(pre[0]);

        int index = 0;
        while (index < in.length) {
            if (in[index] == pre[0]) {
                break;
            }
            index++;
        }

        // 将左右子节点连上
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(in, 0, index));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(in, index + 1, in.length));
        return root;
    }
}
