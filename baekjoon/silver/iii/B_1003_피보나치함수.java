package silver.iii;

import java.io.*;

public class B_1003_피보나치함수 {

    static int N;
    static int[][] dp;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        preprocess();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            init();
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        System.out.println(sb);
    }

    static void preprocess() {
        dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}
