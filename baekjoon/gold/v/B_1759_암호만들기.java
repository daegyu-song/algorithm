package gold.v;

import java.io.*;
import java.util.*;

public class B_1759_암호만들기 {

    static int L, C;
    static char[] cArr, currentArr;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process(0, 0);

        System.out.println(sb);
    }

    static void process(int idx, int start) {
        if (idx == L) {
            if (!isAvailable()) return;

            for (char c : currentArr) {
                sb.append(c);
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i < C; i++) {
            currentArr[idx] = cArr[i];
            process(idx + 1, i + 1);
        }
    }

    static boolean isAvailable() {
        int cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < currentArr.length; i++) {
            if (currentArr[i] == 'a' || currentArr[i] == 'i' || currentArr[i] == 'e' || currentArr[i] == 'o' || currentArr[i] == 'u') cnt1++;
            else cnt2++;

            if (cnt1 >= 1 && cnt2 >= 2) return true;
        }

        return false;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cArr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(cArr);

        currentArr = new char[L];
    }
}
