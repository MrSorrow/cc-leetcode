package learn.perm;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 所有的组合数
 * @author: guoping wang
 * @date: 2019/4/20 15:58
 * @project: cc-leetcode
 */
public class Combination {

    public static List<List<Integer>> combination(List<Integer> digits) {
        List<List<Integer>> res = new ArrayList<>();
        
        int combines = 1 << digits.size();

        for (int i = 1; i < combines; i++) {
            List<Integer> list = new ArrayList<>();

            // i代表的是digits每一位取或者不取，算法的限制是digits不超过31
            for (int j = 0; j < digits.size(); j++) {
                int flag = (i >> j) & 1;
                if (flag == 1) {
                    list.add(digits.get(j));
                }
            }

            res.add(list);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> digits = new ArrayList<>();
        digits.add(1);
        digits.add(3);
        digits.add(4);
        ListUtils.printLists(combination(digits));
    }
}
