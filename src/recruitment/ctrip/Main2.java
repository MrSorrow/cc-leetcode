package recruitment.ctrip;

/**
 * @description:
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/9/4 6:44 PM
 * @project: cc-leetcode
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        StringBuilder sb = new StringBuilder(expr);
        try {
            return resolve(sb).toString();
        } catch (RuntimeException e) {
            return "";
        }
    }

    static StringBuilder resolve(StringBuilder sb) throws RuntimeException {
        StringBuilder newSb = new StringBuilder();
        if (sb.lastIndexOf("(") == -1 && sb.indexOf(")") == -1) {
            return sb;
        } else if (sb.indexOf("(") > -1 && sb.indexOf(")") > -1) {
            int left = sb.indexOf("(");
            int right = findIndex(sb, left);
            newSb.append(sb.substring(0, left));
            newSb.append(resolve(new StringBuilder(sb.substring(left + 1, right))).reverse());
            newSb.append(resolve(new StringBuilder(sb.substring(right + 1))));
            return newSb;
        } else {
            throw new RuntimeException("括号不匹配");
        }
    }

    private static int findIndex(StringBuilder sb, int left) {
        int i = 1;
        for (int j = left + 1; j < sb.length(); j++) {
            if (sb.charAt(j) == '(') {
                i++;
            } else if (sb.charAt(j) == ')') {
                i--;
            }
            if (i == 0) {
                return j;
            }
        }
        return -1;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}

