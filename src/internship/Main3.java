package internship;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            HashMap<String, Integer> map = new HashMap<>();

            StringBuffer rr = new StringBuffer();
            String[] pathN = input.nextLine().split(" ");

            for (int i = 1; i < pathN.length; i++) {

                String[] te = pathN[i].split("/");

                for (int j = 1; j < te.length; j++) {
                    // String string = te[j];

                    if (map.containsKey(te[j])) {
                        map.put(te[j], map.get(te[j]) + 1);
                    } else {
                        map.put(te[j], 1);
                    }


                    if (i == 1) {
                        rr.append("1");
                    } else if (i == pathN.length - 1) {
                        rr.append("1");
                    } else {
                        rr.append(map.get(te[j]));
                    }
                }

                if (i != pathN.length - 1) {
                    rr.append(" ");
                }
            }
            System.out.println(rr);
        }
    }
}
