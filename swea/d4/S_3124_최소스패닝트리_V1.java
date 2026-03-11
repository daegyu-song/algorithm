package d4;

import java.io.*;
import java.util.*;

public class S_3124_최소스패닝트리_V1 {

    static class Edge {

        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static int V, E;
    static int[] parents;
    static long result;
    static Edge[] edges;

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
        int cnt = 0;
        for (Edge edge : edges) {
            if (!union(edge.from, edge.to)) continue;

            result += edge.weight;
            if (++cnt == V - 1) break;
        }
    }

    static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if (ra == rb) return false;

        parents[rb] = ra;
        return true;
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new Edge[E];
        for (int i = 0; i < edges.length; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edges, (e1, e2) -> Integer.compare(e1.weight, e2.weight));

        parents = new int[V + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }

        result = 0;
    }
}
