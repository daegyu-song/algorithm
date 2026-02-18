package d2;

import java.io.*;
import java.util.*;

public class S_나무높이_그리디 {

    static int N, maxHeight, day;
    static int[] treeArr;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(day).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        int one = 0;
        int two = 0;

        for (int i = 0; i < treeArr.length; i++) {
            int diff = maxHeight - treeArr[i];

            one += diff % 2;
            two += diff / 2;
        }

        while (two > one + 1) {
            two--;
            one += 2;
        }

        if (one > two) day = one * 2 - 1;
        else day = two * 2;
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        treeArr = new int[N];
        maxHeight = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            treeArr[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, treeArr[i]);
        }
    }
}
