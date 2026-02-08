import java.io.*;
import java.util.*;

public class S_벌꿀채취 {

    static int N, M, C, max;
    static int[][] field, maxField;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init();
            createMaxField();
            process();
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        int first = 0, second = 0, start = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - M + 1; j++) {
                first = maxField[i][j];

                for (int q = i; q < N; q++) {
                    start = q == i ? j + M : 0;
                    for (int k = start; k < N - M + 1; k++) {
                        second = maxField[q][k];
                        max = Math.max(max, first + second);
                    }
                }
            }
        }
    }

    static void createMaxField() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - M + 1; j++) {
                subset(i, j, 0, 0, 0);
            }
        }
    }

    static void subset(int i, int j, int cnt, int sum, int mul) {

        if (sum > C) return;

        if (cnt == M) {
            maxField[i][j - M] = Math.max(maxField[i][j - M], mul);
            return;
        }

        subset(i, j + 1, cnt + 1, sum + field[i][j], mul + field[i][j] * field[i][j]);

        subset(i, j + 1, cnt + 1, sum, mul);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = Integer.MIN_VALUE;
        maxField = new int[N][N - M + 1];
    }
}
