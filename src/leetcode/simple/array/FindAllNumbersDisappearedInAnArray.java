package leetcode.simple.array;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 448. 找到所有数组中消失的数字
 * @link: <a>https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/description/</a>
 * @author: guoping wang
 * @date: 2018/8/27 21:34
 * @project: cc-leetcode
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        ListUtils.printLists(new FindAllNumbersDisappearedInAnArray().findDisappearedNumbersHashSet(nums));
        ListUtils.printLists(new FindAllNumbersDisappearedInAnArray().findDisappearedNumbersSort(nums));
        ListUtils.printLists(new FindAllNumbersDisappearedInAnArray().findDisappearedNumbersFast(nums));
    }

    /**
     * 个人常规解法：hashset先存入1~n,然后再根据nums进行remove
     * 61ms 7.54%
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbersHashSet(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            hashSet.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            hashSet.remove(nums[i]);
        }
        return new ArrayList<>(hashSet);
    }

    /**
     * 个人常规解法：排序完进行检查，相邻的要么相等要么加一
     * 40ms 22.86%
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbersSort(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length <= 0) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums[0]; i++) {
            list.add(i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1] && nums[i] != nums[i+1] - 1) {
                for (int j = nums[i] + 1; j < nums[i+1]; j++) {
                    list.add(j);
                }
            }
        }
        for (int i = nums[nums.length - 1] + 1; i <= nums.length; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * 最快解法：思路其实和hashset基本没差，用数组来实现
     * 8ms 100%
     */
    public List<Integer> findDisappearedNumbersFast(int[] nums) {
        int[] array = new int[nums.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            array[nums[i] - 1] = 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                list.add(array[i]);
            }
        }
        return list;
    }
}
