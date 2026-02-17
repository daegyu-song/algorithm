import java.io.*;
import java.util.*;

public class S_원자소멸시뮬레이션 {

    static class Atom {

        int x, y, dir, energy;

        Atom(int x, int y, int dir, int energy) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
        }
    }

    static int N, totalEnergy;
    static int[][] field = new int[4001][4001];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Atom> queue;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(totalEnergy).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        while (!queue.isEmpty()) {
            Atom atom = queue.poll();

            if (field[atom.y][atom.x] != atom.energy) {
                totalEnergy += field[atom.y][atom.x];
                field[atom.y][atom.x] = 0;
                continue;
            }

            int rx = atom.x + dx[atom.dir];
            int ry = atom.y + dy[atom.dir];
            field[atom.y][atom.x] = 0;

            if (rx < 0 || ry < 0 || rx > 4000 || ry > 4000) continue;

            field[ry][rx] += atom.energy;
            atom.x = rx;
            atom.y = ry;
            queue.add(atom);
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
            int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
            int dir = Integer.parseInt(st.nextToken());
            int energy = Integer.parseInt(st.nextToken());

            queue.add(new Atom(x, y, dir, energy));
            field[y][x] = energy;
        }

        totalEnergy = 0;
    }
}