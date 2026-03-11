package d4;

import java.io.*;
import java.util.*;

public class S_1251_하나로_V1 {

    static class Edge {

        int from, to;
        long weight;

        Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static int N;
    static int[] x, y, parents;
    static long result;
    static double E;
    static Edge[] edges;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(Math.round(result * E)).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        int cnt = 0;

        for (Edge edge : edges) {
            if (!union(edge.from, edge.to)) continue;

            result += edge.weight;
            if (++cnt == N - 1) break;
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
        N = Integer.parseInt(br.readLine());

        x = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        y = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            y[i] = Integer.parseInt(st.nextToken());
        }

        E = Double.parseDouble(br.readLine());

        edges = new Edge[N * (N - 1) / 2];
        for (int i = 0, idx = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                edges[idx++] = new Edge(i, j, (long)(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2)));
            }
        }

        Arrays.sort(edges, (e1, e2) -> Long.compare(e1.weight, e2.weight));

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        result = 0;
    }
}
