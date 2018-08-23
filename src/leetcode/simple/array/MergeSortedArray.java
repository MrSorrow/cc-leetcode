package leetcode.simple.array;

import java.util.Arrays;

/**
 * @author Kingdompin@163.com
 * @link <a>https://leetcode-cn.com/problems/merge-sorted-array/description/</a>
 * @date 2018/8/23 上午9:15
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int m = 3;
		int n = 3;
//		new MergeSortedArray().mergeAndSort(nums1, m, nums2, n);
//		new MergeSortedArray().mergeInsert(nums1, m, nums2, n);
		new MergeSortedArray().merge(nums1, m, nums2, n);
	}

	/**
	 * 个人常规解法：将两个合并然后排序
	 * 5ms 66.17%
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void mergeAndSort(int[] nums1, int m, int[] nums2, int n) {
		// 合并数组
		for (int i = m; i < m + n; i++) {
			nums1[i] = nums2[i - m];
		}
		// 排序
		Arrays.sort(nums1);
		// 输出
		System.out.print("[");
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i]);
			if (i != nums1.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}

	/**
	 * 个人常规解法：插入第三个数组中
	 * 4ms 96.53%
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void mergeInsert(int[] nums1, int m, int[] nums2, int n) {
		int[] result = new int[m + n];
		// 插入
		for (int i = 0, j = 0, k = 0; k < m + n; ) {
			if (i < m && j < n) {
				if (nums1[i] <= nums2[j]) {
					result[k] = nums1[i];
					i++;
				} else {
					result[k] = nums2[j];
					j++;
				}
			} else if (i >= m && j < n) {
				result[k] = nums2[j];
				j++;
			} else if (i < m && j >= n)  {
				result[k] = nums1[i];
				i++;
			}
			k++;
		}

		
		for (int i = 0; i < result.length; i++) {
			nums1[i] = result[i];
		}
	}
	
	/**
	 * 插入排序
	 *  7ms 18.82%
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// 插入
		for (int i = 0; i < nums2.length; i++) {
			int j = m + i - 1;
			// 找位置
			for (; j >= 0 && nums2[i] < nums1[j]; j--) {
				nums1[j+1] = nums1[j];
			}
			nums1[j+1] = nums2[i];
		}

		// 输出
		System.out.print("[");
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i]);
			if (i != nums1.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}
}
