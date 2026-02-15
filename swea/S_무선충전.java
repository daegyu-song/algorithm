import java.io.*;
import java.util.*;

public class S_무선충전 {

    static int M, A, answer;
    static int[] moveA, moveB;
    static int[][] chargers, dir = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static String[][] maps;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {

        int ax = 1, ay = 1;
        int bx = 10, by = 10;
        for (int i = 0; i <= M; i++) {
            int nax = ax + dir[moveA[i]][0];
            int nay = ay + dir[moveA[i]][1];

            int nbx = bx + dir[moveB[i]][0];
            int nby = by + dir[moveB[i]][1];

            if (!maps[nax][nay].equals("") && maps[nbx][nby].equals("")) {
                int max = 0;
                for (int c = 0; c < maps[nax][nay].length(); c++) {
                    max = Math.max(max, chargers[maps[nax][nay].charAt(c) - '0'][3]);
                }
                answer += max;

            } else if (maps[nax][nay].equals("") && !maps[nbx][nby].equals("")) {
                int max = 0;
                for (int c = 0; c < maps[nbx][nby].length(); c++) {
                    max = Math.max(max, chargers[maps[nbx][nby].charAt(c) - '0'][3]);
                }
                answer += max;
            } else if (!maps[nax][nay].equals("") && !maps[nbx][nby].equals("")){
                int max = 0;
                for (int ac = 0; ac < maps[nax][nay].length(); ac++) {
                    for (int bc = 0; bc < maps[nbx][nby].length(); bc++) {
                        if (maps[nax][nay].charAt(ac) == maps[nbx][nby].charAt(bc)) {
                            max = Math.max(max, chargers[maps[nax][nay].charAt(ac) - '0'][3]);
                        } else {
                            max = Math.max(max, chargers[maps[nax][nay].charAt(ac) - '0'][3] + chargers[maps[nbx][nby].charAt(bc) - '0'][3]);
                        }
                    }
                }
                answer += max;
            }

            ax = nax;
            ay = nay;
            bx = nbx;
            by = nby;
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());

        moveA = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) moveA[i] = Integer.parseInt(st.nextToken());
        moveB = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) moveB[i] = Integer.parseInt(st.nextToken());

        chargers = new int[A][4];
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                chargers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maps = new String[11][11];
        for (int i = 0; i < 11; i++) {
            Arrays.fill(maps[i], "");
        }
        for (int c = 0; c < chargers.length; c++) {
            for (int i = 1; i < 11; i++) {
                for (int j = 1; j < 11; j++) {
                    if (Math.abs(chargers[c][1] - i) + Math.abs(chargers[c][0] - j) <= chargers[c][2]) maps[i][j] += c;
                }
            }
        }

        answer = 0;
    }
}
