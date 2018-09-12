package leetcode.simple.sort;

import leetcode.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 350. 两个数组的交集 II
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/12 下午2:32
 * @project: cc-leetcode
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] nums1 = {4, 7, 9, 7, 6, 7};
        int[] nums2 = {5, 0, 0, 6, 1, 6, 2, 2, 4};
        ArrayUtils.printArray(new IntersectionOfTwoArraysII().intersectFast(nums1, nums2));
    }

    /**
     * 个人解法：hashmap存储元素和次数
     * 8ms 35.78%
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (hashMap1.containsKey(nums1[i])) {
                hashMap1.put(nums1[i], hashMap1.get(nums1[i]) + 1);
            } else {
                hashMap1.put(nums1[i], 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap1.containsKey(nums2[i]) && hashMap1.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                hashMap1.put(nums2[i], hashMap1.get(nums2[i]) - 1);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    /**
     * 最快算法：排序
     * 3ms 98.29%
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectFast(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] temp = new int[Math.min(nums1.length, nums2.length)];

        int i = 0, j = 0, z = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                temp[z++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] res = new int[z];
        for (int k = 0; k < res.length; k++) {
            res[k] = temp[k];
        }

        return res;
    }
}
