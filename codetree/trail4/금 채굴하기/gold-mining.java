import java.util.*;
import java.io.*;

public class Main {

    static int answer, N, M, maxK;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxK = N + N - 2;

        arr = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c ++) {
                answer = Math.max(answer, getMaxGold(r, c));
            }
        }

        System.out.println(answer);
    }

    static int getMaxGold(int r, int c) {
        int maxGold = 0;

        for (int k = 0; k <= maxK; k++) {
            int price = (int)Math.pow(k, 2) + (int)Math.pow(k + 1, 2);
            int currentGold = 0;
            for (int nr = 0; nr < N; nr++) {
                for (int nc = 0; nc < N; nc++) {
                    if (Math.abs(nr - r) + Math.abs(nc - c) <= k) {
                        currentGold += arr[nr][nc];
                    }        
                }
            }

            if (currentGold * M >= price) {
                maxGold = Math.max(maxGold, currentGold);
            }
        }       

        return maxGold;
    }
}