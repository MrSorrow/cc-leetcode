package leetcode.simple.string;

/**
 * @description: 686. 重复叠加字符串匹配
 * @link: <a>https://leetcode-cn.com/problems/repeated-string-match/</a>
 * @author: guoping wang
 * @date: 2018/9/30 9:53
 * @project: cc-leetcode
 */
public class RepeatedStringMatch {

    public static void main(String[] args) {
        System.out.println(new RepeatedStringMatch().repeatedStringMatchBest("abc", "cabcabca"));
    }

    /**
     * 个人常规解法：分情况分析并进行判断
     * 205ms 60.89%
     * @param A
     * @param B
     * @return
     */
    public int repeatedStringMatch(String A, String B) {
        if (A.length() >= B.length()) {
            if (!A.contains(B)) {
                String C = A + A;
                if (!C.contains(B)) {
                    return -1;
                } else {
                    return 2;
                }
            } else {
                return 1;
            }
        } else {
            int repeat = 1;
            // 这部分主要进行减重，用双A可以省去判断B中去除连续的A
            while (B.contains(A + A)) {
                int first = B.indexOf(A + A);
                String C = B.substring(0, first) + B.substring(first + 2 * A.length());
                if (!C.contains(A + A)) {
                    break;
                }
                B = C;
                repeat += 2;
            }
            String D = A;
            while (D.length() < 3 * B.length()) {
                if (D.contains(B)) {
                    return repeat;
                }
                repeat++;
                D += A;
            }
            return -1;
        }
    }

    /**
     * 最简单快速的算法竟然就是直接暴力一点直接去重复试
     * 151ms 79.56%
     * @param A
     * @param B
     * @return
     */
    public int repeatedStringMatchBest(String A, String B) {
        int repeat = 1;
        StringBuilder sb = new StringBuilder(A);
        while (sb.length() < B.length()) {
            sb.append(A);
            repeat++;
        }
        if (sb.indexOf(B) != -1) {
            return repeat;
        }
        sb.append(A);
        repeat++;
        if (sb.indexOf(B) != -1) {
            return repeat;
        }
        return -1;
    }
}
