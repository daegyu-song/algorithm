package d4;

import java.io.*;
import java.util.*;

public class S_2819_격자판의숫자이어붙이기 {

    static int[][] field, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Set<String> set;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dfs(i, j, 1, "" + field[i][j]);
            }
        }
    }

    static void dfs(int r, int c, int cnt, String cur) {
        if (cnt == 7) {
            set.add(cur);
            return;
        }

        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= 4 || nc >= 4) continue;

            dfs(nr, nc, cnt + 1, cur + field[nr][nc]);
        }
    }

    static void init() throws IOException {
        field = new int[4][4];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        set = new HashSet<>();
    }
}
