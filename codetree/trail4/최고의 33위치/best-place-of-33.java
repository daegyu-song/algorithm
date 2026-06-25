import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = 0;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int r = 0; r < arr.length; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < arr.length; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int r = 0; r <= N - 3; r++) {
            for (int c = 0; c <= N - 3; c++) {
                max = Math.max(max, getNumOfGold(r, r + 2, c, c + 2));
            }
        }

        System.out.println(max);
    }

    static int getNumOfGold(int rs, int re, int cs, int ce) {
        int numOfGold = 0;
        for (int r = rs; r <= re; r++) {
            for (int c = cs; c <= ce; c++) {
                numOfGold += arr[r][c];
            }
        }

        return numOfGold;
    }
}