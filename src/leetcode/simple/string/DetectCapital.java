package leetcode.simple.string;

/**
 * @description: 520. 检测大写字母
 * @link: <a>https://leetcode-cn.com/problems/detect-capital/</a>
 * @author: guoping wang
 * @date: 2018/9/28 9:38
 * @project: cc-leetcode
 */
public class DetectCapital {

    /**
     * 个人常规解法：应对三种情况分别进行利用API判断
     * 31ms 57.32%
     * @param word
     * @return
     */
    public boolean detectCapitalUseAPI(String word) {
        if (word == null || "".equals(word)) {
            return false;
        }

        // 三种情况
        if (word.equals(word.toLowerCase()) || word.equals(word.toUpperCase())
                || word.equals(word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())) {
            return true;
        }

        return false;
    }

    /**
     * 个人常规解法：一次遍历全部搞定，前两个字母就可以判定是三种情况中的哪个
     * 34ms 47.46%
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        if (word == null || "".equals(word)) {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }

        char[] chars = word.toCharArray();
        if (Character.isLowerCase(chars[0])) {
            // 都是小写
            for (int i = 1; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i])) {
                    return false;
                }
            }
            return true;
        } else {
            if (Character.isLowerCase(chars[1])) {
                for (int i = 2; i < chars.length; i++) {
                    if (Character.isUpperCase(chars[i])) {
                        return false;
                    }
                }
                return true;
            } else {
                // 都是大写
                for (int i = 2; i < chars.length; i++) {
                    if (Character.isLowerCase(chars[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new DetectCapital().detectCapitalUseAPI("UsA"));
        System.out.println(new DetectCapital().detectCapitalUse("UsA"));
    }
}
