package level2;

import java.util.*;

public class P_방문길이 {

    static int r = 5, c = 5, count = 0;
    static Map<Character, int[]> dir = new HashMap<>();
    static boolean[][][][] flag = new boolean[11][11][11][11];

    public int solution(String dirs) {

        dir.put('U', new int[]{-1, 0});
        dir.put('D', new int[]{1, 0});
        dir.put('L', new int[]{0, -1});
        dir.put('R', new int[]{0, 1});

        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = dir.get(dirs.charAt(i));
            int nr = r + offset[0];
            int nc = c + offset[1];

            if (nr < 0 || nc < 0 || nr >= 11 || nc >= 11) continue;
            flag[r][c][nr][nc] = true;
            flag[nr][nc][r][c] = true;

            r = nr;
            c = nc;
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    for (int q = 0; q < 11; q++) {
                        if (flag[i][j][k][q]) count++;
                    }
                }
            }
        }

        return count / 2;
    }
}
