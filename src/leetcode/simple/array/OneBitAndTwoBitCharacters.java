package leetcode.simple.array;

/**
 * @description: 717. 1比特与2比特字符
 * @link: <a>https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/description/</a>
 * @author: guoping wang
 * @date: 2018/9/6 9:10
 * @project: cc-leetcode
 */
public class OneBitAndTwoBitCharacters {

    public static void main(String[] args) {
        int[] bits = {1, 1, 1, 0};
        System.out.println(new OneBitAndTwoBitCharacters().isOneBitCharacter(bits));
    }

    /**
     * 个人常规解法：不断的切分
     * 8ms 45.09%
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        // 如果末尾是1直接返回
        if (bits[bits.length - 1] == 1) {
            return false;
        }
        // 不断的截取，直到最后
        int index = 0;

        while (index < bits.length - 2) {
            if (bits[index] == 0) {
                index++;
            } else {
                // 10 或 11
                index+=2;
            }
        }

        if (index != bits.length - 1 && bits[index] == 1) {
            return false;
        } else {
            return true;
        }
    }
}
