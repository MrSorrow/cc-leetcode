package leetcode.simple.array;

import java.util.HashMap;

/**
 * @description: 697. 数组的度
 * @link: <a>https://leetcode-cn.com/problems/degree-of-an-array/description/</a>
 * @author: guoping wang
 * @date: 2018/9/5 16:38
 * @project: cc-leetcode
 */
public class DegreeOfAnArray {

    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(new DegreeOfAnArray().findShortestSubArrayArray(nums));
        System.out.println(new DegreeOfAnArray().findShortestSubArrayClass(nums));
        System.out.println(new DegreeOfAnArray().findShortestSubArray(nums));
    }

    /**
     * 个人常规解法：不停的减少元素，递归求解
     * 超时
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {

        int max = calDegreeOfAnArray(nums, 0, nums.length - 1);

        int startIndex = 0, endIndex = nums.length - 1;
        while (calDegreeOfAnArray(nums, startIndex, endIndex) == max) {
            startIndex++;
        }
        startIndex--;
        while (calDegreeOfAnArray(nums, startIndex, endIndex) == max) {
            endIndex--;
        }
        endIndex++;
        return endIndex - startIndex + 1;
    }

    /**
     * 计算一个数组的度
     * @param nums 数组
     * @param start 开始
     * @param end 结尾
     * @return
     */
    public int calDegreeOfAnArray(int[] nums, int start, int end) {
        int max = 0;
        if (start <= end) {
            HashMap<Integer, Integer> countMap = new HashMap<>(end - start + 1);
            for (int i = start; i <= end; i++) {
                if (countMap.containsKey(nums[i])) {
                    countMap.put(nums[i], countMap.get(nums[i]) + 1);
                } else {
                    countMap.put(nums[i], 1);
                }
                if (countMap.get(nums[i]) > max) {
                    max = countMap.get(nums[i]);
                }
            }
        }
        return max;
    }

    /**
     * 个人常规解法：自定义数据类型，O(n)
     * 107ms 19.92%
     * @param nums
     * @return
     */
    public int findShortestSubArrayClass(int[] nums) {
        HashMap<Integer, Counter> map = new HashMap<>();
        int maxDegree = 0, min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // 已经存在，则修改endIndex和degree
                Counter counter = map.get(nums[i]);
                counter.setDegree(counter.getDegree() + 1);
                counter.setEndIndex(i);
                map.put(nums[i], counter);
            } else {
                // 如果不存在，则新建并存入
                Counter counter = new Counter(nums[i], i, i, 1);
                map.put(nums[i], counter);
            }
            if (map.get(nums[i]).getDegree() > maxDegree) {
                maxDegree = map.get(nums[i]).getDegree();
                min = nums.length;
            }
            if (map.get(nums[i]).getDegree() == maxDegree) {
                if (min > map.get(nums[i]).getSubIndex()) {
                    min = map.get(nums[i]).getSubIndex();
                }
            }
        }
        return min;
    }

    /**
     * 最快解法：自定义数据类型解法思路的数组实现
     * 31ms 84.23%
     * @param nums
     * @return
     */
    public int findShortestSubArrayArray(int[] nums) {
        int[] starts = new int[50001]; // 存放出现的每个数起点
        int[] widths = new int[50001]; // 存放每个数的跨度
        int[] degrees = new int[50001]; // 存放每个数的度
        int maxDegree = 0, min = nums.length;

        for (int i = 0; i < nums.length; i++) {
            // 记录起点和跨度
            if (starts[nums[i]] == 0) {
                starts[nums[i]] = i + 1;
                widths[nums[i]] = 1;
            } else {
                widths[nums[i]] = i + 2 - starts[nums[i]];
            }
            // 记录度
            degrees[nums[i]]++;

            // 记录最大的度
            if (maxDegree < degrees[nums[i]]) {
                maxDegree = degrees[nums[i]];
                min = nums.length;
            }
            // 找出最大度中最小的宽度
            if (degrees[nums[i]] == maxDegree) {
                if (min > widths[nums[i]]) {
                    min = widths[nums[i]];
                }
            }
        }
        return min;
    }
}

class Counter {

    private Integer element;
    private Integer startIndex;
    private Integer endIndex;
    private Integer degree;

    public Counter(Integer element, Integer startIndex, Integer endIndex, Integer degree) {
        this.element = element;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.degree = degree;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getSubIndex() {
        return endIndex - startIndex + 1;
    }
}
