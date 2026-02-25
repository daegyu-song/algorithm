package silver.iv;

import java.io.*;

public class B_1065_한수 {

    static int N;
    static int[] arr;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(arr[N]);
    }

    static void process() {
        for (int i = 1; i <= 99; i++) {
            arr[i] = arr[i - 1] + 1;
        }

        for (int i = 100; i <= 999; i++) {
            if (check(String.valueOf(i))) arr[i] = arr[i - 1] + 1;
            else arr[i] = arr[i - 1];
        }

        arr[1000] = arr[999];
    }

    static boolean check(String str) {

        int a = str.charAt(0) - '0';
        int b = str.charAt(1) - '0';
        int c = str.charAt(2) - '0';

        return b - a == c - b;
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[1001];
    }
}