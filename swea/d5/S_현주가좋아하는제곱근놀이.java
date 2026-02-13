package d5;

import java.io.*;

public class S_현주가좋아하는제곱근놀이 {

    static long N;
    static int cnt;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {

        while (N != 2) {

            double num = Math.sqrt(N);
            if (num % 1 == 0) {
                N = (long) Math.sqrt(N);
                cnt++;
            } else {
                long convert = (long) num + 1;
                cnt += convert * convert - N;
                N = convert * convert;
            }
        }
    }

    static void init() throws IOException {
        N = Long.parseLong(br.readLine());
        cnt = 0;
    }
}