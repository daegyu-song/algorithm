package d4;

import java.io.*;
import java.util.*;

public class S_정사각형방 {

    static int N, roomCnt, startRoom, currStart, currCnt;
    static int[][] roomArr, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(startRoom).append(" ").append(roomCnt).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;

                currStart = roomArr[i][j];
                currCnt = 1;
                move(i, j);

                if (roomCnt < currCnt) {
                    startRoom = currStart;
                    roomCnt = currCnt;
                } else if (roomCnt == currCnt) {
                    startRoom = Math.min(startRoom, currStart);
                }
            }
        }
    }

    static void move(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if (visited[nr][nc]) continue;

            int diff = roomArr[r][c] - roomArr[nr][nc];
            if (Math.abs(diff) != 1) continue;

            currCnt++;
            if (diff == 1) currStart = roomArr[nr][nc];

            move(nr, nc);
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        roomArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                roomArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];

        roomCnt = -1;
        startRoom = -1;
    }
}