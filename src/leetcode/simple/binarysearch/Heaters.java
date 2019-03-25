package leetcode.simple.binarysearch;

import java.util.Arrays;

/**
 * @description: 475. 供暖器
 * @link: <a>https://leetcode-cn.com/problems/heaters/</a>
 * @author: guoping wang
 * @date: 2018/9/23 9:23
 * @project: cc-leetcode
 */
public class Heaters {

    /**
     * 个人常规解法：遍历每一个房屋，用其最近的供暖器进行供暖，计算其半径
     * 22ms 82.24%
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int max = 0;
        int heatIndex = 0;
        for (int i = 0; i < houses.length; i++) {
            // 寻找最近的供暖器
            for (; heatIndex < heaters.length && heaters[heatIndex] < houses[i]; ) {
                // 不断递增，可能出现直接返回（房子在左，炉子在右），也可能到数组最后一个（房子在右，炉子在左）
                if(heatIndex < heaters.length - 1) heatIndex++;
                else break;
            }
            int radius = 0;
            if (houses[i] < heaters[heatIndex]) {
                // 房子在左，炉子在右
                radius = heatIndex > 0 ? Math.min(houses[i] - heaters[heatIndex - 1], heaters[heatIndex] - houses[i]) : heaters[heatIndex] - houses[i];
            } else if (houses[i] > heaters[heatIndex]) {
                // 房子在右，炉子在左
                radius = heatIndex < heaters.length - 1 ? Math.min(heaters[heatIndex + 1] - houses[i], houses[i] - heaters[heatIndex]) : houses[i] - heaters[heatIndex];
            }
            if (max < radius) max = radius;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        System.out.println(new Heaters().findRadius(houses, heaters));
    }
}
