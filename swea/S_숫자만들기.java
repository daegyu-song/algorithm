import java.io.*;
import java.util.*;

public class S_숫자만들기 {

    static int N, min, max;
    static int[] operators, numbers;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            countingPerm(0, numbers[0]);

            sb.append("#").append(tc).append(" ").append(max - min).append("\n");
        }

        System.out.println(sb);
    }

    static void countingPerm(int cnt, int result) {
        if (cnt == N - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) continue;

            operators[i]--;
            countingPerm(cnt + 1, calculate(result, numbers[cnt + 1], i));
            operators[i]++;
        }
    }

    static int calculate(int now, int next, int operator) {
        if (operator == 0) return now + next;
        else if (operator == 1) return now - next;
        else if (operator == 2) return now * next;
        else return now / next;
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
}