import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S_프로세서연결하기 {

    static int N, totalCnt, maxCoreCnt, minLength;
    static int[][] field, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static List<int[]> list;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(minLength).append("\n");
        }

        System.out.println(sb);
    }

    static void process(int coreCnt, int length, int idx) {

        if (idx == totalCnt) {
            if (maxCoreCnt < coreCnt) {
                maxCoreCnt = coreCnt;
                minLength = length;
            } else if (maxCoreCnt == coreCnt) {
                minLength = Math.min(minLength, length);
            }

            return;
        }

        int[] arr = list.get(idx);
        int r = arr[0];
        int c = arr[1];

        for (int d = 0; d < dir.length; d++) {
            if (!isAvailable(r, c, d)) continue;

            int a = draw(r, c, d, 2);
            process(coreCnt + 1, length + a, idx + 1);
            draw(r, c, d, 0);
        }

        process(coreCnt, length, idx + 1);
    }

    static int draw(int r, int c, int d, int num) {

        int sum = 0;

        while (true) {
            r += dir[d][0];
            c += dir[d][1];

            if (r  < 0 || c < 0 || r >= N || c >= N) break;

            field[r][c] = num;
            sum++;
        }

        return sum;
    }

    static boolean isAvailable(int r, int c, int d) {

        while (true) {
            r += dir[d][0];
            c += dir[d][1];

            if (r < 0 || c < 0 || r >= N || c >= N) break;

            if (field[r][c] == 1 || field[r][c] == 2) return false;
        }

        return true;
    }

    static void init() throws IOException{
        N = Integer.parseInt(br.readLine());
        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        totalCnt = 0;
        list = new ArrayList<>();
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (field[i][j] == 1) {
                    list.add(new int[] {i, j});
                    totalCnt++;
                }
            }
        }

        maxCoreCnt = Integer.MIN_VALUE;
        minLength = Integer.MAX_VALUE;
    }
}
