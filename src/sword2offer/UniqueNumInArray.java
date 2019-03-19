package sword2offer;

/**
 * @description: 3. 数组中重复的数字
 * @see: <a>https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8</a>
 * @author: guoping wang
 * @date: 2019/3/19 22:34
 * @project: cc-leetcode
 */
public class UniqueNumInArray {

    /**
     * 个人常规解法：数组统计出现个数
     * @param numbers an array of integers
     * @param length the length of array numbers
     * @param duplication 返回任意重复的一个，赋值duplication[0]
     * @return true if the input is valid, and there are some duplications in the array number otherwise false
     */
    public boolean duplicate(int numbers[], int length, int [] duplication) {
        if (numbers == null) return false;
        int[] counter = new int[length];
        for (int i = 0; i < numbers.length; i++) {
            counter[numbers[i]]++;
        }

        int index = -1;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > 1) {
                index++;
                duplication[0] = i;
                break;
            }
        }
        return index >= 0;
    }

    public static void main(String[] args) {

    }
}
