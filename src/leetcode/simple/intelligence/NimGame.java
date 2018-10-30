package leetcode.simple.intelligence;

/**
 * @description: 292.Nim游戏
 * @see: <a>https://leetcode-cn.com/problems/nim-game/</a>
 * @author: guoping wang
 * @date: 2018/10/30 10:13
 * @project: cc-leetcode
 */
public class NimGame {

    /**
     * 个人常规解法：递归遍历所有情况
     * 方法栈溢出
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return canWinNim(n, true);
    }

    public boolean canWinNim(int n, boolean meTurn) {
        if (n <= 3 && meTurn) {
            return true;
        } else if (n <= 3 && !meTurn) {
            return false;
        } else {
            return canWinNim(n - 1, !meTurn) || canWinNim(n - 2, !meTurn) || canWinNim(n - 3, !meTurn);
        }
    }

    /**
     * 个人常规解法：脑经急转弯，除以4是否能有余数，因为每一个来回，先手都可以弥补后手达到一轮得到4
     * 0ms 100%
     * @param n
     * @return
     */
    public boolean canWinNimIntellijence(int n) {
        return n % 4 > 0;
    }

    public static void main(String[] args) {
        System.out.println(new NimGame().canWinNim(6));
    }
}
