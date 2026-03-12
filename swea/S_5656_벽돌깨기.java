import java.io.*;
import java.util.*;

public class S_5656_벽돌깨기 {

    static int N, W, H, totalCnt;
    static int[] start;
    static int[][] field, copy, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process(0);

            sb.append("#").append(tc).append(" ").append(totalCnt).append("\n");
        }

        System.out.println(sb);
    }

    static void process(int cnt) {
        if (cnt == N) {
            start();
            return;
        }

        for (int i = 0; i < W; i++) {
            start[cnt] = i;

            process(cnt + 1);
        }
    }

    static void start() {
        copyField();

        for (int i = 0; i < start.length; i++) {
            for (int j = 0; j < H; j++) {
                if (copy[j][start[i]] == 0) continue;

                dfs(j, start[i], copy[j][start[i]]);

                applyGravity();

                break;
            }
        }

        count();
    }

    static void dfs(int r, int c, int range) {
        copy[r][c] = 0;

        for (int i = 1; i < range; i++) {
            for (int d = 0; d < dir.length; d++) {
                int nr = r + dir[d][0] * i;
                int nc = c + dir[d][1] * i;

                if (nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
                if (copy[nr][nc] == 0) continue;

                dfs(nr, nc, copy[nr][nc]);
            }
        }
    }

    static void applyGravity() {
        for (int i = 0; i < W; i++) {
            for (int j = H - 1; j > 0; j--) {
                if (copy[j][i] == 0) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (copy[k][i] == 0) continue;

                        copy[j][i] = copy[k][i];
                        copy[k][i] = 0;
                        break;

                    }
                }
            }
        }
    }

    static void copyField() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                copy[i][j] = field[i][j];
            }
        }
    }

    static void count() {
        int cur = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (copy[i][j] > 0) cur++;
            }
        }

        totalCnt = Math.min(totalCnt, cur);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        field = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        copy = new int[H][W];
        start = new int[N];
        totalCnt = Integer.MAX_VALUE;
    }
}
