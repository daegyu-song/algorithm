package level2;

import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        int count = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == ')') count++;
            else {
                if (count == 0) return false;
                else count--;
            }
        }

        return count == 0;
    }

    boolean solution2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
