package d4;

import java.io.*;
import java.util.*;

public class S_1251_하나로_V3 {

    static class Vertex {

        int v;
        long weight;

        Vertex(int v, long weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    static int N;
    static int[] x, y;
    static long result;
    static long[] minEdges;
    static long[][] adjMatrix;
    static double E;
    static boolean[] isTree;

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
        PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> Long.compare(v1.weight, v2.weight));
        pq.offer(new Vertex(0, 0));

        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();

            if (isTree[cur.v]) continue;

            isTree[cur.v] = true;
            result += cur.weight;

            for (int to = 0; to < minEdges.length; to++) {
                if (isTree[to]) continue;
                if (adjMatrix[cur.v][to] == 0) continue;
                if (minEdges[to] <= adjMatrix[cur.v][to]) continue;

                minEdges[to] = adjMatrix[cur.v][to];
                pq.offer(new Vertex(to, minEdges[to]));
            }
        }
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

        adjMatrix = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                adjMatrix[i][j] = adjMatrix[j][i] = (long)(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
            }
        }

        minEdges = new long[N];
        Arrays.fill(minEdges, Long.MAX_VALUE);
        minEdges[0] = 0;

        isTree = new boolean[N];

        result = 0;
    }
}
