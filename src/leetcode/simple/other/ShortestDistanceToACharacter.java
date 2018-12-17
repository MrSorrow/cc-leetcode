package leetcode.simple.other;

/**
 * @description: 821. 字符的最短距离
 * @see: <a>https://leetcode-cn.com/problems/shortest-distance-to-a-character/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/12/17 下午10:24
 * @project: cc-leetcode
 */
public class ShortestDistanceToACharacter {

    /**
     * 个人常规解法：正向反向都来一遍
     * 5ms 98.74%
     * @param S
     * @param C
     * @return
     */
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        // 正向来一遍
        for (int i = 0, dis = Integer.MAX_VALUE; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                dis = 0;
            } else {
                if (dis != Integer.MAX_VALUE)
                    dis++;
            }
            res[i] = dis;
        }
        // 反向来一遍
        for (int i = S.length() - 1, dis = Integer.MAX_VALUE; i >= 0; i--) {
            if (S.charAt(i) == C) {
                dis = 0;
            } else {
                if (dis != Integer.MAX_VALUE)
                    dis++;
            }
            if (dis < res[i])
                res[i] = dis;
        }
        return res;
    }
}
