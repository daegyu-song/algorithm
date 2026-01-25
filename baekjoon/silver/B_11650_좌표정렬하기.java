package silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B_11650_좌표정렬하기 {

    static int N;
    static List<Coordinate> list = new ArrayList<>();

    public static void main(String[] args) {
        init();
        process();
        for (Coordinate c : list) {
            System.out.println(c.x + " " + c.y);
        }
    }

    static void process() {
        list.sort((o1, o2) ->
                o1.x == o2.x ? Integer.compare(o1.y, o2.y) : Integer.compare(o1.x, o2.x));
    }

    static void init() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            list.add(new Coordinate(sc.nextInt(), sc.nextInt()));
        }
    }
}
