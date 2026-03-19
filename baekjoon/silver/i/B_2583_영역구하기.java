package silver.i;

import java.io.*;
import java.util.*;

public class B_2583_영역구하기 {

    static int M, N, K, cnt;
    static int[][] field, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static List<Integer> list;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(sb);
    }

    static void process() {
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (field[r][c] != 0) continue;
                if (visited[r][c]) continue;

                cnt = 0;
                dfs(r, c);
                list.add(cnt);
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (int i : list) {
            sb.append(i).append(" ");
        }
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        cnt++;

        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
            if (field[nr][nc] == 1) continue;
            if (visited[nr][nc]) continue;

            dfs(nr, nc);
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        field = new int[M][N];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int r = M - y2; r < M - y1; r++) {
                for (int c = x1; c < x2; c++) {
                    field[r][c] = 1;
                }
            }
        }

        visited = new boolean[M][N];
        list = new ArrayList<>();
    }
}
