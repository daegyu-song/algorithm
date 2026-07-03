import java.util.*;

class Solution {

    List<String> answer = new ArrayList<>();
    boolean[] visited;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        process(0, "ICN", "ICN", tickets);

        Collections.sort(answer);

        return answer.get(0).split(" ");
    }

    void process(int depth, String start, String result, String[][] tickets) {
        if (depth == tickets.length) {
            answer.add(result);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (visited[i]) continue;
            if (!start.equals(tickets[i][0])) continue;

            visited[i] = true;
            process(depth + 1, tickets[i][1], result + " " + tickets[i][1], tickets);
            visited[i] = false;
        }
    }
}