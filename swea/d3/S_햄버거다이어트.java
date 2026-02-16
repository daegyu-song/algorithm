package d3;

import java.io.*;
import java.util.*;

public class S_햄버거다이어트 {

    static int N, L, preference;
    static int[][] info;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            subset(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(preference).append("\n");
        }

        System.out.println(sb);
    }

    static void subset(int cnt, int taste, int kcal) {
        if (kcal > L) return;

        if (cnt == N) {
            preference = Math.max(preference, taste);
            return;
        }

        subset(cnt + 1, taste + info[cnt][0], kcal + info[cnt][1]);

        subset(cnt + 1, taste, kcal);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        info = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        preference = Integer.MIN_VALUE;
    }
}
