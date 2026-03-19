package silver.ii;

import java.io.*;
import java.util.*;

public class B_16953_AtoB {

    static long A, B, answer;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(answer == 0 ? -1 : answer);
    }

    static void process() {
        Queue<long[]> queue = new ArrayDeque<>();
        queue.add(new long[] {A, 0});

        while (!queue.isEmpty()) {
            long[] curArr = queue.poll();
            long cur = curArr[0];
            long cnt = curArr[1];

            if (cur == B) {
                answer = cnt + 1;
                return;
            }

            if (cur > B) continue;

            queue.add(new long[] {Long.parseLong(cur + "1"), cnt + 1});
            queue.add(new long[] {cur * 2, cnt + 1});
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }
}
