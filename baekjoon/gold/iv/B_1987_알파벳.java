package gold.iv;

import java.io.*;
import java.util.*;

public class B_1987_알파벳 {

    static int R, C, cnt;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] field;
    static boolean[] visited;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 0, 1);

        System.out.println(cnt);
    }

    static void dfs(int r, int c, int currentCnt) {
        visited[field[r][c] - 65] = true;

        cnt = Math.max(cnt, currentCnt);

        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if (visited[field[nr][nc] - 65]) continue;

            dfs(nr, nc, currentCnt + 1);
        }

        visited[field[r][c] - 65] = false;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        field = new char[R][C];
        for (int i = 0; i < R; i++) {
            field[i] = br.readLine().toCharArray();
        }

        cnt = 0;
        visited = new boolean[26];
    }
}
