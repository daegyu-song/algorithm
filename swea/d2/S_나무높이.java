package d2;

import java.io.*;
import java.util.*;

public class S_나무높이 {

    static int N, day, maxHeight;
    static int[] treeArr;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            process();

            sb.append("#").append(tc).append(" ").append(day).append("\n");
        }

        System.out.println(sb);
    }

    static void process() {
        for (int i = treeArr.length - 2; i >= 0; i--) {
            while (treeArr[i] != maxHeight) {
                day++;

                if (maxHeight - treeArr[i] == 1) {
                    if (day % 2 != 0) {
                        treeArr[i] += 1;
                    } else {
                        for (int j = i - 1; j >= 0; j--) {
                            if (treeArr[j] <= maxHeight - 2) {
                                treeArr[j] += 2;
                                break;
                            }
                        }
                    }
                } else if (maxHeight - treeArr[i] == 2) {
                    if (day % 2 != 0) {
                        for (int j = i - 1; j >= 0; j--) {
                            if (treeArr[j] <= maxHeight - 1) {
                                treeArr[j] += 1;
                                break;
                            }
                        }
                    } else {
                        treeArr[i] += 2;
                    }
                } else {
                    if (day % 2 != 0) {
                        treeArr[i] += 1;
                    } else {
                        treeArr[i] += 2;
                    }
                }
            }
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        treeArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            treeArr[i] = Integer.parseInt(st.nextToken());
        }

        day = 0;
        Arrays.sort(treeArr);
        maxHeight = treeArr[treeArr.length - 1];
    }
}
