package internship.jd;

/**
 * @description:
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/4/13 8:57 PM
 * @project: cc-leetcode
 */
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Iterator;

class LengthCompare implements Comparator {   //定义比较器
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;

        int temp = s1.length()-s2.length();

        return temp==0? s1.compareTo(s2):temp;
    }

}

public class SubStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            int n = input.nextInt();
            TreeSet<String> ss = new TreeSet(new LengthCompare());

            input.nextLine();
            for (int j = 0; j < n; j++) {
                String tmp  = input.nextLine();
                ss.add(tmp);
            }


            String T = input.nextLine();
            int[] dp = new int[T.length()];
            String lastString = "";
            int result = 0;
            for (int j = 0; j < T.length(); j++) {
                char tmpChar = T.charAt(j);

                if(contains(ss,"" + tmpChar))
                {
                    String tmpString = "" + tmpChar;
                    String lasttmpString = lastString + tmpChar;

                    if(equal(ss, tmpString)) {
                        result ++;
                        lastString = "";
                    } else if(equal(ss, lasttmpString)) {
                        result ++;
                        lastString = "";
                    } else if(contains(ss, lasttmpString)) {
                        lastString = lasttmpString;
                    } else {
                        lastString = "" + tmpChar;
                    }
                } else {
                    lastString = "";
                }
            }

            System.out.println(result);
        }


    }

    public static boolean contains(TreeSet<String> ss, String str) {
        boolean re = false;
        Iterator<String> it = ss.iterator();

        while (it.hasNext())
        {
            String tmp = it.next();
            if(tmp.contains(str)) {
                re = true;
                break;
            }
        }
        return re;
    }

    public static boolean equal(TreeSet<String> ss, String str) {
        boolean re = false;
        Iterator it = ss.iterator();

        while (it.hasNext())
        {
            Object tmp = it.next();
            if(tmp.equals(str)) {
                re = true;
                break;
            }
        }
        return re;
    }
}

