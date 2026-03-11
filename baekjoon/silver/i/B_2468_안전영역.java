package silver.i;

import java.io.*;
import java.util.*;

public class B_2468_안전영역 {

    static int N, height, max;
    static int[][] field, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(max);
    }

    static void process() {
        for (int h = 0; h <= height; h++) {
            visited = new boolean[N][N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] <= h) continue;
                    if (visited[i][j]) continue;

                    cnt++;
                    dfs(i, j, h);
                }
            }

            max = Math.max(max, cnt);
        }
    }

    static void dfs(int r, int c, int h) {
        visited[r][c] = true;

        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if (field[nr][nc] <= h) continue;
            if (visited[nr][nc]) continue;

            dfs(nr, nc, h);
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, field[i][j]);
            }
        }
    }
}
