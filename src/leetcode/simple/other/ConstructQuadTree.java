package leetcode.simple.other;

/**
 * @description: 427. 建立四叉树
 * @see: <a>https://leetcode-cn.com/problems/construct-quad-tree/</a>
 * @author: guoping wang
 * @date: 2018/12/12 10:42
 * @project: cc-leetcode
 */
public class ConstructQuadTree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    /**
     * 个人常规解法：递归算法
     * 5ms 52.45%
     * @param grid
     * @return
     */
    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length - 1, 0, grid.length - 1);
    }

    private Node construct(int[][] grid, int startX, int endX, int startY, int endY) {

        boolean isLeaf = true;
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (grid[i][j] != grid[startX][startY]) {
                    isLeaf = false;
                    break;
                }
            }
            if (!isLeaf) {
                break;
            }
        }

        if (isLeaf) {
            return grid[startX][startY] == 0 ? new Node(false, true, null, null, null, null)
                    : new Node(true, true, null, null, null, null);
        } else {
            // 非叶子节点
            return new Node(false, false,
                    construct(grid, startX, (startX + endX) / 2, startY, (startY + endY) / 2),
                    construct(grid, startX, (startX + endX) / 2, (startY + endY) / 2 + 1, endY),
                    construct(grid, (startX + endX) / 2 + 1, endX, startY, (startY + endY) / 2),
                    construct(grid, (startX + endX) / 2 + 1, endX, (startY + endY) / 2 + 1, endY));
        }
    }

    public static void main(String[] args) {
        int[][] grids = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
        new ConstructQuadTree().construct(grids);
    }
}
