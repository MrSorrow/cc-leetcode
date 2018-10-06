package leetcode.simple.hash;

/**
 * @description: 204. 计数质数
 * @see: <a>https://leetcode-cn.com/problems/count-primes/</a>
 * @author: guoping wang
 * @date: 2018/10/5 9:38
 * @project: cc-leetcode
 */
public class CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 个人解法：常规判断
     * 超时，19/20
     *
     * @param n
     * @return
     */
    private boolean isPrimeNumber(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 正确判断质数：1. 2为质数； 2. 小于2的或者偶数都肯定不是； 3. 奇数从3开始除，只除奇数便知道是否是质数
     * 433ms 4.74%
     *
     * @param num
     * @return
     */
    public boolean isPrime(int num) {
        if (num == 2) return true;
        if (num < 2 || num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 筛选法
     * 27ms 70.05%
     * @param n
     * @return
     */
    public int countPrimesBest(int n) {
        int count = 0;
        boolean flag[] = new boolean[n];
        for (int i = 2; i < n; i++)
            if (flag[i] == false) {
                count++;
                for (int j = 1; j * i < n; j++)
                    flag[j * i] = true;
            }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(1500000));
        System.out.println(new CountPrimes().countPrimesBest(50));
    }
}
