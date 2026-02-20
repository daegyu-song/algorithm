package d4;

import java.io.*;
import java.util.*;

public class S_Contact {

    static int N, start, max;
    static List<Integer>[] adjList;
    static boolean[] visited;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            init();
            bfs();

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            max = 0;
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                max = Math.max(max, current);

                for (int vertex : adjList[current]) {
                    if (visited[vertex]) continue;

                    queue.offer(vertex);
                    visited[vertex] = true;
                }
            }
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[101];
        for (int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N / 2; i++) {
            adjList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        visited = new boolean[101];
    }
}
