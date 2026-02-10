import java.io.*;
import java.util.*;

public class S_수영장 {

    static int min;
    static int[] price, day;

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

    static void process(int month, int sum) {

        if (sum >= min) return;

        if (month >= 12) {
            min = sum;
            return;
        }

        process(month + 1, sum + price[0] * day[month]);

        process(month + 1, sum + price[1]);

        process(month + 3, sum + price[2]);
    }

    static void init() throws IOException {
        price = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < price.length; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        day = new int[12];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < day.length; i++) {
            day[i] = Integer.parseInt(st.nextToken());
        }

        min = price[3];
    }
}