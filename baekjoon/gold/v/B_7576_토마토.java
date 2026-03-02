package gold.v;

import java.io.*;
import java.util.*;

public class B_7576_토마토 {

    static int N, M, day;
    static int[][] field, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(day);
    }

    static void process() {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 1) queue.offer(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int d = 0; d < dir.length; d++) {
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (field[nr][nc] != 0) continue;

                field[nr][nc] = field[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 0) {
                    day = -1;
                    return;
                }

                day = Math.max(day, field[i][j]);
            }
        }

        day -= 1;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        field = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
