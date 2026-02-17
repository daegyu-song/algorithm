package d3;

import java.io.*;
import java.util.*;

public class S_NQueen {

    static int N, cnt;
    static boolean[] column, slash, bSlash;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process(0);

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void process(int row) {
        if (row == N) {
            cnt++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (column[c] || slash[row + c] || bSlash[row - c + N - 1]) continue;

            column[c] = slash[row + c] = bSlash[row - c + N - 1] = true;
            process(row + 1);
            column[c] = slash[row + c] = bSlash[row - c + N - 1] = false;
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        column = new boolean[N];
        slash = new boolean[2 * N - 1];
        bSlash = new boolean[2 * N - 1];

        cnt = 0;
    }
}