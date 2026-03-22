package silver.ii;

import java.io.*;

public class B_15991_123더하기6 {

    static int N;
    static long[] dp;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        preprocess();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            init();
            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }

    static void preprocess() {
        dp = new long[100001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;

        for (int i = 6; i < dp.length; i++) {
            dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1000000009;
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}
