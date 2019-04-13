package internship.tencent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @description:
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/4/5 7:15 PM
 * @project: cc-leetcode
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = scanner.nextInt();
        }
        Arrays.sort(coins);

        int res = -1; Boolean flag = true;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            HashMap<Integer, Integer> sMap = solution(coins, i, n - 1);
            if (sMap != null && sMap.size() > 0) {
                for (Integer key : sMap.keySet()) {
                    if (map.containsKey(key)) {
                        map.put(key, Math.max(sMap.get(key), map.get(key)));
                    } else {
                        map.put(key, sMap.get(key));
                    }
                }
            } else if (sMap == null) {
                flag = false;
                break;
            }

        }
        if (flag && map.size() > 0) {
            res = 0;
            for (Integer key : map.keySet()) {
                res += map.get(key);
            }
        }

        System.out.println(res);
    }

    private static HashMap<Integer, Integer> solution(int[] coins, int n, int end) {
        if (n == 0) return new HashMap<>();
        if (n < 0) return null;

        HashMap<Integer, Integer> choose = null;
        HashMap<Integer, Integer> notChoose = null;

        for (int i = end; i >= 0; i--) {
            if (coins[i] > n) continue;
            else {
                // 选当前硬币
                choose = solution(coins, n - coins[i], i);
                if (choose != null) {
                    if (choose.containsKey(coins[i])) {
                        choose.put(coins[i], choose.get(coins[i]) + 1);
                    } else {
                        choose.put(coins[i], 1);
                    }
                }
                notChoose = solution(coins, n, i - 1);
                break;
            }
        }
        if (choose == null && notChoose == null)
            return null;
        else if (choose == null)
            return notChoose;
        else if (notChoose == null)
            return choose;
        else {
            int sizeA = 0, sizeB = 0;
            for (Integer key : choose.keySet()) {
                sizeA += choose.get(key);
            }
            for (Integer key : notChoose.keySet()) {
                sizeB += notChoose.get(key);
            }
            return sizeA < sizeB ? choose : notChoose;
        }
    }
}


/*
20 4
1
2
5
10

5
*/
