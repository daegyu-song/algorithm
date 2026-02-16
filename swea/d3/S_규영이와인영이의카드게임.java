package d3;

import java.io.*;
import java.util.*;

public class S_규영이와인영이의카드게임 {

    static boolean[] card, selected;
    static int[] aCard, bCard;
    static int win, lose;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            permutation(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }

        System.out.println(sb);
    }

    static void permutation(int cnt, int aSum, int bSum) {
        if (cnt == 9) {
            if (aSum > bSum) win++;
            else if (aSum < bSum) lose++;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (selected[i]) continue;

            selected[i] = true;
            permutation(cnt + 1,
                    aSum + (aCard[cnt] > bCard[i] ? aCard[cnt] + bCard[i] : 0),
                    bSum + (aCard[cnt] > bCard[i] ? 0 : aCard[cnt] + bCard[i]));
            selected[i] = false;
        }
    }

    static void init() throws IOException {
        card = new boolean[19];

        selected = new boolean[9];

        aCard = new int[9];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aCard.length; i++) {
            int cardNum = Integer.parseInt(st.nextToken());
            aCard[i] = cardNum;
            card[cardNum] = true;
        }

        bCard = new int[9];
        int idx = 0;
        for (int i = 1; i < card.length; i++) {
            if (!card[i]) bCard[idx++] = i;
        }

        win = 0;
        lose = 0;
    }
}
