package level2;

import java.util.*;

public class P_기능개발 {

    static Queue<int[]> queue = new ArrayDeque<>();
    static List<Integer> result = new ArrayList<>();
    static int count = 0;

    public static int[] solution(int[] progresses, int[] speeds) {

        for (int i = 0; i < progresses.length; i++) {
            queue.add(new int[] {progresses[i], speeds[i]});
        }

        while (!queue.isEmpty()) {

            for (int i = 0; i < queue.size(); i++) {
                int[] check = queue.poll();
                queue.add(new int[] {check[0] + check[1], check[1]});
            }

            while (true) {
                if (!queue.isEmpty() && queue.peek()[0] >= 100) {
                    queue.poll();
                    count++;
                } else {
                    break;
                }
            }

            if (count > 0) result.add(count);
            count = 0;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
