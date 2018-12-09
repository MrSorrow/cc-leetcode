package leetcode.simple.math;

/**
 * @description: 754. 到达终点数字
 * @see： <a>https://leetcode-cn.com/problems/reach-a-number/</a>
 * @author: guoping wang
 * @date: 2018/12/8 10:07
 * @project: cc-leetcode
 */
public class ReachANumber {

    /**
     * 首先 比如说目标值是4，那么如果我们一直向前走，直到累加步数 sum 正好大于等于target时，有： 0 + 1 = 1 1 + 2 = 3 3 + 3 = 6 我们发现 sum 超过了目标值 4，超过的距离为2，是偶数，那么实际上我们只要将加上距离为 1 的时候，不加 1，而是 -1，那么此时累加和就损失了 2，那么正好能到目标值 4，如下： 0 - 1 = -1 -1 + 2 = 1 1 + 3 = 4 所以这种情况下，最小的步数就是累加步数到 sum 所用的步数 n。
     *
     * 然后 如果说目标值是 7，有： 0 + 1 = 1 1 + 2 = 3 3 + 3 = 6 6 + 4 = 10 我们发现 sum 超过了目标值 7 的距离为3，是奇数，我现在可以这么处理这个奇数 3： 3 = 2 * 1 + 1 前面的偶数 2 可以按照上面的方式来处理，我只需要处理多出来的 1 即可。实际上 1 就很好处理了，我们只需再向前走 1 步，然后再向后走 1 步其实刚好就抵消了这个 1 。这个过程如下： 0 - 1 = -1 -1 + 2 = 1 1 + 3 = 4 4 + 4 = 8 //基准步数 8 + 5 = 13 13 - 6 = 7 所以这种情况下，最小的步数就是累加步数到 sum 所用的步数 n + 2。
     *
     * 然而 然而测试时发现，当 sum - target 为奇数时，某些情况下，我们这种方式的步数会比最优解大 1 ，就比如上面的目标值 7 。
     *
     * 下面我们分析一下。 target=7; sum=10; n=4; 我们再走一步的话 sum=7+5=15; sum-target=8;
     *
     * 看到没，我们再走一步之后 sum-target 变成偶数了，既然变成偶数了，我们当然就可以按照最初的方式来走了呀： 0 + 1 = 1 1 + 2 = 3 3 + 3 = 6 6 - 4 = 2 //基准步数 2 + 5 = 7 所以这种情况下，我们只需多走一步就可以了，不需要无脑的多走两步。
     *
     * 所以 上面当 sum - target 为奇数时多走一步就可以的条件是： sum + (n+1) - target 为偶数 因为我们已经知道 sum - target 为奇数了，所以 n+1 肯定也为奇数，也就是说 n 为偶数。 也就是说，如果此时 n 为偶数，我们只需再多走一步就可以了。
     *
     * 那如果 n 为奇数呢？
     *
     * 我觉得有两种分析方式，一种就是我们上面最开始错误分析的那种，直接为 n + 2；另一种可以继续按照这种方式分析： 如果 tem = sum - target 为奇数 那么 tem + (n+1) + (n+2) = 2 (n+1) + (tem+1) 肯定为偶数，也即再多走 2 步 无论如何都是可以的了。
     *
     * 当然，这只能保证是可以到达终点的路径，但不能百分之百保证这是最佳的路径
     * @param target
     * @return
     */
    public int reachNumber(int target) {
        int sub = Math.abs(target);
        int n = 0;
        while ((n * n + n) / 2 < sub) {
            n++;
        }
        int beyond = (n * n + n) / 2 - sub;
        if (beyond % 2 == 0) {
            return n;
        } else {
            return n % 2 == 0 ? n + 1 : n + 2;
        }

    }

    public static void main(String[] args) {
        System.out.println(new ReachANumber().reachNumber(2));
    }
}
