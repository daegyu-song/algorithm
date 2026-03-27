package silver.i;

import java.io.*;
import java.util.*;

public class B_5014_스타트링크 {

    static int F, S, G;
    static int[] dir = new int[2];
    static boolean[] visited;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        init();
        bfs();

        System.out.println(sb);
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {S, 0});
        visited[S] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == G) {
                sb.append(cur[1]);
                return;
            }

            for (int d = 0; d < 2; d++) {
                int n = cur[0] + dir[d];

                if (n <= 0 || n > F) continue;
                if (visited[n]) continue;

                visited[n] = true;
                queue.offer(new int[] {n, cur[1] + 1});
            }
        }

        sb.append("use the stairs");
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = -Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];
    }
}
