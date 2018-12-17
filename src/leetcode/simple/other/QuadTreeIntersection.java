package leetcode.simple.other;

/**
 * @description: 558. 四叉树交集
 * @see: <a>https://leetcode-cn.com/problems/quad-tree-intersection/</a>
 * @author: guoping wang
 * @date: 2018/12/17 9:06
 * @project: cc-leetcode
 */
public class QuadTreeIntersection {

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
     * 个人常规解法：递归解法，需要注意合并节点为叶子节点等
     * 6ms 44.93%
     * @param quadTree1
     * @param quadTree2
     * @return
     */
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1 == null) return quadTree2;
        if (quadTree2 == null) return quadTree1;

        // 两者都不为空，分情况讨论
        if (quadTree1.val && quadTree1.isLeaf) {
            return quadTree1;
        } else if (quadTree2.val && quadTree2.isLeaf) {
            return quadTree2;
        } else if (quadTree1.isLeaf && quadTree2.isLeaf && !quadTree1.val && !quadTree2.val) {
            return quadTree1;
        }

        // 没有全为true的情况
        Node res = new Node();
        res.isLeaf = false;
        res.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        res.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        res.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        res.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        if (res.topLeft.val && res.topRight.val && res.bottomLeft.val && res.bottomRight.val
                && res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomLeft.isLeaf && res.bottomRight.isLeaf) {
            res.isLeaf = true;
            res.val = true;
            res.topLeft = null; res.topRight = null; res.bottomLeft = null; res.bottomRight = null;
        } else if (!res.topLeft.val && !res.topRight.val && !res.bottomLeft.val && !res.bottomRight.val
                && res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomLeft.isLeaf && res.bottomRight.isLeaf) {
            res.isLeaf = true;
            res.val = false;
            res.topLeft = null; res.topRight = null; res.bottomLeft = null; res.bottomRight = null;
        }

        return res;
    }
}
