package leetcode.simple.array;

/**
 * @description: 605. 种花问题
 * @link: <a>https://leetcode-cn.com/problems/can-place-flowers/description/</a>
 * @author: guoping wang
 * @date: 2018/8/30 14:05
 * @project: cc-leetcode
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int n = 2;
        int[] nums = {1, 0, 0, 0, 1};
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(nums, n));
    }

    /**
     * 个人常规解法：见缝插针，不管优化，从头至尾先后见到空位就插入
     * 13ms 55.21%
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            // 数组中间需要判断左右两边都为0，才能插入
            if (i > 0 && i < flowerbed.length - 1) {
                if (flowerbed[i - 1] + flowerbed[i] + flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (i == 0 && i < flowerbed.length - 1) {
                // 第一个元素
                if (flowerbed[i] + flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (i > 0 && i == flowerbed.length - 1) {
                // 最后一个元素
                if (flowerbed[i - 1] + flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else {
                // 只有一个元素
                if (flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }

            if (n <= 0) {
                break;
            }
        }

        return n <= 0 ? true : false;
    }
}
