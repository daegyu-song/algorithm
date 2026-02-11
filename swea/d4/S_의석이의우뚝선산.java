package d4;

import java.util.*;

public class S_의석이의우뚝선산 {

    static int N, mountCnt;
    static int[] field;

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(mountCnt).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        int p1 = 0, p2 = 0, h = 0;
        boolean flag = false;

        for (int i = 1; i < field.length; i++) {
            if (field[i] < field[i - 1]) {

                if (!flag) {
                    h = i - 1;
                    flag = true;
                }

                p2 = i;
                if (i + 1 >= field.length || field[i + 1] > field[i]) {
                    mountCnt += (h - p1) * (p2 - h);
                    p1 = p2;
                    flag = false;
                }
            }
        }
    }

    static void init() {
        N = sc.nextInt();
        field = new int[N];
        for (int i = 0; i < field.length; i++) {
            field[i] = sc.nextInt();
        }

        mountCnt = 0;
    }
}
