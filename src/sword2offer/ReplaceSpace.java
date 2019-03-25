package sword2offer;

/**
 * @description: 5. 替换空格
 * @see: <a>https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423</a>
 * @author: guoping wang
 * @date: 2019/3/25 19:55
 * @project: cc-leetcode
 */
public class ReplaceSpace {

    /**
     * O(2n)的思路，先计算新的字符长度，然后从尾到头进行遍历复制替换
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') num++;
        }

        // 新字符串长度为str.length() + 2 * num
        char[] res = new char[str.length() + 2 * num];
        for (int i = str.length() - 1, index = res.length - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                res[index--] = '0';
                res[index--] = '2';
                res[index--] = '%';
            } else {
                res[index--] = str.charAt(i);
            }
        }

        return new String(res);
    }
}
