package level2;

import java.util.*;

public class P_짝지어제거하기 {

    static Stack<Character> stack = new Stack<>();

    public int solution(String s) {
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }

        }

        return stack.isEmpty() ? 1 : 0;
    }
}
