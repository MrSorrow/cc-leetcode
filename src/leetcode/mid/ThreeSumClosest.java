package leetcode.mid;

import java.util.Arrays;

/**
 * @description: 16. 最接近的三数之和
 * @see: <a>https://leetcode-cn.com/problems/3sum-closest/</a>
 * @author: guoping wang
 * @date: 2018/12/27 8:47
 * @project: cc-leetcode
 */
public class ThreeSumClosest {

    /**
     * 个人常规解法：从三数之和来的思路，遍历与剪枝
     * 50ms 18.51%
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sub = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i + 3 < nums.length && nums[i] == nums[i + 3]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                int k = (j + nums.length) / 2;
                if (nums[k] + nums[i] + nums[j] == target) {
                    return target;
                } else if (nums[k] + nums[i] + nums[j] < target) {
                    for (; k < nums.length; k++) {
                        if (Math.abs(nums[k] + nums[i] + nums[j] - target) < sub) {
                            sub = Math.abs(nums[k] + nums[i] + nums[j] - target);
                            sum = nums[k] + nums[i] + nums[j];
                        }
                        if (nums[k] + nums[i] + nums[j] > target) {
                            break;
                        }
                    }
                } else {
                    for (; k > j; k--) {
                        if (Math.abs(nums[k] + nums[i] + nums[j] - target) < sub) {
                            sub = Math.abs(nums[k] + nums[i] + nums[j] - target);
                            sum = nums[k] + nums[i] + nums[j];
                        }
                        if (nums[k] + nums[i] + nums[j] < target) {
                            break;
                        }
                    }
                }
            }
        }
        return sum;
    }

    /**
     * 参考解法：外层循环不断遍历，内两层循环则可以合并成一次遍历
     * 22ms 71.86%
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosestBetter(int[] nums, int target) {
        Arrays.sort(nums);
        int sub = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i + 3 < nums.length && nums[i] == nums[i + 3]) {
                continue;
            }

            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (Math.abs(nums[i] + nums[j] + nums[k] - target) < sub) {
                    sub = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    sum = nums[i] + nums[j] + nums[k];
                }
                if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else {
                    return target;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }
}
