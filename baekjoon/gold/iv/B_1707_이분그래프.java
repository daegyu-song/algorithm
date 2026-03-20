package gold.iv;

import java.io.*;
import java.util.*;

public class B_1707_이분그래프 {

    static int V, E;
    static List<Integer>[] adjList;
    static int[] color;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            init();
            process();
        }

        System.out.println(sb);
    }

    static void process() {
        boolean check = true;
        for (int i = 1; i <= V; i++) {
            if (color[i] != 0) continue;
            if (bfs(i)) continue;

            check = false;
            break;
        }

        sb.append(check ? "YES" : "NO").append("\n");
    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        color[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adjList[cur]) {
                if (color[next] == 0) {
                    color[next] = -color[cur];
                    queue.offer(next);
                } else if (color[next] == color[cur]) {
                    return false;
                }
            }
        }

        return true;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[V + 1];
        for (int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        color = new int[V + 1];
    }
}
