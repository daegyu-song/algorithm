import java.io.*;
import java.util.*;

public class S_벌꿀채취 {

    static int N, M, C, maxRevenue;
    static int[][] honey, revenue;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            createMoneyArr();
            combination();

            sb.append("#").append(tc).append(" ").append(maxRevenue).append("\n");
        }

        System.out.println(sb);
    }

    static void combination() {
        int first = 0, second = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - M + 1; j++) {
                first= revenue[i][j];

                for (int q = i; q < N; q++) {
                    int start = q == i ? j + M : 0;
                    for (int k = start; k < N - M + 1; k++) {
                        second = revenue[q][k];
                        maxRevenue = Math.max(maxRevenue, first + second);
                    }
                }
            }
        }
    }

    static void createMoneyArr() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - M + 1; j++) {
                subset(i, j, 0, 0, 0);
            }
        }
    }

    static void subset(int i, int j, int cnt, int sum, int mul) {
        if (sum > C) return;

        if (cnt == M) {
            revenue[i][j - M] = Math.max(revenue[i][j - M], mul);
            return;
        }

        subset(i, j + 1, cnt + 1, sum + honey[i][j], mul + honey[i][j] * honey[i][j]);

        subset(i, j + 1, cnt + 1, sum, mul);
    }

    static void init() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        honey = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                honey[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        revenue = new int[N][N - M + 1];

        maxRevenue = Integer.MIN_VALUE;
    }
}