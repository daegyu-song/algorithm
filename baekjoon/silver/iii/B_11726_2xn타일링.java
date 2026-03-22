package silver.iii;

import java.io.*;
import java.util.Arrays;

public class B_11726_2xn타일링 {

    static int N;
    static int[] dp;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        preprocess();
        init();

        System.out.println(dp[N]);
    }

    static void preprocess() {
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}
