package leetcode.simple.math;

import java.util.HashMap;

/**
 * @description: 914. 卡牌分组
 * @see: <a>https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/</a>
 * @author: guoping wang
 * @date: 2018/10/29 14:00
 * @project: cc-leetcode
 */
public class XOfAKindInADeckOfCards {

    /**
     * 个人常规解法：统计所有数字出现频率，看是否有大于等于2的公因数
     * 22ms 53.63%
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            if (map.containsKey(deck[i])) {
                map.put(deck[i], map.get(deck[i]) + 1);
            } else {
                map.put(deck[i], 1);
            }
        }
        Integer[] counter = map.values().toArray(new Integer[map.size()]);
        // 求非0的所有的数的公因数
        for (int i = 2; ; i++) {
            boolean hasCommon = true;
            for (int j = 0; j < counter.length; j++) {
                if (counter[j] > 0) {
                    if (counter[j] < i) {
                        return false;
                    }
                    if (counter[j] % i != 0) {
                        hasCommon = false;
                        break;
                    }
                }
            }
            if (hasCommon) {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        int[] deck = {1,2,3,4,4,3,2,1};
        System.out.println(new XOfAKindInADeckOfCards().hasGroupsSizeX(deck));
    }
}
