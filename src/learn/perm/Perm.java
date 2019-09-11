package learn.perm;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 全排列算法
 * @author: guoping wang
 * @date: 2019/4/15 14:27
 * @project: cc-leetcode
 */
public class Perm {

    public static void main(String[] args) {
        ListUtils.printLists(perm("1234"));
    }

    public static List<String> perm(String str) {
        List<String> res = new ArrayList<>();
        if (str.length() <= 1) {
            res.add(str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String s = str.substring(i, i + 1);
                List<String> list = perm(str.substring(0, i) + str.substring(i + 1));

                for (int j = 0; j < list.size(); j++) {
                    res.add(s + list.get(j));
                }
            }
        }
        return res;
    }
}
