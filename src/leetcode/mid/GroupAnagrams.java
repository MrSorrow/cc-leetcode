package leetcode.mid;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 49. 字母异位词分组
 * @see: <a>https://leetcode-cn.com/problems/group-anagrams/</a>
 * @author: guoping wang
 * @date: 2019/1/8 21:33
 * @project: cc-leetcode
 */
public class GroupAnagrams {

    /**
     * 个人常规解法：对字母进行排序就好了，这样字母异位词会变成统一的形式，用HashMap统计
     * 19ms 92.36%
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            if (map.containsKey(new String(array))) {
                map.get(new String(array)).add(strs[i]);
            } else {
                int finalI = i;
                map.put(new String(array), new ArrayList<String>() {{add(strs[finalI]);}});
            }
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        ListUtils.printLists(new GroupAnagrams().groupAnagrams(strs));
    }
}
