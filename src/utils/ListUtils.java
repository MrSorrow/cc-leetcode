package utils;

import java.util.List;

/**
 * @description: list输出工具
 * @author: guoping wang
 * @date: 2018/8/28 9:06
 * @project: cc-leetcode
 */
public class ListUtils {

    public static void printLists(List list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
