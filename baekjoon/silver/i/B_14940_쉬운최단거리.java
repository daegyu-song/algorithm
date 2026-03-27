package silver.i;

import java.io.*;
import java.util.*;

public class B_14940_쉬운최단거리 {

    static int n, m;
    static int[] start;
    static int[][] field, result, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        bfs();

        System.out.println(sb);
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start[0], start[1]});
        result[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < dir.length; d++) {
                int nr = cur[0] + dir[d][0];
                int nc = cur[1] + dir[d][1];

                if (nr < 0 || nc < 0|| nr >= n || nc >= m) continue;
                if (field[nr][nc] == 0) continue;
                if (result[nr][nc] != -1) continue;

                result[nr][nc] = result[cur[0]][cur[1]] + 1;
                queue.offer(new int[] {nr, nc});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[n][m];
        for (int[] arr : result) {
            Arrays.fill(arr, -1);
        }

        field = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if (field[i][j] == 2) start = new int[] {i, j};
                else if (field[i][j] == 0) result[i][j] = 0;
            }
        }
    }
}
