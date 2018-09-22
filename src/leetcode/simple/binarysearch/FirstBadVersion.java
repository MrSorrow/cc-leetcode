package leetcode.simple.binarysearch;

/**
 * @description: 278. 第一个错误的版本
 * @link: <a>https://leetcode-cn.com/problems/first-bad-version/</a>
 * @author: guoping wang
 * @date: 2018/9/22 20:55
 * @project: cc-leetcode
 */
public class FirstBadVersion {

    /**
     * 个人常规解法：二分法
     * 15ms 96.99%
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            // 注意，很有可能出错. (start + end) / 2 可能整型溢出
            int mid = (end -  start) / 2 + start;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    private boolean isBadVersion(int mid) {
        return mid > 1702766719;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
    }
}
