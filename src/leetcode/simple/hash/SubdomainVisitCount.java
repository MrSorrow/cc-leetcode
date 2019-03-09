package leetcode.simple.hash;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 811. 子域名访问计数
 * @see: <a>https://leetcode-cn.com/problems/subdomain-visit-count/</a>
 * @author: guoping wang
 * @date: 2018/10/11 9:31
 * @project: cc-leetcode
 */
public class SubdomainVisitCount {

    /**
     * 个人常规解法：用HashMap存储，然后进行整合成list
     * 17ms 98.95%
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> resMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int space = cpdomain.indexOf(" ");
            int visit = Integer.valueOf(cpdomain.substring(0, space));
            cpdomain = cpdomain.substring(space + 1);
            while (!cpdomain.equals("")) {
                if (resMap.containsKey(cpdomain)) {
                    resMap.put(cpdomain, resMap.get(cpdomain) + visit);
                } else {
                    resMap.put(cpdomain, visit);
                }

                int dot = cpdomain.indexOf(".");
                if (dot == -1) {
                    break;
                }
                cpdomain = cpdomain.substring(dot + 1);
            }
        }

        // resMap--->list
        List<String> resList = new ArrayList<>(resMap.size());
        for (String s : resMap.keySet()) {
            resList.add(resMap.get(s) + " " + s);
        }

        return resList;
    }


    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        ListUtils.printLists(new SubdomainVisitCount().subdomainVisits(cpdomains));
    }
}
