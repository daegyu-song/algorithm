package d3;

import java.io.*;
import java.util.*;

public class S_NQueen {

    static int N, totalCnt;
    static boolean[] col, slash, bSlash;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init();
            setQueen(0);

            sb.append("#").append(tc).append(" ").append(totalCnt).append("\n");
        }

        System.out.println(sb);
    }

    static void setQueen(int row) {

        if (row > N - 1) {
            totalCnt++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (col[c] || slash[row + c] || bSlash[(row - c) + N - 1]) continue;

            col[c] = slash[row + c] = bSlash[(row - c) + N - 1] = true;
            setQueen(row + 1);
            col[c] = slash[row + c] = bSlash[(row - c) + N - 1] = false;
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        totalCnt = 0;

        col = new boolean[N];
        slash = new boolean[2 * N - 1];
        bSlash = new boolean[2 * N - 1];
    }
}