import java.io.*;
import java.util.*;

public class Main {

    static int answer, N;
    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {1, -1, -1, 1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int k = 1; k < N; k++) {
                    for (int l = 1; l < N; l++) {
                        answer = Math.max(answer, getMaxSum(r, c, k, l));
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static int getMaxSum(int r, int c, int k, int l) {
        int maxSum = 0;
        int[] moveNum = {k, l, k, l};

        for (int d = 0; d < 4; d++) {
            for (int q = 0; q < moveNum[d]; q++) {
                r += dr[d];
                c += dc[d];

                if (r < 0 || c < 0 || r >= N || c >= N) {
                    return 0;
                }

                maxSum += arr[r][c];
            }
        }

        return maxSum;
    }
}