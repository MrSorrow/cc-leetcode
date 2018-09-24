package leetcode.simple.binarysearch;

/**
 * @description: 744. 寻找比目标字母大的最小字母
 * @link: <a>https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/</a>
 * @author: guoping wang
 * @date: 2018/9/24 19:21
 * @project: cc-leetcode
 */
public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {

    }

    /**
     * 个人常规解法：O(n)的遍历找到大的最小
     * 9ms 95.33%
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetterOn(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (target < letters[i]) {
                return letters[i];
            }
        }
        return letters[0];
    }

    /**
     * 个人常规解法：二分法寻找
     * 9ms 95.33%
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetterBS(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return letters[start];
    }
}
