package leetcode.simple.greedy;

import java.util.Arrays;

/**
 * @description: 455. 分发饼干
 * @see: <a>https://leetcode-cn.com/problems/assign-cookies/</a>
 * @author: guoping wang
 * @date: 2018/12/10 9:32
 * @project: cc-leetcode
 */
public class AssignCookies {

    /**
     * 排序好，两个指针进行对两个数组进行移动
     * 13ms 99.05%
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int indexG = 0, indexS = 0, count = 0;

        // while条件其实是判空的
        while (indexG < g.length && indexS < s.length) {
            if (s[indexS] >= g[indexG]) {
                count++;
                indexG++;
                indexS++;
            } else {
                indexS++;
            }

            // 循环退出条件
            if (indexG >= g.length || indexS >= s.length) {
                break;
            }
        }

        return count;
    }
}
