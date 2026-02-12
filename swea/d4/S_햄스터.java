package d4;

import java.io.*;
import java.util.*;

public class S_햄스터 {

    static int N, X, M;
    static int[] answer, check;
    static int[][] record;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();

            sb.append("#").append(tc).append(" ");
            process(0);

            if (answer[0] == -1) sb.append(-1);
            else for (int i = 0; i < answer.length; i++) sb.append(answer[i]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void process(int cnt) {

        if (cnt == N) {
            
            if (!isAvailable()) return;

            int maxSum = 0;
            int nowSum = 0;
            for (int i = 0; i < answer.length; i++) {
                maxSum += answer[i];
                nowSum += check[i];
            }

            if (nowSum > maxSum) {
                for (int i = 0; i < answer.length; i++) {
                    answer[i] = check[i];
                }
            }

            return;
        }

        for (int i = 0; i <= X; i++) {

            check[cnt] = i;
            process(cnt + 1);
        }
    }

    static boolean isAvailable() {
        for (int i = 0; i < record.length; i++) {
            int l = record[i][0] - 1;
            int r = record[i][1] - 1;
            int s = record[i][2];

            int sum = 0;
            for (int j = l; j <= r; j++) {
                sum += check[j];
            }

            if (sum != s) return false;
        }

        return true;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[N];
        Arrays.fill(answer, -1);
        check = new int[N];

        record = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                record[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}