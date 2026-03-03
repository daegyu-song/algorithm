package d4;

import java.io.*;
import java.util.*;

public class S_4206_연구소탈출 {

    static class Node {

        int r, c, time;

        Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int N, M;
    static int[][] field, virusTime, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static Queue<Node> virusQueue;
    static Queue<Node> humanQueue;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();

            sb.append("#").append(tc).append(" ");
            process();
        }

        System.out.println(sb);
    }

    static void process() {

        boolean canZombie = false;

        while (!virusQueue.isEmpty()) {
            Node cur = virusQueue.poll();

            for (int d = 0; d < dir.length; d++) {
                int nr = cur.r + dir[d][0];
                int nc = cur.c + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (field[nr][nc] == 1) continue;
                if (virusTime[nr][nc] != Integer.MAX_VALUE) continue;

                virusTime[nr][nc] = cur.time + 1;
                virusQueue.add(new Node(nr, nc, cur.time + 1));
            }
        }

        while (!humanQueue.isEmpty()) {
            Node cur = humanQueue.poll();

            for (int d = 0; d < dir.length; d++) {
                int nr = cur.r + dir[d][0];
                int nc = cur.c + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    sb.append(cur.time + 1).append("\n");
                    return;
                }

                if (field[nr][nc] == 1) continue;
                if (visited[nr][nc]) continue;
                if (cur.time + 1 >= virusTime[nr][nc]) {
                    canZombie = true;
                    continue;
                }

                visited[nr][nc] = true;
                humanQueue.add(new Node(nr, nc, cur.time + 1));
            }
        }

        if (canZombie) sb.append("ZOMBIE").append("\n");
        else sb.append("CANNOT ESCAPE").append("\n");
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        virusQueue = new ArrayDeque<>();
        humanQueue = new ArrayDeque<>();

        virusTime = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(virusTime[i], Integer.MAX_VALUE);

        field = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());

                if (field[i][j] == 2) {
                    virusTime[i][j] = 0;
                    virusQueue.add(new Node(i, j, 0));
                }
                else if (field[i][j] == 3) {
                    visited[i][j] = true;
                    humanQueue.add(new Node(i, j, 0));
                }
            }
        }
    }
}
