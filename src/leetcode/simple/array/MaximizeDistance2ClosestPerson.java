package leetcode.simple.array;

/**
 * @description: 849. 到最近的人的最大距离
 * @link: <a>https://leetcode-cn.com/problems/maximize-distance-to-closest-person/description/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 上午11:19
 * @project: cc-leetcode
 */
public class MaximizeDistance2ClosestPerson {
    public static void main(String[] args) {
        int[] seats = {1, 0, 0, 0, 1};
        System.out.println(new MaximizeDistance2ClosestPerson().maxDistToClosest(seats));
    }

    /**
     * 个人常规解法：寻找连续0的个数
     * 9ms 89.80%
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {

        int startIndex = 0;
        int countIndex = 0;
        int max = 1;

        while (startIndex < seats.length) {
            if (seats[startIndex] != 0) {
                startIndex++;
            } else {
                // 如果是0，计算长度
                countIndex = startIndex; // 初始位置
                while (startIndex < seats.length && seats[startIndex] == 0) {
                    startIndex++;
                }
                if (countIndex == 0) {
                    max = startIndex - countIndex;
                } else if (startIndex == seats.length && startIndex - countIndex > max) {
                    max = startIndex - countIndex;
                } else if ((startIndex - countIndex + 1) / 2> max) {
                    max = (startIndex - countIndex + 1) / 2;
                }
            }
        }
        return max;
    }
}
