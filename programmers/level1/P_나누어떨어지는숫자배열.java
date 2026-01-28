package level1;

import java.util.*;
import java.util.stream.Collectors;

public class P_나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = Arrays.stream(arr).filter(value -> value % divisor == 0)
                .sorted().boxed().collect(Collectors.toList());

        if (list.size() == 0) list.add(-1);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
