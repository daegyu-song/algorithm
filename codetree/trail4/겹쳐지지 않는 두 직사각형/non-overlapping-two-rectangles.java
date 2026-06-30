import java.io.*;
import java.util.*;

public class Main {

    static int answer, N, M;
    static int[][] arr, board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        board = new int[N][M];

        answer = findMaxSum();

        System.out.println(answer);
    }

    static int findMaxSum() {
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = i; k < N; k++) {
                    for (int l = j; l < M; l++) {
                        maxSum = Math.max(maxSum, findMaxSum(i, j, k, l));
                    }
                }
            }
        }

        return maxSum;
    }

    static int findMaxSum(int r1, int c1, int r2, int c2) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = i; k < N; k++) {
                    for (int l = j; l < M; l++) {
                        if (!overlapped(r1, c1, r2, c2, i, j, k, l)) {
                            maxSum = Math.max(maxSum, rectSum(r1, c1, r2, c2) + rectSum(i, j, k, l));
                        }
                    }
                }
            }
        }

        return maxSum;
    }

    static boolean overlapped(int r1, int c1, int r2, int c2, int r3, int c3, int r4, int c4) {
        clearBoard();
        draw(r1, c1, r2, c2);
        draw(r3, c3, r4, c4);
        return checkBoard();
    }

    static void clearBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = 0;
            }
        }
    }

    static void draw(int r1, int c1, int r2, int c2) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                board[i][j]++;
            }
        }
    }

    static boolean checkBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] >= 2) return true;
            }
        }

        return false;
    }

    static int rectSum(int r1, int c1, int r2, int c2) {
        int sumOfNums = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                sumOfNums += arr[i][j];
            }
        }

        return sumOfNums;
    }
}