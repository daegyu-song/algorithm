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
                answer = Math.max(answer, getMaxSum(r, c));
            }
        }

        System.out.println(answer);
    }

    static int getMaxSum(int r, int c) {
        int maxSum = 0;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - i; j++) {
                boolean isPossible = true;
                int nr = r, nc = c, sum = 0;
                
                for (int d = 0; d < 4; d++) {
                    int cnt = 0;
                    if (d % 2 == 0) cnt = i;
                    else cnt = j;

                    for (int k = 0; k < cnt; k++) {
                        nr += dr[d];
                        nc += dc[d];

                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                            isPossible = false;
                            break;
                        }

                        sum += arr[nr][nc];
                    }

                    if (!isPossible) {
                        sum = 0;
                        break;
                    }
                }

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}