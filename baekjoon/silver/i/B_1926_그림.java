package silver.i;

import java.io.*;
import java.util.*;

public class B_1926_그림 {

    static int n, m, max, curCnt, totalCnt;
    static int[][] field, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(sb);
    }

    static void process() {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (field[r][c] == 0) continue;
                if (visited[r][c]) continue;

                totalCnt++;
                curCnt = 0;
                dfs(r, c);
                max = Math.max(max, curCnt);
            }
        }

        sb.append(totalCnt).append("\n").append(max);
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        curCnt++;

        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
            if (field[nr][nc] == 0) continue;
            if (visited[nr][nc]) continue;

            dfs(nr, nc);
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        field = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
    }
}
