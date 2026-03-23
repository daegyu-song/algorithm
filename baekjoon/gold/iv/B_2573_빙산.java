package gold.iv;

import java.io.*;
import java.util.*;

public class B_2573_빙산 {

    static int N, M, date, cnt;
    static int[][] field, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    static void process() {
        count();

        while (true) {
            if (cnt == 0) {
                System.out.println(0);
                return;
            }

            if (cnt >= 2) {
                System.out.println(date);
                return;
            }

            date++;
            melt();
            count();
        }
    }

    static void melt() {
        int[][] next = new int[N][M];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (field[r][c] == 0) continue;

                int sea = 0;
                for (int d = 0; d < dir.length; d++) {
                    int nr = r + dir[d][0];
                    int nc = c + dir[d][1];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                    if (field[nr][nc] != 0) continue;

                    sea++;
                }

                next[r][c] = Math.max(0, field[r][c] - sea);
            }
        }

        field = next;
    }


    static void count() {
        cnt = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (field[r][c] == 0) continue;
                if (visited[r][c]) continue;

                cnt++;
                dfs(r, c);
            }
        }
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (visited[nr][nc]) continue;
            if (field[nr][nc] == 0) continue;

            dfs(nr, nc);
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new int[N][M];
        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
    }
}
