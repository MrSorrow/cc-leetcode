package internship;

import java.util.*;

public class Main3 {

    public static void main(String[] args)
    {

        Scanner input =new Scanner(System.in);

        while(input.hasNext())
        {
            HashMap<String, Integer> map = new HashMap<>();

            // int n = input.nextInt();
            //String[] s = new String[n];
            //int[] re = new int[n];

            StringBuffer rr = new StringBuffer();
            String[] pathN = input.nextLine().split(" ");


			/*String[] tt = "/order/sda/asa/bbb".split("/");
			System.out.println(tt.length);

			for (int i = 0; i < tt.length; i++) {
				System.out.println(tt[i]);
			}*/

            // System.out.println(pathN.length);
            for (int i = 1; i < pathN.length; i++) {

                String tmp = pathN[i];
                String[] te = pathN[i].split("/");

                int  c = 0;
                if(map.containsKey(tmp)) {
                    c = map.get(tmp) + 1;
                    map.put(pathN[i], c);
                } else {
                    c = 1;
                    map.put(tmp, 1);
                }

                // System.out.println(map);
                // System.out.println("as"+c);

                for (int j = 1; j < te.length; j++) {
                    // String string = te[j];

                    if(j == 1) {
                        rr.append("1");
                    } else if (j == te.length - 1) {
                        rr.append("1");
                    } else {
                        System.out.println("as1: "+c);
                        rr.append(c);
                    }
                }

                if(i != pathN.length - 1) {
                    rr.append(" ");
                }

            }
            System.out.println(rr);


        }

    }

}
