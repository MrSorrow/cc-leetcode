package leetcode.mid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @description: 71. 简化路径
 * @see: <a>https://leetcode-cn.com/problems/simplify-path/</a>
 * @author: guoping wang
 * @date: 2019/3/6 21:28
 * @project: cc-leetcode
 */
public class SimplifyPath {

    /**
     * 个人常规解法：先简化/，然后通过删除的思想进行路径简化
     * 51ms 9.48%
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        // 将双//合并成/
        while (path.contains("//")) {
            path = path.replace("//", "/");
        }

        String[] strs = path.substring(1).split("/");
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(strs));
        for (ListIterator iterator = linkedList.listIterator(); iterator.hasNext(); ) {
            String s = (String) iterator.next();
            if (s.equals("..")) {
                iterator.previous();
                iterator.remove();
                if (iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            } else if (s.equals(".")) {
                iterator.remove();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : linkedList) {
            sb.append("/");
            sb.append(s);
        }
        return sb.toString().equals("") ? "/" : sb.toString();
    }

    /**
     * 个人常规解法：在上一种解法的基础上进行优化，利用栈的弹出
     * 16ms 92.46%
     * @param path
     * @return
     */
    public String simplifyPathStack(String path) {
        String[] strs = path.substring(1).split("/");
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            if ("".equals(s) || ".".equals(s)) continue;
            else if ("..".equals(s)) {
                stack.pollLast();
            } else {
                stack.add(s);
            }
        }
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.toString().equals("") ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPathStack("/a//b////c/d//././/.."));
    }
}
