package leetcode.simple.sort;

import leetcode.utils.ArrayUtils;

import java.util.*;

/**
 * @description: 349. 两个数组的交集
 * @link: <a>https://leetcode-cn.com/problems/intersection-of-two-arrays/description/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/12 下午12:33
 * @project: cc-leetcode
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums2 = {1, 3, 5};
        int[] nums1 = {1, 2, 3};
        ArrayUtils.printArray(new IntersectionOfTwoArrays().intersection(nums1, nums2));
    }

    /**
     * 个人解法：hashset查找
     * 4ms 97.02%
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> num1Set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            num1Set.add(nums1[i]);
        } 
        for (int i = 0; i < nums2.length; i++) {
            if (num1Set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        int[] result = new int[res.size()];
        int index = 0;
        for (Integer integer : res) {
            result[index++] = integer;
        }
        return result;
    }
}
