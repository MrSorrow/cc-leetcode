package leetcode.simple.string;

/**
 * @description: 859. 亲密字符串
 * @see: <a>https://leetcode-cn.com/problems/buddy-strings/</a>
 * @author: guoping wang
 * @date: 2018/12/6 15:00
 * @project: cc-leetcode
 */
public class BuddyStrings {

    /**
     * 个人常规解法：分情况讨论，判断重复可以indexOf
     * 4ms 82.87%
     * @param A
     * @param B
     * @return
     */
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        // 记录差别的地方，不能超过两个或者只有一个
        int count = 0;
        int[] indexs = {-1, -1};
        boolean hasDuplicate = false;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
                indexs[count - 1] = i;
            }
            if (!hasDuplicate) {
                hasDuplicate = A.indexOf(A.charAt(i)+"") != A.lastIndexOf(A.charAt(i)+"");
            }
        }

        if (count == 1) {
            return false;
        }

        if (indexs[0] >= 0) {
            // 说明是两个重复的元素
            return A.charAt(indexs[0]) == B.charAt(indexs[1]) && A.charAt(indexs[1]) == B.charAt(indexs[0]);
        } else {
            // 查看是否有重复的元素
            return hasDuplicate;
        }
    }
}
