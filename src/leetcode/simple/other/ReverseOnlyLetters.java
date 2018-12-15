package leetcode.simple.other;

/**
 * @description: 917. 仅仅反转字母
 * @see: <a>https://leetcode-cn.com/problems/reverse-only-letters/</a>
 * @author: guoping wang
 * @date: 2018/12/14 15:41
 * @project: cc-leetcode
 */
public class ReverseOnlyLetters {

    /**
     * 个人常规解法：原地置换
     * 6ms 91.50%
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        if ("".equals(S)) return "";
        char[] array = S.toCharArray();
        int front = -1, tail = array.length;

        while (front < tail) {
            // 寻找字母
            do {
                front++;
            } while (front < tail && !Character.isLetter(array[front]));
            do {
                tail--;
            } while (front < tail && !Character.isLetter(array[tail]));

            if (tail <= front) break;

            // 交换
            char temp = array[front];
            array[front] = array[tail];
            array[tail] = temp;
        }

        return new String(array);
    }
}
