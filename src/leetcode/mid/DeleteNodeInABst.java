package leetcode.mid;

/**
 * @description: 450. 删除二叉搜索树中的节点
 * @see: <a>https://leetcode-cn.com/problems/delete-node-in-a-bst/</a>
 * @author: guoping wang
 * @date: 2019/4/1 9:37
 * @project: cc-leetcode
 */
public class DeleteNodeInABst {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：要删除节点，首先找到节点，然后将左子树的最右节点替换，或者右子树的最小节点替换即可
     * 1ms 100%
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            // 找到节点

            TreeNode left = root.left;
            // 删除节点
            if (root.right == null) {
                root.left = null;  // 断开连接，help GC
                root = left;
            } else {
                // 用右子树最小的节点来替换
                TreeNode[] nodes = deleteAndReturnMin(root.right);
                root = nodes[0];
                root.right = nodes[1];
                root.left = left;
            }
        } else if (root.val < key) {
            // 右子树递归
            root.right = deleteNode(root.right, key);
        } else {
            // 左子树递归
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    /**
     * 返回删除的节点和删除后的树根节点
     * @param root
     * @return
     */
    private TreeNode[] deleteAndReturnMin(TreeNode root) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            // 空
        }
        else if (root.left == null) {
            res[1] = root.right;
            root.right = null;
            res[0] = root;
        } else {
            TreeNode[] nodes = deleteAndReturnMin(root.left);
            root.left = nodes[1];  // 连接新的树
            res[0] = nodes[0];
            res[1] = root;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        new DeleteNodeInABst().deleteNode(root, 5);
    }
}
