import java.io.*;
import java.util.*;

public class Main {

    static int answer, N, M;
    static int[][] arr;
    static int[][][] shapes = new int[][][] {
        {{1, 1, 0},
        {1, 0, 0},
        {0, 0, 0}},

        {{1, 1, 0},
        {0, 1, 0},
        {0, 0, 0}},

        {{1, 0, 0},
        {1, 1, 0},
        {0, 0, 0}},

        {{0, 1, 0},
        {1, 1, 0},
        {0, 0, 0}},

        {{1, 1, 1},
        {0, 0, 0},
        {0, 0, 0}},

        {{1, 0, 0},
        {1, 0, 0},
        {1, 0, 0}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c< M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int i = 0; i < 6; i++) {
                    answer = Math.max(answer, getMaxSum(r, c));
                }
            }
        }

        System.out.println(answer);
    }

    static int getMaxSum(int r, int c) {
        int maxSum = 0;

        for (int i = 0; i < 6; i++) {
            int sum = 0;
            boolean isPossible = true;
            for (int dr = 0; dr < 3; dr++) {
                for (int dc = 0; dc < 3; dc++) {
                    if (shapes[i][dr][dc] == 0) continue;
                    if (r + dr >= N || c + dc >= M) isPossible = false;
                    else sum += arr[r + dr][c + dc]; 
                }
            }

            if (isPossible) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}