package leetcode.simple.other;

import leetcode.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @description: 506. 相对名次
 * @see: <a>https://leetcode-cn.com/problems/relative-ranks/</a>
 * @author: guoping wang
 * @date: 2018/12/16 10:21
 * @project: cc-leetcode
 */
public class RelativeRanks {

    /**
     * 个人常规解法：TreeMap排序记录索引位置
     * 32ms 42.67%
     * @param nums
     * @return
     */
    public String[] findRelativeRanks(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 降序
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        String[] res = new String[nums.length];
        int index = 1;
        for (Integer rank : map.keySet()) {
            switch (index) {
                case 1:
                    res[map.get(rank)] = "Gold Medal";
                    break;
                case 2:
                    res[map.get(rank)] = "Silver Medal";
                    break;
                case 3:
                    res[map.get(rank)] = "Bronze Medal";
                    break;
                default:
                    res[map.get(rank)] = index + "";
                    break;
            }
            index++;
        }
        return res;
    }

    /**
     * 个人常规解法：将Map用数组替代
     * 18ms 77%
     * @param nums
     * @return
     */
    public String[] findRelativeRanksBetter(int[] nums) {
        int[] ranks = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            // 数组存放了索引位置
            ranks[nums[i]] = i;
        }

        Arrays.sort(nums);

        String[] res = new String[nums.length];
        int rank = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            switch (rank) {
                case 1:
                    res[ranks[nums[i]]] = "Gold Medal";
                    break;
                case 2:
                    res[ranks[nums[i]]] = "Silver Medal";
                    break;
                case 3:
                    res[ranks[nums[i]]] = "Bronze Medal";
                    break;
                default:
                    res[ranks[nums[i]]] = rank + "";
                    break;
            }
            rank++;
        }
        return res;
    }

    /**
     * 在数组的基础上进行修改：去掉排序和确定申请数组大小
     * 4ms 100%
     * @param nums
     * @return
     */
    public String[] findRelativeRanksBest(int[] nums) {
        // 确定申请数组大小
        int level = nums.length;
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }
        int[] ranks = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            // 数组存放了索引位置
            ranks[nums[i]] = i + 1;
        }

        String[] res = new String[nums.length];
        int rank = 1;
        for (int i = ranks.length - 1; i >= 0; i--) {
            if (ranks[i] != 0) {
                switch (rank) {
                    case 1:
                        res[ranks[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        res[ranks[i] - 1] = "Silver Medal";
                        break;
                    case 3:
                        res[ranks[i] - 1] = "Bronze Medal";
                        break;
                    default:
                        res[ranks[i] - 1] = rank + "";
                        break;
                }
                rank++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 8, 9, 4};
        ArrayUtils.printStringArray(new RelativeRanks().findRelativeRanksBest(nums));
    }
}
