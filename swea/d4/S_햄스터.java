package d4;

import java.io.*;
import java.util.*;

public class S_햄스터 {

    static int N, X, M, hamsterCnt;
    static int[] answer, hamsters;
    static int[][] record;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            dupPerm(0);

            sb.append("#").append(tc).append(" ");
            if (hamsterCnt == -1) sb.append(-1);
            else {
                for (int i : answer) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dupPerm(int cnt) {
        if (!isAvailable(cnt - 1)) return;

        if (cnt == N) {
            countHamster();

            return;
        }

        for (int i = 0; i <= X; i++) {
            hamsters[cnt] = i;
            dupPerm(cnt + 1);
        }
    }

    static boolean isAvailable(int num) {
        for (int i = 0; i < M; i++) {
            int l = record[i][0] - 1;
            int r = record[i][1] - 1;
            int s = record[i][2];

            if (num != r) continue;

            int sum = 0;
            for (int j = l; j <= r; j++) {
                sum += hamsters[j];
            }

            if (sum != s) return false;
        }

        return true;
    }

    static void countHamster() {
        int sum = 0;
        for (int hamster : hamsters) {
            sum += hamster;
        }

        if (sum > hamsterCnt) {
            System.arraycopy(hamsters, 0, answer, 0, answer.length);
            hamsterCnt = sum;
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        hamsterCnt = -1;

        answer = new int[N];
        hamsters = new int[N];

        record = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                record[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}