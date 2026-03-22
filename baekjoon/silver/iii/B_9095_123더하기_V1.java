package silver.iii;

import java.io.*;

public class B_9095_123더하기_V1 {

    static int N, cnt;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            init();
            process(0);
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void process(int sum) {
        if (sum == N) {
            cnt++;
            return;
        }

        if (sum > N) return;

        process(sum + 1);
        process(sum + 2);
        process(sum + 3);
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        cnt = 0;
    }
}
