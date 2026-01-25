package silver;

import java.util.*;

public class B_1158_요세푸스문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append("<");

        while (!list.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                list.add(list.remove(0));
            }

            if (list.size() == 1) {
                sb.append(list.remove(0)).append(">");
            } else {
                sb.append(list.remove(0)).append(", ");
            }
        }

        System.out.println(sb);
    }
}
