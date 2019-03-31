package leetcode.mid;

/**
 * @description: 449. 序列化和反序列化二叉搜索树
 * @see: <a>https://leetcode-cn.com/problems/serialize-and-deserialize-bst/</a>
 * @author: guoping wang
 * @date: 2019/3/30 20:31
 * @project: cc-leetcode
 */
public class SerializeAndDeserializeBst {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class Codec {

        /**
         * 没有利用二叉搜索树的性质，一种通解通法
         * 格式：12[左子树字符串,右子树字符串]
         * 38ms 18.37%
         * @param root
         * @return
         */
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder(root.val + "[");
            sb.append(serialize(root.left));
            sb.append(",");
            sb.append(serialize(root.right));
            sb.append("]");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.equals("")) return null;
            int startIndex = data.indexOf("[");
            int endIndex = data.lastIndexOf("]");
            // 寻找逗号分隔符
            int midIndex = startIndex + 1;
            if (data.charAt(startIndex + 1) != ',') {
                // 左子树有节点时
                boolean hasBrackets = false;
                for (int i = startIndex + 1, count = 0; i < endIndex; i++) {
                    if (data.charAt(i) == '[') {count++; hasBrackets = true;}
                    else if (data.charAt(i) == ']') count--;
                    if (count == 0 && hasBrackets) {midIndex = i + 1; break;}
                }
            }

            TreeNode node = new TreeNode(Integer.valueOf(data.substring(0, startIndex)));
            node.left = deserialize(data.substring(startIndex + 1, midIndex));
            node.right = deserialize(data.substring(midIndex + 1, endIndex));
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new Codec().deserialize("21[22[16[,],],14[12[,],32[,]]]");
        System.out.println(new Codec().serialize(tree));
    }

}
