import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gravity {

    static int n, count, max;
    static int[][] originArr, rotateArr;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        init();
        rotate();
        process();
        System.out.println(max);
    }

    static void process() {
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                count = 0;
                if (rotateArr[i][j] == 1) {
                    for (int k = i + 1; k < n; k++) {
                        if (rotateArr[k][j] == 1) break;
                        rotateArr[k][j] = 1;
                        rotateArr[k - 1][j] = 0;
                        count++;
                    }
                    max = Math.max(count, max);
                }
            }
        }
    }

    static void rotate() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotateArr[i][j] = originArr[n - j - 1][i];
            }
        }
    }

    static void init() {
        originArr = new int[n][n];
        rotateArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            for (int j = n - height; j < n; j++) {
                originArr[j][i]++;
            }
        }
    }
}
