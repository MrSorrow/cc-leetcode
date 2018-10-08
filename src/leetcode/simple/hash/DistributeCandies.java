package leetcode.simple.hash;

/**
 * @description: 575. 分糖果
 * @see: <a>https://leetcode-cn.com/problems/distribute-candies/</a>
 * @author: guoping wang
 * @date: 2018/10/8 10:42
 * @project: cc-leetcode
 */
public class DistributeCandies {

    /**
     * 个人常规解法：计数多少种糖果
     * 75ms 80.17%
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        int[] counter = new int[200001];

        for (int candy : candies) {
            counter[candy + 100000]++;
        }

        int res = 0;
        for (int i : counter) {
            if (i > 0) {
                res++;
            }
        }

        return res > candies.length / 2 ? candies.length / 2 : res;
    }

    /**
     * 个人常规解法：计数多少种糖果，优化写法
     * 39ms 98.26%
     * @param candies
     * @return
     */
    public int distributeCandiesBetter(int[] candies) {
        boolean[] counter = new boolean[200001];
        int res = 0;
        for (int candy : candies) {
            if (!counter[candy + 100000]) {
                counter[candy + 100000] = true;
                res++;
            }
        }
        return res > candies.length / 2 ? candies.length / 2 : res;
    }
}
