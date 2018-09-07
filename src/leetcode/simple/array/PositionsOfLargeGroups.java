package leetcode.simple.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 830. 较大分组的位置
 * @link: <a>https://leetcode-cn.com/problems/positions-of-large-groups/description/</a>
 * @author: guoping wang
 * @date: 2018/9/7 22:07
 * @project: cc-leetcode
 */
public class PositionsOfLargeGroups {

    public static void main(String[] args) {

        String S = "aa";
        new PositionsOfLargeGroups().largeGroupPositions(S);

    }

    /**
     * 个人常规解法：指针向后遍历，记录长度
     * 20ms 42.57%
     * @param S
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int index = 0;

        while (index < S.length() - 1) {
            int record = index;
            while (S.charAt(index) == S.charAt(record)) {
                index++;
                if (index > S.length() - 1) {
                    break;
                }
            }
            if (index - record >= 3) {
                List<Integer> list = new ArrayList<>(2);
                list.add(record);
                list.add(index - 1);
                res.add(list);
            }
        }

        return res;
    }
}
