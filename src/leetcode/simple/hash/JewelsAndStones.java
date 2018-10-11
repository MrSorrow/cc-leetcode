package leetcode.simple.hash;

/**
 * @description: 771. 宝石与石头
 * @sse: <a>https://leetcode-cn.com/problems/jewels-and-stones/</a>
 * @author: guoping wang
 * @date: 2018/10/11 9:17
 * @project: cc-leetcode
 */
public class JewelsAndStones {

    /**
     * 个人常规解法：数组计数问题
     * 18ms 66.20%
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int[] counter = new int[58];
        for (char j : J.toCharArray()) {
            counter[j - 'A']++;
        }

        int res = 0;
        for (char s : S.toCharArray()) {
            if (counter[s - 'A'] > 0) {
                res++;
            }
        }

        return res;
    }

    /**
     * 直接去indexOf J，看看存不存在
     * 13ms 95.34%
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStonesBetter(String J, String S) {

        int res = 0;
        for (char s : S.toCharArray()) {
            if (J.indexOf(s) > -1) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
