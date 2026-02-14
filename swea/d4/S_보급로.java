package d4;

import java.io.*;
import java.util.*;

class Vertex {
    int r, c;

    Vertex(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class S_보급로 {

    static int N;
    static int[][] field, timeField, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(timeField[N - 1][N - 1]).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(0, 0));

        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = v.r + dir[i][0];
                int nc = v.c + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (timeField[nr][nc] <= timeField[v.r][v.c] + field[nr][nc]) continue;
                timeField[nr][nc] = timeField[v.r][v.c] + field[nr][nc];
                queue.add(new Vertex(nr, nc));
            }
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                field[i][j] = str.charAt(j) - '0';
            }
        }

        timeField = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(timeField[i], Integer.MAX_VALUE);
        }
        timeField[0][0] = 0;
    }
}
