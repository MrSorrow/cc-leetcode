package leetcode.simple.bit;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 784. 字母大小写全排列
 * @see: <a>https://leetcode-cn.com/problems/letter-case-permutation/</a>
 * @author: guoping wang
 * @date: 2018/10/20 22:08
 * @project: cc-leetcode
 */
public class LetterCasePermutation {

    /**
     * 个人常规解法：分治算法递归
     * 13ms 62.19%
     * @param S
     * @return
     */
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        letterCasePermutationCir(res, S, S.length());
        return res;
    }

    private List<String> letterCasePermutationCir(List<String> res, String s, int length) {
        List<String> singleIteratorRes = new ArrayList<>();
        if (s.length() == 0) {
            singleIteratorRes.add("");
            if ("".length() == length) {
                res.add("");
            }
            return singleIteratorRes;
        }
        if (s.charAt(0) <= '9' && s.charAt(0) >= '0') {
            for (String lastSingleIteratorRes : letterCasePermutationCir(res, s.substring(1), length)) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(0));
                sb.append(lastSingleIteratorRes);
                singleIteratorRes.add(sb.toString());
                if (sb.length() == length) {
                    res.add(sb.toString());
                }
            }
            return singleIteratorRes;
        } else {
            for (String lastSingleIteratorRes : letterCasePermutationCir(res, s.substring(1), length)) {
                StringBuilder sb1 = new StringBuilder();
                sb1.append(Character.toLowerCase(s.charAt(0)));
                sb1.append(lastSingleIteratorRes);
                singleIteratorRes.add(sb1.toString());
                if (sb1.length() == length) {
                    res.add(sb1.toString());
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toUpperCase(s.charAt(0)));
                sb2.append(lastSingleIteratorRes);
                singleIteratorRes.add(sb2.toString());
                if (sb1.length() == length) {
                    res.add(sb2.toString());
                }
            }
            return singleIteratorRes;
        }
    }

    /**
     * 更加优秀的递归：就是更改字母大小写，保存这两种情况
     * 5ms 100%
     * @param list
     * @param array
     * @param index
     */
    public void letterCasePermutationCirBetter(List<String> list, char[] array, int index){
        if(index==array.length){
            list.add(new String(array));
        }else{
            if(Character.isLetter(array[index])){
                array[index] = Character.toUpperCase(array[index]);
                letterCasePermutationCirBetter(list, array, index+1);
                array[index] = Character.toLowerCase(array[index]);
            }
            letterCasePermutationCirBetter(list, array, index+1);
        }

    }

    public static void main(String[] args) {
        ListUtils.printLists(new LetterCasePermutation().letterCasePermutation("a1b2"));
    }
}
