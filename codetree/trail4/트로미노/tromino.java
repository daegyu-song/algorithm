import java.io.*;
import java.util.*;

public class Main {

    static int answer, N, M;
    static int[][] arr;
    static int[][] s = {{0, 0}, {0, 0}, {0, 0}, {0, 1}, {0, 0}, {0, 0}};
    static int[][] f = {{1, 0}, {0, 1}, {0, 1}, {1, 1}, {0, 1}, {1, 0}};
    static int[][] u = {{1, 1}, {1, 0}, {1, 1}, {1, 0}, {0, 2}, {2, 0}};

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
                    int sum = 0;

                    if (r + s[i][0] >= N || c + s[i][1] >= M) continue;
                    if (r + f[i][0] >= N || c + f[i][1] >= M) continue;
                    if (r + u[i][0] >= N || c + u[i][1] >= M) continue;

                    sum += arr[r + s[i][0]][c + s[i][1]];
                    sum += arr[r + f[i][0]][c + f[i][1]];
                    sum += arr[r + u[i][0]][c + u[i][1]];

                    answer = Math.max(answer, sum);
                }
            }
        }

        System.out.println(answer);
    }
}