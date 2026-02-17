import java.io.*;
import java.util.*;

public class S_수영장 {

    static int min;
    static int[] money = new int[4], plan = new int[12];

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process(0, 0);

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }

    static void process(int cnt, int sum) {
        if (min <= sum) return;

        if (cnt >= 12) {
            min = sum;

            return;
        }

        process(cnt + 1, sum + money[0] * plan[cnt]);

        process(cnt + 1, sum + money[1]);

        process(cnt + 3, sum + money[2]);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 12; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        min = money[3];
    }
}