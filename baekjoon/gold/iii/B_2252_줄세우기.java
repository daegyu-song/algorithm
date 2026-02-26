package gold.iii;

import java.io.*;
import java.util.*;

public class B_2252_줄세우기 {

    static int N, M;
    static List<Integer>[] adjList;
    static int[] in;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(sb);
    }

    static void process() {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < adjList.length; i++) {
            if (in[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for (int to : adjList[current]) {
                in[to]--;
                if (in[to] == 0) queue.offer(to);
            }
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        in = new int[N + 1];

        adjList = new ArrayList[N + 1];
        for (int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            in[to]++;
        }
    }
}
