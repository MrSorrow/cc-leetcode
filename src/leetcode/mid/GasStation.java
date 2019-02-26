package leetcode.mid;

/**
 * @description: 134. 加油站
 * @see: <a>https://leetcode-cn.com/problems/gas-station/</a>
 * @author: guoping wang
 * @date: 2019/2/25 21:59
 * @project: cc-leetcode
 */
public class GasStation {

    /**
     * 个人常规解法：直接暴力求解，重要的是剪枝
     * 181ms 8.55%  优化后 2ms 46.22%
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 将gas变为每一站的盈亏
        for (int i = 0; i < gas.length; i++) {
            gas[i] = gas[i] - cost[i];
        }
        // 利用cost记录每经过一站的记录
        // 外层循环表示尝试哪一站出发
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < 0) continue;

            int start = i;
            for (; start < gas.length + i; start++) {
                if (start == i) {
                    cost[start] = gas[start];
                } else {
                    cost[start % gas.length] = gas[start % gas.length] + cost[(start - 1) % gas.length];
                }

                if (cost[start % gas.length] < 0) {
                    i = start;  // 优化方法
                    break;
                }
            }

            if (start == gas.length + i) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] cost = {3,4,5,1,2};
        int[] gas = {1,2,3,4,5};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }
}
