package leetcode.simple.string;

import java.util.HashMap;

/**
 * @description: 13. 罗马数字转整数
 * @link: <a>https://leetcode-cn.com/problems/roman-to-integer/</a>
 * @author: guoping wang
 * @date: 2018/9/24 21:06
 * @project: cc-leetcode
 */
public class RomanToInteger {

    /**
     * 个人常规解法：分割字符串,hashmap存放键值对
     * 120ms 17.44%
     * @param s
     * @return
     */
    public int romanToInt(String s) {

        HashMap<Character, Integer> hashMap = new HashMap<>(7);
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int index = 0;
        int length = s.length();
        int sum = 0;

        while (index < length) {
            // 是否连体
            if (index < length - 1 && hashMap.get(s.charAt(index)) < hashMap.get(s.charAt(index + 1))) {
                sum = sum + hashMap.get(s.charAt(index + 1)) - hashMap.get(s.charAt(index));
                index+=2;
            } else {
                sum += hashMap.get(s.charAt(index));
                index++;
            }
        }
        return sum;
    }

    /**
     * 最快的算法：果然还是hashmap太慢了，用swith-case
     * 72ms 83.97%
     * @param s
     * @return
     */
    public int romanToIntFast(String s) {
        int index = 0;
        int length = s.length();
        int sum = 0;

        while (index < length) {
            // 是否连体
            if (index < length - 1 && getValue(s.charAt(index)) < getValue(s.charAt(index + 1))) {
                sum = sum + getValue(s.charAt(index + 1)) - getValue(s.charAt(index));
                index+=2;
            } else {
                sum += getValue(s.charAt(index));
                index++;
            }
        }
        return sum;
    }

    public int getValue(Character c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToIntFast("III"));
        System.out.println(new RomanToInteger().romanToIntFast("LVIII"));
        System.out.println(new RomanToInteger().romanToIntFast("MCMXCIV"));
    }
}
