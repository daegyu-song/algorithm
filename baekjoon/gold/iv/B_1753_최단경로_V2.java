package gold.iv;

import java.io.*;
import java.util.*;

public class B_1753_최단경로_V2 {

    static class Vertex {

        int v, weight;

        Vertex(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    static int V, E, start;
    static int[] minDist;
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
        PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(v1.weight, v2.weight));
        pq.offer(new Vertex(start, 0));

        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();

            if (minDist[cur.v] < cur.weight) continue;

            for (Vertex vertex : adjList[cur.v]) {
                if (minDist[vertex.v] <= minDist[cur.v] + vertex.weight) continue;

                minDist[vertex.v] = minDist[cur.v] + vertex.weight;
                pq.offer(new Vertex(vertex.v, minDist[vertex.v]));
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
