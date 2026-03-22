package silver.ii;

import java.io.*;

public class B_15988_123더하기3 {

    static long[] dp;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        preprocess();
        while (T-- > 0) {
            initAndProcess();
        }

        System.out.println(sb);
    }

    static void preprocess() {
        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000009;
        }
    }

    static void initAndProcess() throws IOException {
        sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
    }
}
