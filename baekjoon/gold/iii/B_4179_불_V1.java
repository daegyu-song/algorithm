package gold.iii;

import java.io.*;
import java.util.*;

public class B_4179_불_V1 {

    static class Node {
        int r, c, time;
        char status;

        Node (int r, int c, int time, char status) {
            this.r = r;
            this.c = c;
            this.time= time;
            this.status = status;
        }
    }

    static int R, C;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] field;
    static Queue<Node> queue;
    static Node start;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(sb);
    }

    static void process() {
        queue.add(start);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int d = 0; d < dir.length; d++) {
                int nr = cur.r + dir[d][0];
                int nc = cur.c + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    if (cur.status == 'J') {
                        sb.append(cur.time + 1);
                        return;
                    }
                    continue;
                }

                if (field[nr][nc] != '.') continue;

                queue.add(new Node(nr, nc, cur.time + 1, cur.status));
                field[nr][nc] = cur.status;
            }
        }

        sb.append("IMPOSSIBLE");
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        queue = new ArrayDeque<>();

        field = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                field[i][j] = str.charAt(j);

                if (field[i][j] == 'F') queue.offer(new Node(i, j, 0, 'F'));
                else if (field[i][j] == 'J') start = new Node(i, j, 0, 'J');
            }
        }
    }
}
