import java.io.*;
import java.util.*;

public class S_4014_활주로건설 {

    static int N, X, cnt;
    static int[][] field;
    static boolean[] flag;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        for (int i = 0; i < N; i++) {
            checkColumn(i);
            checkRow(i);
        }
    }

    static void checkColumn(int r) {
        flag = new boolean[N];
        int prev = 0;

        for (int c = 1; c < N; c++) {

            if (field[r][prev] == field[r][c]) {
                prev++;
                continue;
            }

            if (Math.abs(field[r][c] - field[r][prev]) >= 2) return;

            if (field[r][c] - field[r][prev] > 0) {

                if (c - X < 0) return;

                int h = field[r][prev];
                for (int i = prev; i >= c - X; i--) {
                    if (field[r][i] != h) return;
                    if (flag[i]) return;
                }

                for (int i = prev; i >= c - X; i--) {
                    flag[i] = true;
                }

                prev++;

            } else {

                if (prev + X >= N) return;

                int h = field[r][c];
                for (int i = c; i <= c + X - 1; i++) {
                    if (field[r][i] != h) return;
                    if (flag[i]) return;
                }

                for (int i = c; i <= c + X - 1; i++) {
                    flag[i] = true;
                }

                c += X - 1;
                prev += X;
            }
        }

        cnt++;
    }

    static void checkRow(int c) {
        flag = new boolean[N];
        int prev = 0;

        for (int r = 1; r < N; r++) {

            if (field[prev][c] == field[r][c]) {
                prev++;
                continue;
            }

            if (Math.abs(field[r][c] - field[prev][c]) >= 2) return;

            if (field[r][c] - field[prev][c] > 0) {

                if (r - X < 0) return;

                int h = field[prev][c];
                for (int i = prev; i >= r - X; i--) {
                    if (field[i][c] != h) return;
                    if (flag[i]) return;
                }

                for (int i = prev; i >= r - X; i--) {
                    flag[i] = true;
                }

                prev++;

            } else {

                if (prev + X >= N) return;

                int h = field[r][c];
                for (int i = r; i <= r + X - 1; i++) {
                    if (field[i][c] != h) return;
                    if (flag[i]) return;
                }

                for (int i = r; i <= r + X - 1; i++) {
                    flag[i] = true;
                }

                r += X - 1;
                prev += X;
            }
        }

        cnt++;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;
    }
}
