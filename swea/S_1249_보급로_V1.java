import java.io.*;
import java.util.*;

public class S_1249_보급로_V1 {

    static class Vertex {

        int r, c, weight;

        Vertex(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }
    }

    static int N;
    static int[][] field, minTime, dir = {{-1 ,0}, {1, 0}, {0, -1}, {0, 1}};

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(minTime[N - 1][N - 1]).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(v1.weight, v2.weight));
        pq.offer(new Vertex(0, 0, minTime[0][0]));

        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();
            if (cur.weight > minTime[cur.r][cur.c]) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dir[d][0];
                int nc = cur.c + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (minTime[nr][nc] <= minTime[cur.r][cur.c] + field[nr][nc]) continue;

                minTime[nr][nc] = minTime[cur.r][cur.c] + field[nr][nc];
                pq.offer(new Vertex(nr, nc, minTime[nr][nc]));
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

        minTime = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(minTime[i], Integer.MAX_VALUE);
        minTime[0][0] = 0;
    }
}
