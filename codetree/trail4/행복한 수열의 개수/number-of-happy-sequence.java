import java.io.*;
import java.util.*;

public class Main {

    static int answer, N, M;
    static int[] sequence;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[N];

        arr = new int[N][N];
        for (int r = 0; r < arr.length; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < arr.length; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sequence[c] = arr[r][c];
            }

            if (isHappySequence()) {
                answer++;
            }
        }

        for (int c = 0; c < N; c++) {
            for (int r = 0; r < N; r++) {
                sequence[r] = arr[r][c];
            }

            if (isHappySequence()) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }

    static boolean isHappySequence() {
        int consecutiveCnt = 1, maxCcnt = 1;
        for (int i = 1; i < N; i++) {
            if (sequence[i - 1] == sequence[i]) consecutiveCnt++;
            else consecutiveCnt = 1;

            maxCcnt = Math.max(maxCcnt, consecutiveCnt);
        }

        return maxCcnt >= M;
    }
}