import java.io.*;
import java.util.*;

public class S_요리사 {

    static int N, min;
    static int[][] synergy;
    static boolean[] aSource;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            combination(0, 0);

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }

    static void combination(int cnt, int start) {
        if (cnt == N / 2) {
            process();

            return;
        }

        for (int i = start; i < N; i++) {
            aSource[i] = true;
            combination(cnt + 1, i + 1);
            aSource[i] = false;
        }
    }

    static void process() {
        int aSum = 0, bSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (aSource[i] && aSource[j]) aSum += synergy[i][j] + synergy[j][i];
                else if (!aSource[i] && !aSource[j]) bSum += synergy[i][j] + synergy[j][i];
            }
        }

        min = Math.min(min, Math.abs(aSum - bSum));
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

        aSource = new boolean[N];

        min = Integer.MAX_VALUE;
    }
}