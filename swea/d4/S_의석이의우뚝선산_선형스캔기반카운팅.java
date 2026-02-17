package d4;

import java.io.IOException;
import java.util.*;

public class S_의석이의우뚝선산_선형스캔기반카운팅 {

    static int N, cnt;
    static int[] field, up, down;

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        for (int i = 1; i < N; i++) {
            if (field[i - 1] < field[i]) up[i] = up[i - 1] + 1;
        }

        for (int i = N - 2; i >= 0; i--) {
            if (field[i] > field[i + 1]) down[i] = down[i + 1] + 1;
        }

        for (int i = 1; i < N - 1; i++) {
            if (field[i - 1] < field[i] && field[i] > field[i + 1]) cnt += up[i] * down[i];
        }
    }

    static void init() {
        N = sc.nextInt();

        field = new int[N];
        for (int i = 0; i < N; i++) {
            field[i] = sc.nextInt();
        }

        up = new int[N];
        down = new int[N];

        cnt = 0;
    }
}
