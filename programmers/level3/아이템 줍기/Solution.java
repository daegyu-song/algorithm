import java.util.*;

class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int[][] arr = new int[101][101];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int i = 0; i < rectangle.length; i++) {
            draw(rectangle[i][1] * 2, rectangle[i][0] * 2, rectangle[i][3] * 2, rectangle[i][2] * 2);
        }

        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {characterY * 2, characterX * 2, 0});
        arr[characterY * 2][characterX * 2] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == itemY * 2 && cur[1] == itemX * 2) {
                answer = cur[2] / 2;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= arr.length || nc >= arr.length) continue;
                if (arr[nr][nc] != 2) continue;

                arr[nr][nc] = 0;
                queue.offer(new int[] {nr, nc, cur[2] + 1});
            }
        }

        return answer;
    }

    void draw(int r1, int c1, int r2, int c2) {
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                if (arr[r][c] == 1) continue;
                arr[r][c] = 1;
                if (r == r1 || r == r2 || c == c1 || c == c2) arr[r][c] = 2;
            }
        }
    }
}