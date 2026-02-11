package d3;

import java.io.*;
import java.util.*;

public class S_농작물수확하기 {

    static int N, sum;
    static int[][] field;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {

        int min = N / 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Math.abs(i - min) + Math.abs(j - min) <= min) sum += field[i][j];
            }
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        field = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                field[i][j] = str.charAt(j) - '0';
            }
        }

        sum = 0;
    }
}
