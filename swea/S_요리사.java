import java.io.*;
import java.util.*;

public class S_요리사 {

    static int N, min;
    static boolean[] aFood;
    static int[][] synergy;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init();
            divideFood(0, 0);

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }

    static void divideFood(int cnt, int start) {

        if (cnt == N / 2) {
            process();
            return;
        }

        for (int i = start; i < N; i++) {
            aFood[i] = true;
            divideFood(cnt + 1, i + 1);
            aFood[i] = false;
        }
    }

    static void process() {
        int a = 0, b = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (aFood[i] && aFood[j]) a += synergy[i][j] + synergy[j][i];
                else if (!aFood[i] && !aFood[j]) b += synergy[i][j] + synergy[j][i];
            }
        }

        min = Math.min(min, Math.abs(a - b));
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        synergy = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                synergy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        aFood = new boolean[N];

        min = Integer.MAX_VALUE;
    }
}
