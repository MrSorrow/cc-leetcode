package internship.pdd;

import java.util.HashMap;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] example = line.split(" ");
        int num = Integer.valueOf(example[0]);
        HashMap<String, Integer> counter = new HashMap<>();

        String[] res = new String[example.length - 1];

        for (int i = 1; i < example.length; i++) {
            StringBuilder sb = new StringBuilder();
            Integer times = counter.getOrDefault(example[i], 0);
            counter.put(example[i], times + 1);

            String[] paths = example[i].substring(1).split("/");
            for (int j = 0; j < paths.length; j++) {
                if (j == 0 || j == paths.length - 1) sb.append("1");
                else {
                    sb.append(times + 1);
                }
            }

            res[i - 1] = sb.toString();
        }

        for (int i = 0; i < num; i++) {
            System.out.print(res[i]);
            if (i != num - 1) System.out.print(" ");
        }
    }
}
