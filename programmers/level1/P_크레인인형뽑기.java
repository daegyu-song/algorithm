package level1;

import java.util.*;

public class P_크레인인형뽑기 {

    static Stack<Integer> stack = new Stack<>();
    static int answer;

    public int solution(int[][] board, int[] moves) {

        int r = board.length;
        int c = 0;

        for (int i = 0; i < moves.length; i++) {
            c = moves[i] - 1;

            for (int j = 0; j < r; j++) {
                if (board[j][c] > 0) {
                    process(board[j][c]);
                    board[j][c] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    void process(int doll) {
        if (!stack.isEmpty() && stack.peek() == doll) {
            stack.pop();
            answer += 2;
        } else {
            stack.push(doll);
        }
    }
}
