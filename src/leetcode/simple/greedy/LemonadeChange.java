package leetcode.simple.greedy;

/**
 * @description: 860. 柠檬水找零
 * @see: <a>https://leetcode-cn.com/problems/lemonade-change/</a>
 * @author: guoping wang
 * @date: 2018/12/11 20:26
 * @project: cc-leetcode
 */
public class LemonadeChange {

    /**
     * 个人常规解法：当收到20块钱的时候，尽量先找10块+5块
     * 5ms 98.21%
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int[] cashes = new int[3];

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                cashes[0]++;
            } else if (bills[i] == 10) {
                if (cashes[0] > 0) {
                    cashes[0]--;
                    cashes[1]++;
                }
                else {
                    return false;
                }
            } else {
                // 如果顾客付了20，有10块先找10块+5块
                if (cashes[1] > 0 && cashes[0] > 0) {
                    cashes[0]--;
                    cashes[1]--;
                    cashes[2]++;
                } else if (cashes[1] == 0 && cashes[0] >= 3) {
                    cashes[0] -= 3;
                    cashes[2]++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
