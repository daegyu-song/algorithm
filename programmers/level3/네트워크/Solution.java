class Solution {

    int[][] computers;
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.computers = computers;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            process(i);
            answer++;
        }

        return answer;
    }

    void process(int start) {
        visited[start] = true;

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[start][i] == 1) {
                process(i);
            }
        }
    }
}