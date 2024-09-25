import java.io.*;
import java.util.*;

public class Main {
    static int result;
    static boolean flag;
    static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static char map[][];
    static List<Pos> list;
    static Deque<Pos> que;

    public static void falling() {
        for (int j = 0; j < 6; j++) {
            Deque<Character> deq = new ArrayDeque<>();
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] != '.') {
                    deq.add(map[i][j]);
                }
            }

            int size = deq.size();
            for (int i = 11; i > 11 - size; i--) {
                map[i][j] = deq.poll();
            }

            for (int i = 0; i < 12 - size; i++) {
                map[i][j] = '.';
            }
        }
    }

    public static void bfs() {
        flag = false;
        boolean isVisited[][] = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] == '.' || isVisited[i][j]) {
                    continue;
                }

                char c = map[i][j];
                isVisited[i][j] = true;
                list = new ArrayList<>();
                que = new ArrayDeque<>();
                list.add(new Pos(i, j));
                que.add(new Pos(i, j));

                while (!que.isEmpty()) {
                    Pos cur = que.poll();

                    for (int idx = 0; idx < 4; idx++) {
                        int dr = cur.r + dir[idx][0];
                        int dc = cur.c + dir[idx][1];

                        if (isValid(dr, dc) && !isVisited[dr][dc] && c == map[dr][dc]) {
                            que.add(new Pos(dr, dc));
                            list.add(new Pos(dr, dc));
                            isVisited[dr][dc] = true;
                        }
                    }
                }

                if (list.size() >= 4) {
                    flag = true;

                    for (Pos next : list) {
                        map[next.r][next.c] = '.';
                    }
                }
            }
        }
    }

    public static void play() {
        while (true) {
            bfs();
            if (!flag) {
                break;
            }
            falling();
            result++;
        }
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < 12 && c >= 0 && c < 6;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        result = 0;
        flag = false;
        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String input = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = input.charAt(j);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        play();
        System.out.println(result);
    }

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}