package gold.iv;

import java.io.*;
import java.util.*;

public class B_1043_거짓말 {

    static int N, M, result;
    static int[] parents;
    static int[][] parties;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(result);
    }

    static void process() {

        int truthRoot = find(0);

        for (int[] members : parties) {
            boolean canLie = true;
            for (int member : members) {
                if (find(member) == truthRoot) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) result++;
        }
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parents[b] = a;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        for (int i = 0; i < total; i++) {
            union(0, Integer.parseInt(st.nextToken()));
        }

        parties = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            parties[i] = new int[size];
            for (int j = 0; j < size; j++) {
                parties[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < size; j++) {
                union(parties[i][0], parties[i][j]);
            }
        }
    }
}
