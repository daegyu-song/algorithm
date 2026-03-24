package gold.v;

import java.io.*;
import java.util.*;

public class B_17070_파이프옮기기1 {

    static int N, result;
    static int[][] field, dir = {{0, 1}, {1, 0}, {1, 1}};

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 1, 0);

        System.out.println(result);
    }

    static void dfs(int r, int c, int status) {


        if (r == N - 1 && c == N - 1) {
            result++;
            return;
        }

        for (int d = 0; d < 3; d++) {
            if (status == 0 && d == 1) continue;
            if (status == 1 && d == 0) continue;

            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr >= N || nc >= N) continue;
            if (field[nr][nc] != 0) continue;

            if (d == 2) {
                if (field[nr - 1][nc] != 0) continue;
                if (field[nr][nc - 1] != 0) continue;
            }

            dfs(nr, nc, d);
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
