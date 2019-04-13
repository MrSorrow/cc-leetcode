package internship.huawei;

import java.util.*;

/**
 * 将一个以空格分割的字符串，每八位进行分割成新的字符串，最后按照字母序排序
 */
public class SpiltString {

    public static String[] padding = {"0000000", "000000", "00000", "0000", "000", "00", "0", ""};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] array = line.split("\\s");
        ArrayList<String> res = new ArrayList<>();

        for (int i = 1; i < array.length; i++) {
            solution(array[i], res);
        }

        Collections.sort(res);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i < res.size() - 1) System.out.print(" ");
        }
    }

    private static void solution(String str, ArrayList<String> res) {
        int index = 0;
        while (index + 8 < str.length()) {
            res.add(str.substring(index, index + 8));
            index += 8;
        }
        if (index < str.length()) {
            res.add(str.substring(index) + padding[str.length() - index - 1]);
        }
    }
}
