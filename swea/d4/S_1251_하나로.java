package d4;
import java.io.*;
import java.util.*;

public class S_1251_하나로 {

    static class Node {

        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Edge {

        int start, end;
        double weight;

        Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int N, cnt;
    static int[] x, y, parents;
    static double E, result;
    static Node[] nodes;
    static Edge[] edges;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(Math.round(result)).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                cnt++;
                result += edge.weight;
            }

            if (cnt == N - 1) break;
        }
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

    static int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        x = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < x.length; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        y = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < y.length; i++) {
            y[i] = Integer.parseInt(st.nextToken());
        }

        E = Double.parseDouble(br.readLine());

        nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(x[i], y[i]);
        }

        edges = new Edge[N * (N - 1) / 2];
        for (int i = 0, idx = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                edges[idx++] = new Edge(i, j, (Math.pow(nodes[i].r - nodes[j].r, 2) + Math.pow(nodes[i].c - nodes[j].c, 2)) * E);
            }
        }

        Arrays.sort(edges, (e1, e2) -> Double.compare(e1.weight, e2.weight));

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = -1;
        }

        cnt = 0;
        result = 0;
    }
}
