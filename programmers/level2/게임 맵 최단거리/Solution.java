import java.util.*;

class Solution {

    int answer = -1;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int[][] maps;
    boolean[][] visited;

    public int solution(int[][] maps) {
        this.maps = maps;
        visited = new boolean[maps.length][maps[0].length];

        process();

        return answer;
    }

    void process() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == maps.length - 1 && cur[1] == maps[0].length - 1) {
                answer = cur[2];
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= maps.length || nc >= maps[0].length) continue;
                if (visited[nr][nc]) continue;
                if (maps[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc, cur[2] + 1});
            }
        }
    }
}