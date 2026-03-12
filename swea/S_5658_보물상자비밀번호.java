import java.io.*;
import java.util.*;

public class S_5658_보물상자비밀번호 {

    static int N, K;
    static char[] field;
    static List<Integer> list;
    static Set<Integer> set;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(list.get(K - 1)).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        for (int i = 0; i < N / 4; i++) {
            for (int j = 0; j < 4; j++) {
                set.add(Integer.parseInt(new String(field, N / 4 * j, N / 4), 16));
            }

            shift();
        }

        list = new ArrayList<>(set);
    }

    static void shift() {
        char temp = field[N - 1];
        System.arraycopy(field, 0, field, 1, N - 1);
        field[0] = temp;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        field = br.readLine().toCharArray();

        set = new TreeSet<>(Collections.reverseOrder());
    }
}
