package gold.ii;

import java.io.*;
import java.util.*;

public class B_4195_친구네트워크 {

    static int F;
    static int[] parents;
    static String[][] friends;
    static Map<String, Integer> map;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            init();
            process();
        }

        System.out.println(sb);
    }

    static void process() {
        for (int i = 0; i < F; i++) {
            int a = map.get(friends[i][0]);
            int b = map.get(friends[i][1]);

            union(a, b);
            int findNum = find(a);
            sb.append(Math.abs(parents[findNum])).append("\n");
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        if (parents[a] < parents[b]) {
            parents[a] += parents[b];
            parents[b] = a;
        } else {
            parents[b] += parents[a];
            parents[a] = b;
        }
    }

    static int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    static void init() throws IOException {
        F = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        friends = new String[F][];

        int idx = 1;
        for (int i = 0; i < F; i++) {
            String input = br.readLine();
            friends[i] = input.split(" ");

            for (int j = 0; j < 2; j++) {
                if (map.containsKey(friends[i][j])) continue;
                map.put(friends[i][j], idx++);
            }
        }

        parents = new int[idx];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = -1;
        }
    }
}
