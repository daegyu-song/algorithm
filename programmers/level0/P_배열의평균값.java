package level0;

import java.util.Arrays;

public class P_배열의평균값 {
    static double sum = 0;

    public double solution(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum / numbers.length;
    }

    double test(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0);
    }
}
