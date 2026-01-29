package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_퍼펙트셔플 {

    static int N;
    static String[] answer;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            answer = new String[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                answer[i] = st.nextToken();
            }
            sb.append("#").append(tc).append(" ");
            process();
        }

        System.out.println(sb);
    }

    static void process() {
        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                sb.append(answer[i]).append(" ").append(answer[i + N / 2]).append(" ");
            }
        } else {
            for (int i = 0; i < N / 2; i++) {
                sb.append(answer[i]).append(" ").append(answer[i + N / 2 + 1]).append(" ");
            }
            sb.append(answer[N / 2]);
        }

        sb.append("\n");
    }
}
