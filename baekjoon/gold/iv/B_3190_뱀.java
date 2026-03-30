package gold.iv;

import java.io.*;
import java.util.*;

public class B_3190_뱀 {

    static int N, K, L;
    static char[][] field;
    static Deque<int[]> deque;
    static Map<Integer, Character> map;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    static void process() {
        int time = 0;
        int[] curDir = {0, 1};

        while (true) {
            time++;

            int[] cur = deque.peekLast();
            int nr = cur[0] + curDir[0];
            int nc = cur[1] + curDir[1];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                System.out.println(time);
                break;
            }

            if (field[nr][nc] == 'S') {
                System.out.println(time);
                break;
            }

            if (field[nr][nc] == 'A') {
                deque.offerLast(new int[] {nr, nc});
                field[nr][nc] = 'S';
            } else {
                deque.offerLast(new int[] {nr ,nc});
                field[nr][nc] = 'S';

                int[] last = deque.pollFirst();
                field[last[0]][last[1]] = ' ';
            }

            if (map.containsKey(time)) {
                convert(curDir, map.get(time));
            }
        }
    }

    static void convert(int[] curDir, char dir) {
        int r = curDir[0];
        int c = curDir[1];

        if (Math.abs(r) == 1) {
            if (dir == 'L') {
                curDir[0] = c;
                curDir[1] = r;
            } else {
                curDir[0] = c;
                curDir[1] = -r;
            }
        } else {
            if (dir == 'L') {
                curDir[0] = -c;
                curDir[1] = r;
            } else {
                curDir[0] = c;
                curDir[1] = r;
            }
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        field = new char[N][N];
        field[0][0] = 'S';
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            field[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 'A';
        }

        deque = new ArrayDeque<>();
        deque.offer(new int[] {0, 0});

        map = new HashMap<>();
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }
    }
}
