package gold.iii;

import java.io.*;
import java.util.*;

public class B_14442_벽부수고이동하기2 {

    static class Node {

        int r, c, status, distance;

        Node (int r, int c, int status, int distance) {
            this.r = r;
            this.c = c;
            this.status = status;
            this.distance = distance;
        }
    }

    static int N, M, K;
    static int[][] field, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][][] visited;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(sb);
    }

    static void process() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.r == N - 1 && cur.c == M - 1) {
                sb.append(cur.distance);
                return;
            }

            for (int d = 0; d < dir.length; d++) {
                int nr = cur.r + dir[d][0];
                int nc = cur.c + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if (field[nr][nc] == 0 && !visited[nr][nc][cur.status]) {
                    visited[nr][nc][cur.status] = true;
                    queue.offer(new Node(nr, nc, cur.status, cur.distance + 1));
                }

                if (field[nr][nc] == 1 && cur.status + 1 <= K && !visited[nr][nc][cur.status + 1]) {
                    visited[nr][nc][cur.status + 1] = true;
                    queue.offer(new Node(nr, nc, cur.status + 1, cur.distance + 1));
                }
            }
        }

        sb.append(-1);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        field = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                field[i][j] = str.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M][K + 1];
    }
}
