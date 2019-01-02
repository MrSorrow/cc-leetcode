package leetcode.mid;

/**
 * @description: 31. 下一个排列
 * @see: <a>https://leetcode-cn.com/problems/next-permutation/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/1/2 下午4:07
 * @project: cc-leetcode
 */
public class NextPermutation {

    /**
     * 个人常规解法：主要是搞清楚规则，倒序遍历找到大于前置的，然后寻找和合适的交换，交换完再逆序
     * 12ms 92.06%
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0) {
                // 数组已经是最大了，倒序输出
                for (int j = 0; j < nums.length / 2; j++) {
                    int temp = nums[j];
                    nums[j] = nums[nums.length - 1 - j];
                    nums[nums.length - 1 - j] = temp;
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    // 寻找交换的index
                    int swapIndex = i;
                    for (; swapIndex < nums.length; swapIndex++) {
                        if (nums[swapIndex] <= nums[i - 1]) {
                            break;
                        }
                    }

                    int temp = nums[i - 1];
                    nums[i - 1] = nums[--swapIndex];
                    nums[swapIndex] = temp;


                    for (int j = i; j < i + (nums.length - i) / 2; j++) {
                        temp = nums[j];
                        nums[j] = nums[nums.length - 1 - j + i];
                        nums[nums.length - 1 - j + i] = temp;
                    }

                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1};
        new NextPermutation().nextPermutation(nums);
    }
}
