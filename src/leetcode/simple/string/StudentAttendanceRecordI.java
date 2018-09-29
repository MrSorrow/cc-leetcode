package leetcode.simple.string;

/**
 * @description: 551. 学生出勤纪录 I
 * @link: <a>https://leetcode-cn.com/problems/student-attendance-record-i/</a>
 * @author: guoping wang
 * @date: 2018/9/29 10:09
 * @project: cc-leetcode
 */
public class StudentAttendanceRecordI {

    /**
     * 个人常规解法：一次遍历
     * 9ms 65.24%
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int countA = 0;
        int countL = 0;
        for (char c : chars) {
            // 不超过一个A
            if (c == 'A') {
                countL = 0;
                countA++;
                if (countA > 1) {
                    return false;
                }
            }

            // 连续超过两个L
            else if (c == 'L') {
                countL++;
                if (countL > 2) {
                    return false;
                }
            }

            else {
                countL = 0;
            }
        }
        return true;
    }

    /**
     * 最简洁的写法：出现一个A必须第一个A和最后一个A索引一致，三个LLL以上字符串中必定含有LLL
     * 7ms 93.70%
     * @param s
     * @return
     */
    public boolean checkRecordBest(String s) {
        if (s.indexOf("A") != s.lastIndexOf("A")) {
            return false;
        }
        if (s.contains("LLL")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new StudentAttendanceRecordI().checkRecord("PPALLP"));
        System.out.println(new StudentAttendanceRecordI().checkRecord("PPALLL"));
    }
}
