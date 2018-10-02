package leetcode.simple.string;

/**
 * @description: 824. 山羊拉丁文
 * @link: <a>https://leetcode-cn.com/problems/goat-latin/</a>
 * @author: guoping wang
 * @date: 2018/10/2 10:49
 * @project: cc-leetcode
 */
public class GoatLatin {

    /**
     * 个人常规解法：完全按照条件进行编写
     * 7ms 99.08%
     * @param S
     * @return
     */
    public String toGoatLatin(String S) {
        String[] strings = S.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].startsWith("a") || strings[i].startsWith("e") || strings[i].startsWith("i") ||
                    strings[i].startsWith("o") || strings[i].startsWith("u") || strings[i].startsWith("A") ||
                    strings[i].startsWith("E") || strings[i].startsWith("I") || strings[i].startsWith("O") ||
                    strings[i].startsWith("U")) {
                res.append(strings[i]);
            } else {
                res.append(strings[i].substring(1)).append(strings[i].substring(0, 1));
            }
            res.append("ma");
            for (int j = 1; j <= i + 1; j++) {
                res.append("a");
            }
            if (i != strings.length - 1) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new GoatLatin().toGoatLatin("I speak Goat Latin"));
    }
}
