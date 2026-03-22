package silver.i;

import java.io.*;
import java.util.*;

public class B_11052_카드구매하기 {

    static int N;
    static int[] dp;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        preprocess();

        System.out.println(dp[N]);
    }

    static void preprocess() {
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }
    }
}
