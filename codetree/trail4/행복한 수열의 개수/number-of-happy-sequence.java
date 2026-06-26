import java.io.*;
import java.util.*;

public class Main {

    static int answer, N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int r = 0; r < arr.length; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < arr.length; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            answer += findSequence(i);
        }
        
        System.out.println(answer);
    }

    static int findSequence(int num) {
        int seqCnt = 0;

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = i + 1; j < N; j++) {
                if (arr[num][i] != arr[num][j]) break;
                cnt ++;
            }
            if (cnt >= M) {
                seqCnt++;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = i + 1; j < N; j++) {
                if (arr[i][num] != arr[j][num]) break;
                cnt++;
            }
            if (cnt >= M) {
                seqCnt++;
                break;
            }
        }

        return seqCnt;
    }
}