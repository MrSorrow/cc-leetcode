package leetcode.simple.other;

/**
 * @description: 458. 可怜的小猪
 * @see: <a>https://leetcode-cn.com/problems/poor-pigs/</a>
 * @author: guoping wang
 * @date: 2018/12/12 14:31
 * @project: cc-leetcode
 */
public class PoorPigs {

    /**
     * minutesToTest/minutesToDie + 1 表示进制
     * 猪的个数表示位数
     * 求的是几位的几进制数能够覆盖buckets，需要 (minutesToTest/minutesToDie + 1)^pigs >= buckets
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets) / Math.log(minutesToTest/minutesToDie + 1));
    }
}
