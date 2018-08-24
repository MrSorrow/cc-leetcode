package leetcode.simple.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和 II - 输入有序数组
 * @link: <a>https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/</a>
 * @author: guoping wang
 * @date: 2018/8/23 23:35
 * @project: cc-leetcode
 */
public class TwoSumIIInputArrayIsSorted {

    public static void main(String[] args) {

        int[] numbers = {0, 0, 3, 4};
        int target = 0;
        System.out.println(new TwoSumIIInputArrayIsSorted().twoSumOnceHash(numbers, target));
    }

    /**
     * 个人解法：一头一尾进行遍历
     * 超时 17/17 :(
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumFor(int[] numbers, int target) {

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                } else if (numbers[i] + numbers[j] < target) {
                    break;
                }
            }
        }
        return new int[0];
    }

    /**
     * 个人解法：两遍哈希
     * 4ms 48.48%
     * 值得注意的是，hashmap的键唯一，重复元素只存了一个，value是最后一个重复元素的下标。i从零开始遍历，先取到重复元素第一个下标，必然不相等。
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumTwiceHash(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int second = target - numbers[i];
            if (map.containsKey(second) && map.get(second) != i) {
                return i < map.get(second) ? new int[]{i + 1, map.get(second) + 1} : new int[]{map.get(second) + 1, i + 1};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 个人解法：一遍哈希
     * 3ms 55.46%
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumOnceHash(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int second = target - numbers[i];
            if (map.containsKey(second)) {
                return i < map.get(second) ? new int[]{i + 1, map.get(second) + 1} : new int[]{map.get(second) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 最优算法：思路从一头一尾遍历衍生而来，设置进退策略
     * 为什么start不后退？如果start后退满足，在start没必要前进
     */
    public int[] twoSum(int[] numbers, int target) {
        int front = 0, end = numbers.length - 1;
        while (front < end) {

            if (numbers[front] + numbers[end] == target) {
                return new int[]{front + 1, end + 1};
            } else if (numbers[front] + numbers[end] < target) {
                front++;
            } else {
                end--;
            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
