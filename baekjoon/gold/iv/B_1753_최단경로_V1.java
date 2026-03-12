package gold.iv;

import java.io.*;
import java.util.*;

public class B_1753_최단경로_V1 {

    static class Vertex {

        int v, weight;

        Vertex(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    static int V, E, start;
    static int[] minDist;
    static boolean[] visited;
    static List<Vertex>[] adjList;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(sb);
    }

    static void process() {
        for (int i = 0; i < V; i++) {
            int idx = - 1, min = Integer.MAX_VALUE;
            for (int v = 1; v <= V; v++) {
                if (visited[v]) continue;
                if (min <= minDist[v]) continue;

                idx = v;
                min = minDist[v];
            }

            if (idx == -1) break;

            visited[idx] = true;

            for (Vertex vertex : adjList[idx]) {
                if (visited[vertex.v]) continue;
                if (minDist[vertex.v] <= min + vertex.weight) continue;

                minDist[vertex.v] = min + vertex.weight;
            }
        }

        for (int i = 1; i < minDist.length; i++) {
            sb.append(minDist[i] == Integer.MAX_VALUE ? "INF" : minDist[i]).append("\n");
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        minDist = new int[V + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[start] = 0;

        visited = new boolean[V + 1];

        adjList = new ArrayList[V + 1];
        for (int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Vertex(to, weight));
        }
    }
}
