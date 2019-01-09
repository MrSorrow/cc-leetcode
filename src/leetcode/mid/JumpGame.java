package leetcode.mid;

/**
 * @description: 55. 跳跃游戏
 * @see: <a>https://leetcode-cn.com/problems/jump-game/</a>
 * @author: guoping wang
 * @date: 2019/1/9 14:37
 * @project: cc-leetcode
 */
public class JumpGame {

    /**
     * 个人常规解法：递归算法，超时
     * 74/75
     * @param nums
     * @return
     */
    public boolean canJumpCir(int[] nums) {
        return canJump(nums, 0);
    }

    private boolean canJump(int[] nums, int start) {
        if (start == nums.length - 1) return true;
        for (int i = 1; i <= nums[start]; i++) {
            if (canJump(nums, start + i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 个人常规解法：动态规划，倒序的统计能否成功
     * 431ms 6.08%
     * @param nums
     * @return
     */
    public boolean canJumpDP(int[] nums) {
        boolean[] flags = new boolean[nums.length];
        flags[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums.length - 1 - i) {
                flags[i] = true;
            } else {
                for (int j = 1; j + i < nums.length && j <= nums[i]; j++) {
                    if (flags[j + i]) {
                        flags[i] = true;
                        break;
                    }
                }
            }
        }
        return flags[0];
    }

    /**
     * 参考解法：仔细考虑题意，其实发现只要含有0才有可能是false，只有无论怎么走都会跳到0这个点，才false
     * 5ms 99.47%
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                int curr = 1;
                for (; curr <= i; curr++) {
                    if (nums[i - curr] > curr) break;
                }
                if (curr == i + 1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new JumpGame().canJumpDP(nums));
    }
}
