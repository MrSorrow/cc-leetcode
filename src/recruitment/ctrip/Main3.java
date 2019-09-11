package recruitment.ctrip;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main3 {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    static int schedule(int m, int[] array) {
        return schedule(m, array, 0);
    }

    static int schedule(int m, int[] array, int start) {
        if (m == 1 || start >= array.length - 1) {
            int sum = 0;
            for (int i = start; i < array.length; i++) {
                sum += array[i];
            }
            return sum;
        }

        int min = Integer.MAX_VALUE;
        int cost = 0;
        for (int i = start; i < array.length; i++) {
            // start-i都是当前节点的
            cost += array[i];
            // i - 最后 m-1个节点分配
            int schedule = schedule(m - 1, array, i + 1);
            min = Math.min(Math.max(cost, schedule), min);
        }
        return min;
    }
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));    
    }
}
