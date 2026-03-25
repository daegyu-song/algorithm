package gold.v;

import java.io.*;
import java.util.*;

public class B_16928_뱀과사다리게임 {

    static int N, M;
    static int[] field;
    static boolean[] visited;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    static void process() {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[1] = true;
        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int idx = cur[0], cnt = cur[1];

            if (idx == 100) {
                System.out.println(cnt);
                return;
            }

            for (int d = 1; d <= 6; d++) {
                int nidx = idx + d;

                if (nidx > 100) continue;

                if (field[nidx] != 0) nidx = field[nidx];

                if (visited[nidx]) continue;

                visited[nidx] = true;
                queue.offer(new int[]{nidx, cnt + 1});
            }
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new int[101];
        visited = new boolean[101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            field[from] = to;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            field[from] = to;
        }
    }
}
