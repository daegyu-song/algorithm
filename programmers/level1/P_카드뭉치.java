package level1;

import java.util.*;

public class P_카드뭉치 {

    static Queue<String> queue1 = new ArrayDeque<>();
    static Queue<String> queue2 = new ArrayDeque<>();

    public static String solution(String[] cards1, String[] cards2, String[] goal) {

        String answer = "Yes";

        for (String str : cards1) {
            queue1.add(str);
        }

        for (String str : cards2) {
            queue2.add(str);
        }

        for (String str : goal) {
            if (!queue1.isEmpty() && queue1.peek().equals(str)) {
                queue1.poll();
            } else if (!queue2.isEmpty() && queue2.peek().equals(str)) {
                queue2.poll();
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}
