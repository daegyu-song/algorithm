package d4;

import java.io.*;
import java.util.*;

public class S_3124_최소스패닝트리_V2 {

    static class Vertex {

        int v, weight;

        Vertex(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    static int V, E;
    static long result;
    static List<Vertex>[] adjList;
    static boolean[] isTree;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(v1.weight, v2.weight));
        pq.offer(new Vertex(1, 0));

        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();

            if (isTree[cur.v]) continue;

            isTree[cur.v] = true;
            result += cur.weight;

            for (Vertex vertex : adjList[cur.v]) {
                if (isTree[vertex.v]) continue;
                pq.offer(new Vertex(vertex.v, vertex.weight));
            }
        }
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
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Vertex(to, weight));
            adjList[to].add(new Vertex(from, weight));
        }

        isTree = new boolean[V + 1];

        result = 0;
    }
}
