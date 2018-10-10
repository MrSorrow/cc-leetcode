package leetcode.simple.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 599. 两个列表的最小索引总和
 * @see: <a>https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/</a>
 * @author: guoping wang
 * @date: 2018/10/10 9:48
 * @project: cc-leetcode
 */
public class MinimumIndexSumOfTwoLists {

    /**
     * 个人常规解法：按相加索引的排序顺序进行寻找
     * 58ms 27.46%
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {

        List<String> res = new ArrayList<>();

        int length = list1.length + list2.length - 1;

        for (int i = 0; i < length; i++) {
            // i表示两个索引相加
            for (int j = 0; j <= i; j++) {
                if (j >= list1.length || i - j >= list2.length) {
                    continue;
                }
                if (list1[j].equals(list2[i - j])) {
                    res.add(list1[j]);
                }
            }
            if (!res.isEmpty()) {
                break;
            }
        }

        return res.toArray(new String[res.size()]);
    }

    /**
     * 个人常规算法：hashMap存储一个数组
     * 21ms 96.95%
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurantMap(String[] list1, String[] list2) {

        List<String> res = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int maxSum = list1.length + list2.length - 1;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (map.get(list2[i]) + i < maxSum) {
                    maxSum = map.get(list2[i]) + i;
                    res.clear();
                    res.add(list2[i]);
                } else if (map.get(list2[i]) + i == maxSum) {
                    res.add(list2[i]);
                }
            }
        }

        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun"};
        String[] list2 = {"Shogun"};
        System.out.println(new MinimumIndexSumOfTwoLists().findRestaurant(list1, list2)[0]);
    }
}
