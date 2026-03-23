package gold.iv;

import java.io.*;
import java.util.*;

public class B_1967_트리의지름 {

    static class Node {

        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int n, farNode, max;
    static List<Node>[] adjList;
    static boolean[] visited;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(max);
    }

    static void process() {
        dfs(1, 0);
        Arrays.fill(visited, false);

        dfs(farNode, 0);
    }

    static void dfs(int start, int sum) {
        visited[start] = true;
        if (sum > max) {
            farNode = start;
            max = sum;
        }

        for (Node node : adjList[start]) {
            if (visited[node.to]) continue;
            dfs(node.to, sum + node.weight);
        }
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(to, weight));
            adjList[to].add(new Node(from, weight));
        }

        visited = new boolean[n + 1];
    }
}
