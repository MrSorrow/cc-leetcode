package leetcode.mid;

/**
 * @description: 11. 盛最多水的容器
 * @see: <a>https://leetcode-cn.com/problems/container-with-most-water/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/12/25 下午10:09
 * @project: cc-leetcode
 */
public class ContainerWithMostWater {

    /**
     * 个人常规解法：暴力解法
     * 403ms 18.68%
     * @param height
     * @return
     */
    public int maxAreaViolence(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    /**
     * 个人常规解法：优化的暴力解法，剪枝
     * 304ms 33.73%
     * @param height
     * @return
     */
    public int maxAreaViolenceBetter(int[] height) {
        int max = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if (height[j] < height[i]) {
                    max = Math.max(max, (i - j) * Math.min(height[i], height[j]));
                } else {
                    max = Math.max(max, (i - j) * Math.min(height[i], height[j]));
                    break;
                }
            }
        }
        return max;
    }

    /**
     * 官方解法：O(n) 首尾指针移动
     * 9ms 74.66%
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0, start = 0, end = height.length - 1;
        while (start <= end) {
            max = Math.max(max, (end - start) * (height[start] <= height[end] ? height[start++] : height[end--]));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }
}
