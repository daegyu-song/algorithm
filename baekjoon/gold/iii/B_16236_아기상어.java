package gold.iii;

import java.io.*;
import java.util.*;

public class B_16236_아기상어 {

    static int N, r, c, size, eaten, result;
    static int[][] field, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(result);
    }

    static void process() {
        while (true) {
            int[] target = bfs();
            if (target == null) break;

            result += target[2];
            r = target[0];
            c = target[1];
            field[r][c] = 0;
            eaten++;

            if (eaten == size) {
                size++;
                eaten = 0;
            }
        }
    }

    static int[] bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[N][N];
        queue.offer(new int[] {r, c, 0});
        visited[r][c] = true;

        int[] target = null;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (target != null && cur[2] > target[2]) break;

            if (field[cur[0]][cur[1]] != 0 && field[cur[0]][cur[1]] < size) {
                if (target == null) {
                    target = new int[] {cur[0], cur[1], cur[2]};
                } else {
                    if (cur[0] < target[0] || (cur[0] == target[0] && cur[1] < target[1])) {
                        target = new int[] {cur[0], cur[1], cur[2]};
                    }
                }
            }

            for (int d = 0; d < dir.length; d++) {
                int nr = cur[0] + dir[d][0];
                int nc = cur[1] + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (field[nr][nc] > size) continue;

                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc, cur[2] + 1});
            }
        }

        return target;
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());

                if (field[i][j] == 9) {
                    r = i;
                    c = j;
                    field[i][j] = 0;
                }
            }
        }

        result = 0;
        size = 2;
        eaten = 0;
    }
}
