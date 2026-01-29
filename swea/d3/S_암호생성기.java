package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_암호생성기 {

    static Queue<Integer> queue;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            queue = new ArrayDeque<>();
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 8; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            sb.append("#").append(tc).append(" ");
            process();
        }

        System.out.println(sb);
    }

    static void process() {
        x: while (true) {
            for (int i = 1; i <= 5; i++) {
                int num = queue.poll();

                if (num - i <= 0) {
                    queue.offer(0);
                    break x;
                }

                queue.offer(num - i);
            }
        }

        for (int i = 0; i < 8; i++) {
            sb.append(queue.poll()).append(" ");
        }

        sb.append("\n");
    }
}
