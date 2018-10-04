package leetcode.simple.hash;

import java.util.HashMap;

/**
 * @description: 202. 快乐数
 * @link: <a>https://leetcode-cn.com/problems/happy-number/</a>
 * @author: guoping wang
 * @date: 2018/10/4 22:41
 * @project: cc-leetcode
 */
public class HappyNumber {

    /**
     * 个人常规解法：规定有限次尝试，试出来最多尝试6次即可，并不是好解法
     * 1ms 99.92%
     * @param n
     * @return
     */
    public boolean isHappyTry(int n) {
        int count = 0;

        while (true) {
            String nStr = n + "";
            n = 0;
            char[] array = nStr.toCharArray();
            for (int i = 0; i < array.length; i++) {
                n += (array[i] - '0') * (array[i] - '0');
            }
            if (n == 1) {
                return true;
            } else {
                count++;
                if (count > 5) {
                    return false;
                }
            }
        }
    }

    /**
     * 个人常规解法：递归寻找，当循环开始意味着结束，hashmap保存中间结果
     * 3ms 80.13%
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashMap<Integer, Boolean> resMap = new HashMap<>();
        resMap.put(1, true);
        return isHappyNum(n, resMap);
    }

    private boolean isHappyNum(int n, HashMap<Integer, Boolean> resMap) {
        if (resMap.containsKey(n)) {
            return resMap.get(n);
        } else {
            resMap.put(n, false);
            char[] array = String.valueOf(n).toCharArray();
            n = 0;
            for (int i = 0; i < array.length; i++) {
                n += (array[i] - '0') * (array[i] - '0');
            }
            return isHappyNum(n, resMap);
        }
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappyTry(19));
        System.out.println(new HappyNumber().isHappy(18));
    }
}
