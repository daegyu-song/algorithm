import java.util.*;

class Solution {

    static class Node {

        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.word.equals(target)) {
                answer = cur.count;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                if (!check(cur.word, words[i])) continue;

                queue.offer(new Node(words[i], cur.count + 1));
                visited[i] = true;
            }
        }

        return answer;
    }

    boolean check(String cur, String word) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (cur.charAt(i) == word.charAt(i)) count++;
        }

        return count == word.length() - 1;
    }
}