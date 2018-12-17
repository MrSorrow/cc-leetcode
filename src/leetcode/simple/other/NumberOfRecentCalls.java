package leetcode.simple.other;

/**
 * @description: 933. 最近的请求次数
 * @see: <a>https://leetcode-cn.com/problems/number-of-recent-calls/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/12/17 下午9:49
 * @project: cc-leetcode
 */
public class NumberOfRecentCalls {

    static class RecentCounter {

        private int[] records;
        private int[] res;
        private int times;
        private int lastStart;

        public RecentCounter() {
            records = new int[10001];
            res = new int[10001];
        }

        /**
         * 个人常规解法：用数组记录下每一次请求的时间以及结果
         * 112ms 96.72%
         * @param t
         * @return
         */
        public int ping(int t) {
            // 获取上一次的ping结果
            int lastPing = res[times];
            // 记录时间
            records[++times] = t;

            if (lastStart == 0)
                lastStart = 1;
            else {
                while (t - records[lastStart] > 3000) {
                    lastPing--;
                    lastStart++;
                }
            }
            res[times] = ++lastPing;
            return lastPing;
        }
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1178));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }
}
