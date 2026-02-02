package level2;

import java.util.*;

public class P_괄호회전하기 {

    static Map<Character, Character> map = new HashMap<>();
    static Stack<Character> stack;

    public static int solution(String s) {
        init();

        int length = s.length();
        s += s;
        int count = 0;

        x: for (int i = 0; i < length; i++) {
            stack = new Stack<>();
            for (int j = i; j < i + length; j++) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || map.get(stack.pop()) != c) {
                        continue x;
                    }
                }
            }

            if (stack.isEmpty()) count++;
        }

        return count;
    }

    static void init() {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }
}
