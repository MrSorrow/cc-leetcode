package leetcode.simple.string;

/**
 * @description: 925. 长按键入
 * @see: <a>https://leetcode-cn.com/problems/long-pressed-name/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/12/18 下午4:54
 * @project: cc-leetcode
 */
public class LongPressedName {

    /**
     * 个人常规解法：定义两个指针遍历即可，关键在于控制逻辑
     * 4ms 99.60%
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        int index1 = 0, index2 = 0;
        for (;;) {
            while (index1 < name.length() - 1 && name.charAt(index1) == name.charAt(index1 + 1)) {
                if (name.charAt(index1++) != typed.charAt(index2++)) {
                    return false;
                }
            }
            while (index2 < typed.length() - 1 && typed.charAt(index2) == typed.charAt(index2 + 1)) {
                index2++;
            }
            index1++;
            index2++;
            if (index1 >= name.length()) {
                break;
            }
            if (index2 >= typed.length()) {
                // 能运行到这说明也是错的
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongPressedName().isLongPressedName("alex", "aaleex"));
    }
}
