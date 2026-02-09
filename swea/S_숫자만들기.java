import java.io.*;
import java.util.*;

public class S_숫자만들기 {

    static int N, max, min;
    static int[] nums, operators;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init();
            process(1, nums[0]);

            sb.append("#").append(tc).append(" ").append(max - min).append("\n");
        }

        System.out.println(sb);
    }

    static void process(int idx, int value) {

        if (idx == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) continue;

            operators[i]--;

            if (i == 0) process(idx + 1, value + nums[idx]);
            else if (i == 1) process(idx + 1, value - nums[idx]);
            else if (i == 2) process(idx + 1, value * nums[idx]);
            else process(idx + 1, value / nums[idx]);

            operators[i]++;
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }
}
