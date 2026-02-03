package level2;

import java.util.*;

public class P_주식가격 {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                result[j] = i - j;
            }
            stack.push(i);
        }

        while (!stack.isEmpty() ) {
            int idx = stack.pop();
            result[idx] = prices.length - 1 - idx;
        }

        return result;
    }
}
