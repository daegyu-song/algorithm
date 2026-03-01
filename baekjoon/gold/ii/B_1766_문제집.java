package gold.ii;

import java.io.*;
import java.util.*;

public class B_1766_문제집 {

    static int N, M;
    static List<Integer>[] adjList;
    static int[] indegree;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(sb);
    }

    static void process() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < adjList.length; i++) {
            if (indegree[i] == 0) pq.offer(i);
        }

        while (!pq.isEmpty()) {
            int current = pq.poll();
            sb.append(current).append(" ");

            for (int next : adjList[current]) {
                indegree[next]--;

                if (indegree[next] == 0) pq.add(next);
            }
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        indegree = new int[N + 1];
        for (int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            indegree[to]++;
        }
    }
}
