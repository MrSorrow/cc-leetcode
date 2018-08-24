package leetcode.simple.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 169. 求众数
 * @link: <a>https://leetcode-cn.com/problems/majority-element/description/</a>
 * @author: guoping wang
 * @date: 2018/8/24 15:42
 * @project: cc-leetcode
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(new MajorityElement().majorityElement(nums));
        System.out.println(new MajorityElement().majorityElementMooreVote(nums));
        System.out.println(new MajorityElement().majorityElementDp(nums,0, nums.length - 1));
    }

    /**
     * 常规解法：hashmap统计次数
     * 44ms 10.42%
     * @param nums
     * @return
     */
    public int majorityElementHashMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.containsKey(nums[i]) ? countMap.get(nums[i]) + 1 : 1);
            if (countMap.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        throw new IllegalArgumentException("No majority element solution");
    }

    /**
     * 分治算法：切分一半，分别求众数，相等与不等分别处理
     * 5ms 77.30%
     * @param nums
     * @return
     */
    public int majorityElementDp(int[] nums, int start, int end) {

        // 设置递归结束
        if (start == end) {
            return nums[start];
        }

        // 左边众数
        int leftMajor = majorityElementDp(nums, start, (start + end) / 2);
        // 左边众数
        int rightMajor = majorityElementDp(nums, (start + end) / 2 + 1, end);

        // 如果左右相等，则直接返回
        if (leftMajor == rightMajor) {
            return leftMajor;
        } else {
            // 不相等需要重新统计两个众位数出现次数大小
            int countLeft = 0, countRight = 0;
            for (int i = start; i <= end; i++) {
                if (nums[i] == leftMajor) {
                    countLeft++;
                } else if (nums[i] == rightMajor) {
                    countRight++;
                }
            }
            return countLeft > countRight ? leftMajor : rightMajor;
        }
    }

    /**
     * 摩尔投票法：算法成功前提是必然存在众数
     * 5ms 77.30%
     * @param nums
     * @return
     */
    public int majorityElementMooreVote(int[] nums) {
        int count = 0, result = nums[0];

        for (int num : nums) {
            if (count == 0) {
                result = num;
                count++;
            } else {
                if (num == result) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return result;
    }

    /**
     * 位操作解法：定义32位和int位数一致 每一位存储nums中所有数字中该位的众数，最后把这32位合成一个int数就是结果
     *
     * 28ms 32.73%
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 32; ++i) {
            int ones = 0, zeros = 0;
            for (int num : nums) {
                if (ones > n / 2 || zeros > n / 2) {
                    break;
                }
                if ((num & (1 << i)) != 0) {
                    ++ones;
                }
                else {
                    ++zeros;
                }
            }
            if (ones > zeros) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
