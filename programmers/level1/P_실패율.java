package level1;

import java.util.*;

class Fail {
    int idx;
    double fail;

    Fail(int idx, double fail) {
        this.idx = idx;
        this.fail = fail;
    }

    int getIdx() {
        return idx;
    }

    double getFail() {
        return fail;
    }
}

public class P_실패율 {
    public int[] solution(int N, int[] stages) {
        List<Fail> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int notClearPlayer = 0;
            int player = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i) {
                    player++;
                    if (stages[j] == i) {
                        notClearPlayer++;
                    }
                }
            }

            double fail = (player == 0) ? 0 : (double) notClearPlayer / player;
            list.add(new Fail(i, fail));
        }

        return list.stream()
                .sorted(Comparator.comparingDouble(Fail::getFail).reversed().thenComparing(Fail::getIdx))
                .mapToInt(Fail::getIdx)
                .toArray();
    }
}
