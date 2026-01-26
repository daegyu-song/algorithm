package level0;

import java.util.ArrayList;
import java.util.List;

public class P_배열뒤집기 {
    public int[] solution(int[] num_list) {
        for (int i = 0; i < num_list.length / 2; i++) {
            int tmp = num_list[i];
            num_list[i] = num_list[num_list.length - i - 1];
            num_list[num_list.length - i - 1] = tmp;
        }
        return num_list;
    }

    int[] test(int[] num_list) {
        List<Integer> list = new ArrayList<>();

        for (int i = num_list.length - 1; i >= 0; i--) {
            list.add(num_list[i]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
