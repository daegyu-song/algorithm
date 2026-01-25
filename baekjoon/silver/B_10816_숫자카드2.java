package silver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B_10816_숫자카드2 {

    static int N, M;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] mArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        init();
        process();
        System.out.println(sb);
    }

    static void process() {
        for (int i = 0; i < M; i++) {
            if (map.containsKey(mArr[i])) {
                sb.append(map.get(mArr[i]));
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }
    }

    static void init() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int key = sc.nextInt();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        M = sc.nextInt();
        mArr = new int[M];
        for (int i = 0; i < M; i++) {
            mArr[i] = sc.nextInt();
        }
    }
}
