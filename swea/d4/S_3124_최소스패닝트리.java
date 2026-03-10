package d4;

import java.io.*;
import java.util.*;

public class S_3124_최소스패닝트리 {

    static class Edge {

        int start, end, weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int V, E, cnt;
    static long answer;
    static int[] parents;
    static Edge[] edges;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                cnt++;
                answer += edge.weight;
            }

            if (cnt == V - 1) break;
        }
    }

    static int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if (ra == rb) return false;

        if (parents[ra] <= parents[rb]) {
            parents[ra] += parents[rb];
            parents[rb] = ra;
        } else {
            parents[rb] += parents[ra];
            parents[ra] = rb;
        }

        return true;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        cnt = 0;
        answer = 0;

        parents = new int[V + 1];
        Arrays.fill(parents, -1);

        edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, weight);
        }

        Arrays.sort(edges, (e1, e2) -> Integer.compare(e1.weight, e2.weight));
    }
}
