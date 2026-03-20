package gold.iv;

import java.io.*;
import java.util.*;

public class B_16234_인구이동 {

    static int N, L, R, sum, result;
    static int[][] field, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean moved;
    static boolean[][] visited;
    static List<int[]> list;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(result);
    }

    static void process() {
        while (true) {
            visited = new boolean[N][N];
            moved = false;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (visited[r][c]) continue;

                    list = new ArrayList<>();
                    sum = 0;
                    bfs(r, c);

                    if (list.size() == 1) continue;

                    moved = true;
                    for (int[] arr : list) {
                        field[arr[0]][arr[1]] = sum / list.size();
                    }
                }
            }

            if (!moved) break;
            result++;
        }
    }

    static void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        list.add(new int[] {r, c});
        visited[r][c] = true;
        sum += field[r][c];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < dir.length; d++) {
                int nr = cur[0] + dir[d][0];
                int nc = cur[1] + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (Math.abs(field[cur[0]][cur[1]] - field[nr][nc]) < L || Math.abs(field[cur[0]][cur[1]] - field[nr][nc]) > R) continue;

                list.add(new int[] {nr, nc});
                visited[nr][nc] = true;
                sum += field[nr][nc];
                queue.offer(new int[] {nr, nc});
            }
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
