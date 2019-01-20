package leetcode.mid;

/**
 * @description: 62. 不同路径
 * @see: <a>https://leetcode-cn.com/problems/unique-paths/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/1/20 下午4:46
 * @project: cc-leetcode
 */
public class UniquePaths {

    /**
     * 个人常规解法：求组合数，C(m+n, m)
     * 0ms 100%
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int sum = m + n - 2, num = Math.min(m - 1, n - 1);
        double res = 1;
        for (int i = 0; i < num; i++) {
            res *= sum--;
        }
        for (int i = 1; i <= num; i++) {
            res /= i;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(53, 4));
    }
}
