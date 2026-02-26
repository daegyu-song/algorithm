package gold.iii;

import java.io.*;
import java.util.*;

public class B_1005_ACMCraft {

    static int N, K, W;
    static int[] indegree, time, minTime;
    static List<Integer>[] adjList;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            init();
            process();
            sb.append(minTime[W]).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                minTime[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int to : adjList[current]) {
                minTime[to] = Math.max(minTime[to], minTime[current] + time[to]);
                indegree[to]--;

                if (indegree[to] == 0) queue.add(to);
            }
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        indegree = new int[N + 1];

        time = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < time.length; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        minTime = new int[N + 1];

        adjList = new ArrayList[N + 1];
        for (int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            indegree[to]++;
        }

        W = Integer.parseInt(br.readLine());
    }
}

