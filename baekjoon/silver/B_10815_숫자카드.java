package silver;

import java.util.Arrays;
import java.util.Scanner;

public class B_10815_숫자카드 {

    static int N, M;
    static int[] nArr, mArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        init();
        process();
        System.out.println(sb);
    }

    static void process() {
        Arrays.sort(nArr);

        for (int i = 0; i < M; i++) {
            if (check(mArr[i])) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append(" ");
        }
    }

    static boolean check(int target) {
        int left = 0, right = nArr.length - 1, mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (target > nArr[mid]) left = mid + 1;
            else if (target < nArr[mid]) right = mid - 1;
            else return true;
        }
        return false;
    }

    static void init() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nArr = new int[N];
        for (int i = 0; i < N; i++) {
            nArr[i] = sc.nextInt();
        }

        M = sc.nextInt();
        mArr = new int[M];
        for (int i = 0; i < M; i++) {
            mArr[i] = sc.nextInt();
        }
    }
}
