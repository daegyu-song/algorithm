package gold.iii;

import java.util.*;
import java.io.*;

public class B_2623_음악프로그램 {

    static int N, M, count;
    static List<Integer>[] adjList;
    static int[] indegree;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        if (count != N) System.out.println(0);
        else System.out.println(sb);
    }

    static void process() {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < adjList.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append("\n");
            count++;

            for (int next : adjList[current]) {
                indegree[next]--;

                if (indegree[next] == 0) queue.offer(next);
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
            int num = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num - 1; j++) {
                int to = Integer.parseInt(st.nextToken());
                adjList[from].add(to);
                indegree[to]++;
                from = to;
            }
        }
    }
}
