package leetcode.mid;

/**
 * @description: 75. 颜色分类
 * @see: <a>https://leetcode-cn.com/problems/sort-colors/</a>
 * @author: guoping wang
 * @date: 2019/3/7 20:04
 * @project: cc-leetcode
 */
public class SortColors {

    /**
     * 个人常规解法：直接统计个数
     * 1ms 67.59%
     * @param nums
     */
    public void sortColorsCount(int[] nums) {
        int[] counter = new int[3];
        for (int num : nums) {
            counter[num]++;
        }
        for (int i = 0; i < counter[0]; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < counter[1]; i++) {
            nums[i + counter[0]] = 0;
        }
        for (int i = 0; i < counter[2]; i++) {
            nums[i + counter[0] + counter[1]] = 0;
        }
    }

    /**
     * 个人常规解法：一趟扫描，前后都开始插入
     * 1ms 67.59%
     * @param nums
     */
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;

        for (int i = 0; i <= end; i++) {
            if (nums[i] == 1) continue; // 1不用管
            else if (nums[i] == 0) {
                nums[start++] = 0;
            } else {
                // 如果第i个数字是2，则尾插向前寻找不是2的数字
                while (nums[end] == 2) {
                    end--;
                    if (i > end) break;
                }
                if (i > end) break;
                int num = nums[end]; // 先取出数据
                nums[end] = 2;
                if (num == 0) {
                    nums[start++] = 0;
                }
                end--;
            }
        }

        for (int i = start; i <= end; i++) {
            nums[i] = 1;
        }


    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        new SortColors().sortColors(nums);
    }
}
