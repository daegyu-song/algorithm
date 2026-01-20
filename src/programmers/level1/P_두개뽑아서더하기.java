package programmers.level1;

import java.util.*;

public class P_두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
