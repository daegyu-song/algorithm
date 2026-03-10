import java.io.*;
import java.util.*;

public class S_2382_미생물격리 {

    static class Microbe {

        int r, c, sumCnt, maxCnt, direction;

        Microbe(int r, int c, int sumCnt, int direction) {
            this.r = r;
            this.c = c;
            this.sumCnt = sumCnt;
            this.direction = direction;
        }

        void move() {
            maxCnt = sumCnt;

            r += dir[direction][0];
            c += dir[direction][1];

            if (r == 0 || c == 0 || r == N - 1 || c == N - 1) {
                direction = direction % 2 == 1 ? direction + 1 : direction - 1;
                sumCnt /= 2;
                if (sumCnt == 0) microbes.remove(this);
            }
        }
    }

    static int N, M, K, totalCnt;
    static int[][] dir = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Microbe[][] field;
    static List<Microbe> microbes;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(totalCnt).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        while(M-- > 0) {
            field = new Microbe[N][N];
            for (int i = microbes.size() - 1; i >= 0; i--) {
                Microbe m = microbes.get(i);
                m.move();

                if (field[m.r][m.c] == null) {
                    field[m.r][m.c] = m;
                    continue;
                }

                Microbe origin = field[m.r][m.c];

                if (origin.maxCnt < m.maxCnt) {
                    origin.maxCnt = m.maxCnt;
                    origin.direction = m.direction;
                }

                origin.sumCnt += m.sumCnt;
                microbes.remove(i);
            }
        }

        for (Microbe m : microbes) totalCnt += m.sumCnt;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        microbes = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            microbes.add(new Microbe(r, c, cnt, direction));
        }

        totalCnt = 0;
    }
}
