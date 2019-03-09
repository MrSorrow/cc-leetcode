package leetcode.mid;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 17. 电话号码的字母组合
 * @see: <a>https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/</a>
 * @author: guoping wang
 * @date: 2018/12/28 22:29
 * @project: cc-leetcode
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * 个人常规解法：递归写法
     * 3ms 81.26%
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits) || digits == null) {
            return new ArrayList<>(0);
        }
        int digit = digits.charAt(0) - '0';
        List<String> list = letterCombinations(digits.substring(1));
        if (list.isEmpty()) {
            list.add("");
        }
        ArrayList<String> res = new ArrayList<>(3 * list.size());
        for (int i = 0; i < list.size(); i++) {
            if (digit <= 6) {
                res.add((char) ((digit - 2) * 3 + 'a') + list.get(i));
                res.add((char) ((digit - 2) * 3 + 'b') + list.get(i));
                res.add((char) ((digit - 2) * 3 + 'c') + list.get(i));
            } else if (digit == 7) {
                res.add((char) ((digit - 2) * 3 + 'a') + list.get(i));
                res.add((char) ((digit - 2) * 3 + 'b') + list.get(i));
                res.add((char) ((digit - 2) * 3 + 'c') + list.get(i));
                res.add((char) ((digit - 2) * 3 + 'd') + list.get(i));
            } else if (digit == 8) {
                res.add((char) ((digit - 2) * 3 + 'b') + list.get(i));
                res.add((char) ((digit - 2) * 3 + 'c') + list.get(i));
                res.add((char) ((digit - 2) * 3 + 'd') + list.get(i));
            } else if (digit == 9) {
                res.add((char) ((digit - 2) * 3 + 'b') + list.get(i));
                res.add((char) ((digit - 2) * 3 + 'c') + list.get(i));
                res.add((char) ((digit - 2) * 3 + 'd') + list.get(i));
                res.add((char) ((digit - 2) * 3 + 'e') + list.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListUtils.printLists(new LetterCombinationsOfAPhoneNumber().letterCombinations("9"));
    }
}
