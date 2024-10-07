import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result;
    static int map[][];
    static int dir[][] = { { 0, 0 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, {1, -1 } };
    static boolean isMadeBefore[][];
    static List<Command> list;
    static Deque<Pos> cloud;
    static Deque<Pos> movedCloud;

    public static void moveCloud(int d, int s) {
        isMadeBefore = new boolean[N + 1][N + 1];

        while (!cloud.isEmpty()) {
            Pos cur = cloud.poll();
            int dx = relocator(cur.x + (dir[d][0] * s));
            int dy = relocator(cur.y + (dir[d][1] * s));
            
            map[dx][dy]++;
            isMadeBefore[dx][dy] = true;
            movedCloud.add(new Pos(dx, dy));
        }

        cloud.clear();
    }

    public static int relocator(int num) {
        if (num < 1) {
            return N - (Math.abs(num) % N);
        }
        else {
            return (num - 1) % N + 1;
        }
    }

    public static void waterCopy() {
        List<Pos> clist = new ArrayList<>();
        while (!movedCloud.isEmpty()) {
            Pos cur = movedCloud.poll();
            int cnt = 0;
            for (int idx = 2; idx <= 8; idx += 2) {
                int dx = cur.x + dir[idx][0];
                int dy = cur.y + dir[idx][1];

                if (canAbsorb(dx, dy)) {
                    cnt++;
                }
            }

            clist.add(new Pos(cur.x,cur.y,cnt));
        }
        movedCloud.clear();

        for(Pos cur : clist){
            map[cur.x][cur.y] += cur.cnt;
        }
    }

    public static boolean canAbsorb(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= N && map[x][y] > 0;
    }

    public static void makeCloud() {

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] >= 2 && !isMadeBefore[i][j]) {
                    map[i][j] -= 2;
                    cloud.add(new Pos(i, j));
                }
            }
        }
    }

    public static void magic() {
        for (Command next : list) {
            moveCloud(next.d, next.s);
            waterCopy();
            makeCloud();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += map[i][j];
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;

        map = new int[N + 1][N + 1];
        list = new ArrayList<>();
        cloud = new ArrayDeque<>();
        movedCloud = new ArrayDeque<>();

        cloud.add(new Pos(N, 1));
        cloud.add(new Pos(N, 2));
        cloud.add(new Pos(N - 1, 1));
        cloud.add(new Pos(N - 1, 2));

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.add(new Command(d, s));
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        magic();
        System.out.println(result);
    }

    static class Command {
        int d, s;

        public Command(int d, int s) {
            this.d = d;
            this.s = s;
        }
    }

    static class Pos {
        int x, y, cnt;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
            this.cnt = 0;
        }

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}