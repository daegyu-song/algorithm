package d4;

import java.util.*;

public class S_의석이의우뚝선산 {

    static int N, cnt;
    static int[] field;

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        for (int i = 1; i < N - 1; i++) {
            if (field[i - 1] < field[i] && field[i] > field[i + 1]) {
                int leftCnt = 1;
                for (int j = i - 2; j >= 0; j--) {
                    if (field[j] > field[j + 1]) break;
                    leftCnt++;
                }

                int rightCnt = 1;
                for (int j = i + 2; j < N; j++) {
                    if (field[j - 1] < field[j]) break;
                    rightCnt++;
                }

                cnt += leftCnt * rightCnt;
            }
        }
    }

    static void init() {
        N = sc.nextInt();

        field = new int[N];
        for (int i = 0; i < N; i++) {
            field[i] = sc.nextInt();
        }

        cnt = 0;
    }
}