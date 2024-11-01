import java.io.*;
import java.util.*;

public class Main {
    static int result, cnt;
    static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static char std[][];
    static boolean check[][];
    static List<Pos> list;

    public static void checkDasomFour(TreeSet<Integer> hset) {
        check = new boolean[5][5];
        list = new ArrayList<>();

        cnt = 0;
        for (int num : hset) {
            changeNumToIndex(num);
        }

        if (cnt < 4) {
            return;
        }

        checkNearby();
    }

    public static void checkNearby() {
        Deque<Pos> que = new ArrayDeque<>();

        que.add(list.get(0));

        cnt = 0;
        boolean isVisited[][] = new boolean[5][5];
        while (!que.isEmpty()) {
            Pos cur = que.poll();

            if (isVisited[cur.x][cur.y]) {
                continue;
            }

            isVisited[cur.x][cur.y] = true;
            cnt++;

            for (int idx = 0; idx < 4; idx++) {
                int dx = cur.x + dir[idx][0];
                int dy = cur.y + dir[idx][1];

                if (isValid(dx, dy) && check[dx][dy]) {
                    que.add(new Pos(dx, dy));
                }
            }
        }

        if (cnt == 7) {
            result++;
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    public static void changeNumToIndex(int num) {
        int div = (num - 1) / 5;
        int rem = (num - 1) % 5;

        check[div][rem] = true;
        if (std[div][rem] == 'S') {
            cnt++;
        }
        list.add(new Pos(div, rem));
    }

    public static void combine(int idx, int depth, TreeSet<Integer> hset) {
        if (depth == 7) {
            checkDasomFour(hset);
            return;
        }

        for (int num = idx + 1; num <= 25; num++) {
            hset.add(num);
            combine(num, depth + 1, hset);
            hset.remove(num);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        result = 0;
        std = new char[5][5];

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5; j++) {
                std[i][j] = input.charAt(j);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        combine(0, 0, new TreeSet<>());
        System.out.println(result);
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}