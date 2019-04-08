package internship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int k = Integer.valueOf(scanner.nextLine());

        if (line.length() > 2) {
            String[] strs = line.substring(1, line.length() - 1).split(",");
            String[] strsCopy = new String[strs.length];

            int index = 0, add = 0;
            while (strs.length - index >= k) {
                for (int i = index + k - 1; i >= index; i--) {
                    strsCopy[add++] = strs[i];
                }
                index += k;
            }
            if (index < strs.length) {
                for (int i = index; i < strs.length; i++) {
                    strsCopy[add++] = strs[i];
                }
            }

            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < strsCopy.length; i++) {
                sb.append(strsCopy[i]);
                if (i < strsCopy.length - 1) sb.append(",");
            }
            sb.append("]");
            System.out.println(sb.toString());

        } else {
            System.out.println(line);
        }
    }
}
