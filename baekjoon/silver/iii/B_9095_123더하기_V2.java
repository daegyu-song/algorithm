package silver.iii;

import java.io.*;

public class B_9095_123더하기_V2 {

    static int[] dp;

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
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
    }

    static void initAndProcess() throws IOException {
        sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
    }
}
