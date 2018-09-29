package leetcode.simple.string;

/**
 * @description: 657. 机器人能否返回原点
 * @link: <a>https://leetcode-cn.com/problems/robot-return-to-origin/</a>
 * @author: guoping wang
 * @date: 2018/9/29 10:51
 * @project: cc-leetcode
 */
public class RobotReturnToOrigin {

    /**
     * 个人常规解法：对四个方向进行计数，判断是否相等
     * 20ms 37.35%
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        int[] counter = new int[4];
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R': counter[0]++; break;
                case 'L': counter[1]++; break;
                case 'U': counter[2]++; break;
                case 'D': counter[3]++; break;
            }
        }
        return  (counter[0] == counter[1] && counter[2] == counter[3]);
    }

    /**
     * 优化写法：利用大数组计数
     * 6ms 100%
     * @param moves
     * @return
     */
    public boolean judgeCircleBetter(String moves) {
        int m[] = new int[86];
        for (char c : moves.toCharArray()) {
            m[c]++;
        }
        return m['L'] == m['R'] && m['U'] == m['D'];
    }
}
