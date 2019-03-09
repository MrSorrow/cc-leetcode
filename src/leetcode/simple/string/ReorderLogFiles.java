package leetcode.simple.string;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 937. 重新排列日志文件
 * @see: <a>https://leetcode-cn.com/problems/reorder-log-files/</a>
 * @author: guoping wang
 * @date: 2018/12/7 21:14
 * @project: cc-leetcode
 */
public class ReorderLogFiles {

    /**
     * 个人常规解法：其实就是定义一下排序规则
     * 7ms 97.39%
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> number = new ArrayList<>();

        for (String log : logs) {
            if (Character.isLetter(log.charAt(log.length() - 1)))
                letter.add(log);
            else
                number.add(log);
        }

        letter.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.substring(o1.indexOf(" ") + 1).compareTo(o2.substring(o2.indexOf(" ") + 1));
            }
        });

        letter.addAll(number);
        return letter.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] logs = {"t kvr", "r 3 1", "i 403", "7 so", "t 54"};
        ArrayUtils.printStringArray(new ReorderLogFiles().reorderLogFiles(logs));
    }
}
