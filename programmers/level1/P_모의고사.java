package level1;

import java.util.*;

public class P_모의고사 {
    public int[] solution(int[] answers) {

        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] check = new int[4];

        for (int i = 0; i < answers.length; i++) {
            if (num1[i % 5] == answers[i]) check[1]++;
            if (num2[i % 8] == answers[i]) check[2]++;
            if (num3[i % 10] == answers[i]) check[3]++;
        }

        int max = -1;
        for (int i = 1; i < check.length; i++) {
            max = Math.max(check[i], max);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < check.length; i++) {
            if (check[i] == max) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
