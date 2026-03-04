package gold.iii;

import java.io.*;
import java.util.*;

public class B_4179_불_V2 {

    static class Node {

        int r, c, time;
        char status;

        Node(int r, int c, int time, char status) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.status = status;
        }
    }

    static int R, C;
    static int[][] fire, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] field;
    static boolean[][] visited;
    static Queue<Node> fireQueue;
    static Queue<Node> humanQueue;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(sb);
    }

    static void process() {
        while (!fireQueue.isEmpty()) {
            Node cur = fireQueue.poll();

            for (int d = 0; d < dir.length; d++) {
                int nr = cur.r + dir[d][0];
                int nc = cur.c + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (field[nr][nc] != '.') continue;
                if (fire[nr][nc] != Integer.MAX_VALUE) continue;

                fire[nr][nc] = cur.time + 1;
                fireQueue.offer(new Node(nr, nc, cur.time + 1, cur.status));
            }
        }

        while (!humanQueue.isEmpty()) {
            Node cur = humanQueue.poll();

            for (int d = 0; d < dir.length; d++) {
                int nr = cur.r + dir[d][0];
                int nc = cur.c + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    sb.append(cur.time + 1);
                    return;
                }
                if (field[nr][nc] != '.') continue;
                if (visited[nr][nc]) continue;
                if (cur.time + 1 >= fire[nr][nc]) continue;

                visited[nr][nc] = true;
                humanQueue.offer(new Node(nr, nc, cur.time + 1, cur.status));
            }
        }

        sb.append("IMPOSSIBLE");
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        fireQueue = new ArrayDeque<>();
        humanQueue = new ArrayDeque<>();

        fire = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(fire[i], Integer.MAX_VALUE);
        }

        visited = new boolean[R][C];

        field = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                field[i][j] = str.charAt(j);

                if (field[i][j] == 'J') {
                    humanQueue.offer(new Node(i, j, 0, 'J'));
                    visited[i][j] = true;
                } else if (field[i][j] == 'F') {
                    fireQueue.offer(new Node(i, j, 0, 'F'));
                    fire[i][j] = 0;
                }
            }
        }
    }
}
