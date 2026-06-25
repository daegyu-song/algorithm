import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int r = 0; r < arr.length; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < arr.length; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int r = 0; r <= N - 3; r++) {
            for (int c = 0; c <= N - 3; c++) {
                int num = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        num += arr[r + i][c + j];
                    }
                }

                max = Math.max(max, num);
            }
        }

        System.out.println(max);
    }
}