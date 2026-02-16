package d5;

import java.io.*;
import java.util.*;

public class S_수제버거장인 {

    static int N, M, count;
    static int[][] pairs;
    static boolean[] selected;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            subset(0);

            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }

    static void subset(int cnt) {

        for (int i = 0; i < M; i++) {
            int a = pairs[i][0] - 1;
            int b = pairs[i][1] - 1;

            if (a < cnt && b < cnt) {
                if (selected[a] && selected[b]) return;
            }
        }

        if (cnt == N) {
            count++;

            return;
        }

        selected[cnt] = true;
        subset(cnt + 1);

        selected[cnt] = false;
        subset(cnt + 1);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pairs = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                pairs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new boolean[N];

        count = 0;
    }
}
