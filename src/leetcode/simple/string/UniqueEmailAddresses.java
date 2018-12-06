package leetcode.simple.string;

import java.util.HashSet;

/**
 * @description: 929. 独特的电子邮件地址
 * @see: <a>https://leetcode-cn.com/problems/unique-email-addresses/</a>
 * @author: guoping wang
 * @date: 2018/12/6 20:42
 * @project: cc-leetcode
 */
public class UniqueEmailAddresses {

    /**
     * 个人常规解法：HashSet去重
     * 35ms 84.83%
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {
        HashSet<String> res = new HashSet<>();
        for (String email : emails) {
            int aIndex = email.lastIndexOf("@");
            String suffix = email.substring(0, aIndex);
            suffix = suffix.replace(".", "");
            int addIndex = suffix.indexOf("+");
            res.add(suffix.substring(0, addIndex) + email.substring(aIndex));
        }
        return res.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(new UniqueEmailAddresses().numUniqueEmails(emails));
    }
}
