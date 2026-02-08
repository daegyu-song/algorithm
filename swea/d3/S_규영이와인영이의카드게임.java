package d3;

import java.io.*;
import java.util.*;

public class S_규영이와인영이의카드게임 {

    static boolean[] card = new boolean[19], visited = new boolean[9];
    static int[] aCard = new int[9], bCard = new int[9];
    static int win, lose;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            init();
            process(0, 0, 0);

            sb.append("#").append(tc).append(" ");
            sb.append(lose).append(" ").append(win).append("\n");
        }

        System.out.println(sb);
    }

    static void process(int idx, int aSum, int bSum) {

        if (idx == 9) {
            if (aSum > bSum) lose++;
            else if (aSum < bSum) win++;
            return;
        }

        for (int j = 0; j < 9; j++) {

            if (visited[j]) continue;

            visited[j] = true;

            process(
                    idx + 1,
                    aCard[idx] < bCard[j] ? aSum : aSum + aCard[idx] + bCard[j],
                    aCard[idx] < bCard[j] ? bSum + aCard[idx] + bCard[j] : bSum);

            visited[j] = false;
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(st.nextToken());
            card[num] = true;
            aCard[i] = num;
        }

        int idx = 0;
        for (int i = 1; i <= 18; i++) {
            if (!card[i]) bCard[idx++] = i;
        }

        Arrays.fill(card, false);
        win = 0;
        lose = 0;
    }
}