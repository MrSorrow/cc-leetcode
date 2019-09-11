package internship.bytedance;

import java.util.*;

/*
1
8
2 1 1 2 2
2 1 1 1 4
2 1 1 2 2
2 2 2 1 4
0
0
1 1 1
1 1 1

3
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();

        for (int i = 0; i < testNum; i++) {
            int frames = scanner.nextInt();
            HashMap<Feature, Integer> map = new HashMap<>();
            int max = 0;

            for (int j = 0; j < frames; j++) {
                int features = scanner.nextInt();
                List<Feature> featureList = new ArrayList<>(features);

                for (int k = 0; k < features; k++) {
                    Feature feature = new Feature(scanner.nextInt(), scanner.nextInt());
                    featureList.add(feature);

                    // 每过来一个feature,再原来的基础上+1
                    if (map.containsKey(feature)) {
                        map.put(feature, map.get(feature) + 1);
                    } else {
                        map.put(feature, 1);
                    }

                    if (map.get(feature) > max) {
                        max = map.get(feature);
                    }

                }

                // 当前帧没有出现的feature，map要清零
                for (Feature f : map.keySet()) {
                    if (!featureList.contains(f)) {
                        map.put(f, 0);
                    }
                }
            }

            System.out.println(max);
        }

    }

    static class Feature {
        int x;
        int y;

        public Feature(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Feature feature = (Feature) o;

            if (x != feature.x) return false;
            return y == feature.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
