package d3;

import java.io.*;
import java.util.*;

public class S_규영이와인영이의카드게임 {

    static boolean[] card = new boolean[19], visited;
    static int[] aCard = new int[9], bCard = new int[9];
    static int win, lose, aSum, bSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                int num = Integer.parseInt(st.nextToken());
                card[num] = true;
                aCard[i] = num;
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!card[i]) bCard[idx++] = i;
            }


            aSum = 0;
            bSum = 0;
            win = 0;
            lose = 0;
            visited = new boolean[9];

            dfs(0);

            Arrays.fill(card, false);

            sb.append("#").append(tc).append(" ");
            sb.append(lose).append(" ").append(win).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int i) {

        if (i == 9) {
            if (aSum > bSum) lose++;
            else if (aSum < bSum) win++;
            return;
        }

        for (int j = 0; j < 9; j++) {
            if (visited[j]) continue;

            if (aCard[i] < bCard[j]) bSum += aCard[i] + bCard[j];
            else if (aCard[i] > bCard[j]) aSum += aCard[i] + bCard[j];
            visited[j] = true;

            dfs(i + 1);

            if (aCard[i] < bCard[j]) bSum -= aCard[i] + bCard[j];
            else if (aCard[i] > bCard[j]) aSum -= aCard[i] + bCard[j];
            visited[j] = false;
        }
    }
}