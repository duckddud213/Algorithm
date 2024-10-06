import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result;
    static int map[][], office[][];
    static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int dir2[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    static List<Pos> cctv;

    public static int checkDeadZone() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void observing(List<CCTV> list) {
        map = new int[N][M];

        for(int i =0;i<N;i++){
            map[i] = office[i].clone();
        }

        for (CCTV cur : list) {
            int w = cur.way;
            Pos p = cur.p;

            if (p.num == 1) {
                int tmp = 0;

                while (true) {
                    int dx = p.r + (dir[w - 1][0] * tmp);
                    int dy = p.c + (dir[w - 1][1] * tmp);

                    if (!canMove(dx, dy)) {
                        break;
                    }

                    map[dx][dy] = -1;

                    tmp++;
                }
            }
            else if (p.num == 2) {
                if (w == 1) {
                    for (int idx = 0; idx < 2; idx++) {
                        int tmp = 0;
                        while (true) {
                            int dx = p.r + (dir[idx][0] * tmp);
                            int dy = p.c + (dir[idx][1] * tmp);

                            if (!canMove(dx, dy)) {
                                break;
                            }

                            map[dx][dy] = -1;

                            tmp++;
                        }
                    }
                }
                else {
                    for (int idx = 2; idx < 4; idx++) {
                        int tmp = 0;
                        while (true) {
                            int dx = p.r + (dir[idx][0] * tmp);
                            int dy = p.c + (dir[idx][1] * tmp);

                            if (!canMove(dx, dy)) {
                                break;
                            }

                            map[dx][dy] = -1;

                            tmp++;
                        }
                    }
                }
            }
            else if (p.num == 3) {
                for (int idx = w - 1; idx <= w; idx++) {
                    int tmp = 0;
                    while (true) {
                        int dx = p.r + (dir2[idx % 4][0] * tmp);
                        int dy = p.c + (dir2[idx % 4][1] * tmp);

                        if (!canMove(dx, dy)) {
                            break;
                        }

                        map[dx][dy] = -1;

                        tmp++;
                    }
                }
            }
            else if (p.num == 4) {
                for (int idx = 0; idx < 4; idx++) {
                    if (idx == w - 1) {
                        continue;
                    }

                    int tmp = 0;
                    while (true) {
                        int dx = p.r + (dir[idx][0] * tmp);
                        int dy = p.c + (dir[idx][1] * tmp);

                        if (!canMove(dx, dy)) {
                            break;
                        }

                        map[dx][dy] = -1;

                        tmp++;
                    }
                }
            }
            else {
                for (int idx = 0; idx < 4; idx++) {
                    int tmp = 0;
                    while (true) {
                        int dx = p.r + (dir[idx][0] * tmp);
                        int dy = p.c + (dir[idx][1] * tmp);

                        if (!canMove(dx, dy)) {
                            break;
                        }

                        map[dx][dy] = -1;

                        tmp++;
                    }
                }
            }
        }
    }

    public static boolean canMove(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6;
    }

    public static void backtracking(List<CCTV> list, int idx, int depth) {
        if (depth == cctv.size()) {
            observing(list);
            result = Math.min(result, checkDeadZone());
            return;
        }

        for (int i = idx; i < cctv.size(); i++) {
            int num = cctv.get(i).num;

            if (num == 5) {
                // 5번 CCTV는 경우의 수가 하나
                list.add(new CCTV(cctv.get(i), 1));
                backtracking(list, i + 1, depth + 1);
                list.remove(list.size() - 1);
            }
            else if (num == 2) {
                // 2번 CCTV는 경우의 수가 둘
                for (int j = 1; j <= 2; j++) {
                    list.add(new CCTV(cctv.get(i), j));
                    backtracking(list, i + 1, depth + 1);
                    list.remove(list.size() - 1);
                }
            }
            else {
                // 나머지는 경우의 수가 네가지
                for (int j = 1; j <= 4; j++) {
                    list.add(new CCTV(cctv.get(i), j));
                    backtracking(list, i + 1, depth + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        office = new int[N][M];
        map = new int[N][M];
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctv.add(new Pos(i, j, office[i][j]));
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        backtracking(new ArrayList<>(), 0, 0);
        System.out.println(result);
    }

    static class Pos {
        int r, c, num;

        public Pos(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }

    static class CCTV {
        Pos p;
        int way;

        public CCTV(Pos p, int way) {
            this.p = p;
            this.way = way;
        }
    }
}