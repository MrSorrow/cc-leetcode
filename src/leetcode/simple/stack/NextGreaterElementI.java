package leetcode.simple.stack;

import leetcode.utils.ArrayUtils;

import java.util.HashMap;

/**
 * @description: 496. 下一个更大元素 I
 * @link: <a>https://leetcode-cn.com/problems/next-greater-element-i/description/</a>
 * @author: guoping wang
 * @date: 2018/9/14 18:41
 * @project: cc-leetcode
 */
public class NextGreaterElementI {

    /**
     * 个人常规算法：hashmap查找，寻找到比器大的数字
     * 8ms 87.03%
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> num2Map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            num2Map.put(nums2[i], i);
        }
        for (int i = 0; i < res.length; i++) {

            res[i] = -1;

            int index = num2Map.get(nums1[i]);
            while (++index < nums2.length) {
                if (nums2[index] > nums1[i]) {
                    res[i] = nums2[index];
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        ArrayUtils.printIntArray(new NextGreaterElementI().nextGreaterElement(nums1, nums2));
    }
}
