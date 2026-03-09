package d4;

import java.io.*;
import java.util.*;

public class S_1868_파핑파핑지뢰찾기 {

    static int N, cnt;
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    static char[][] field;
    static boolean[][] visited;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (field[i][j] != '.') continue;
                if (visited[i][j]) continue;
                if (!isZero(i, j)) continue;

                cnt++;
                bfs(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (field[i][j] == '.' && !visited[i][j]) cnt++;
            }
        }
    }

    static void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < dir.length; d++) {
                int nr = cur[0] + dir[d][0];
                int nc = cur[1] + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (field[nr][nc] == '*') continue;

                visited[nr][nc] = true;

                if (isZero(nr, nc)) queue.offer(new int[]{nr, nc});
            }
        }
    }

    static boolean isZero(int r, int c) {
        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if (field[nr][nc] == '*') return false;
        }

        return true;
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        field = new char[N][N];
        for (int i = 0; i < N; i++) {
            field[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][N];
        cnt = 0;
    }
}
