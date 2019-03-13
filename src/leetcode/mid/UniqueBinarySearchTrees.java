package leetcode.mid;

/**
 * @description: 96. 不同的二叉搜索树
 * @see: <a>https://leetcode-cn.com/problems/unique-binary-search-trees/</a>
 * @author: guoping wang
 * @date: 2019/3/13 9:14
 * @project: cc-leetcode
 */
public class UniqueBinarySearchTrees {

    /**
     * 参考解法：当根节点为1时，左子树节点有1-1个，右节点个数为n-1个；
     *          当根节点为2时，左子树节点有2-1个，右节点个数为n-2个；
     *          当根节点为3时，左子树节点有3-1个，右节点个数为n-3个；
     *          ···
     *          当根节点为n时，左子树节点有n-1个，右节点个数为 0 个；
     * 0ms 100%
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] record = new int[n + 1];
        record[0] = 1;
        record[1] = 1;
        if (n > 3)
            record[2] = 2;

        // 从第三个节点开始递推
        for (int i = 3; i <= n; i++) {
            // 顶点是1,2,3...i的情况
            for (int j = 1; j <= i; j++) {
                record[i] += record[j - 1] * record[i - j];
            }
        }
        return record[n];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(2));
    }
}
