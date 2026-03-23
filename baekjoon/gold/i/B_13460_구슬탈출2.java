package gold.i;

import java.io.*;
import java.util.*;

public class B_13460_구슬탈출2 {

    static int N, M;
    static int[] redStart, blueStart;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] field;
    static boolean[][][][] visited;

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
        queue.offer(new int[] {redStart[0], redStart[1], blueStart[0], blueStart[1], 0});
        visited[redStart[0]][redStart[1]][blueStart[0]][blueStart[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int rr = cur[0], rc = cur[1], br = cur[2], bc = cur[3], cnt = cur[4];

            if (cnt == 10) continue;

            for (int d = 0; d < dir.length; d++) {
                int[] red = move(rr, rc, d);
                int[] blue = move(br, bc, d);

                if (field[blue[0]][blue[1]] == 'O') continue;
                if (field[red[0]][red[1]] == 'O') {
                    sb.append(cnt + 1);
                    return;
                }
                if (red[0] == blue[0] && red[1] == blue[1]) {
                    if (d == 0) {
                        if (rr < br) blue[0]++;
                        else red[0]++;
                    } else if (d == 1) {
                        if (rr > br) blue[0]--;
                        else red[0]--;
                    } else if (d == 2) {
                        if (rc < bc) blue[1]++;
                        else red[1]++;
                    } else {
                        if (rc > bc) blue[1]--;
                        else red[1]--;
                    }
                }

                if (visited[red[0]][red[1]][blue[0]][blue[1]]) continue;

                visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                queue.offer(new int[] {red[0], red[1], blue[0], blue[1], cnt + 1});

            }
        }

        sb.append(-1);
    }

    static int[] move(int r, int c, int d) {
        while (true) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (field[nr][nc] == '#') break;
            r = nr;
            c = nc;
            if (field[r][c] == 'O') break;
        }

        return new int[] {r, c};
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                field[i][j] = str.charAt(j);

                if (field[i][j] == 'R') redStart = new int[] {i, j};
                else if (field[i][j] == 'B') blueStart = new int[] {i, j};
            }
        }

        visited = new boolean[N][M][N][M];
    }
}
