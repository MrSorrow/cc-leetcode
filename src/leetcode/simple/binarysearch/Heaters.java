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
     * 个人常规解法：二分法尝试找出最小的能覆盖的解
     * 超时 20/30
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int start = 0;
        int end = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (canAllOveride(houses, heaters, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    /**
     * 判断已给的半径是否能够全覆盖
     * @param houses
     * @param heaters
     * @param radius
     * @return
     */
    public boolean canAllOveride(int[] houses, int[] heaters, int radius) {
        int[] flag = new int[houses.length];
        for (int j = 0; j < houses.length; j++) {
            if (flag[j] == 0) {
                for (int i = 0; i < heaters.length; i++) {
                    if (houses[j] <= heaters[i] + radius && houses[j] >= heaters[i] - radius) {
                        flag[j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] heaters = {823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612};
        int[] houses = {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};
        System.out.println(new Heaters().findRadius(houses, heaters));
    }
}
