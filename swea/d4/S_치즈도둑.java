package d4;

import java.io.*;
import java.util.*;

public class S_치즈도둑 {

    static int N, maxCnt, maxDay;
    static int[][] field, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(maxCnt).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        for (int day = 0; day < maxDay; day++) {
            visited = new boolean[N][N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && field[i][j] > day) {
                        count++;
                        dfs(i, j, day);
                    }
                }
            }

            maxCnt = Math.max(maxCnt, count);
        }
    }

    static void dfs(int r, int c, int day) {
        visited[r][c] = true;

        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if (visited[nr][nc]) continue;
            if (field[nr][nc] <= day) continue;

            dfs(nr, nc, day);
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        maxDay = 0;
        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                maxDay = Math.max(maxDay, field[i][j]);
            }
        }

        maxCnt = 0;
    }
}
