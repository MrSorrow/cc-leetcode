package leetcode.mid;

import java.util.*;

/**
 * @description: 508. 出现次数最多的子树元素和
 * @see: <a>https://leetcode-cn.com/problems/most-frequent-subtree-sum/</a>
 * @author: guoping wang
 * @date: 2019/4/1 11:06
 * @project: cc-leetcode
 */
public class MostFrequentSubtreeSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 个人常规解法：由下至上更新树的节点值
     * 20ms 47.77%
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        TreeMap<Integer, Integer> counter = new TreeMap<>();
        updateAndCountTree(root, counter);
        if (counter.size() == 0) return new int[0];

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(counter.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int length = 0;
        for (int i = 0, first = list.get(0).getValue(); i < list.size(); i++) {
            if (list.get(i).getValue() == first) length++;
            else break;
        }
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }

    private void updateAndCountTree(TreeNode root, TreeMap<Integer, Integer> counter) {
        if (root == null) return;
        updateAndCountTree(root.left, counter);
        updateAndCountTree(root.right, counter);
        root.val = root.val + (root.left == null ? 0 : root.left.val) + (root.right == null ? 0 : root.right.val);
        if (counter.containsKey(root.val)) {
            counter.put(root.val, counter.get(root.val) + 1);
        } else {
            counter.put(root.val, 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        new MostFrequentSubtreeSum().findFrequentTreeSum(root);
    }
}
