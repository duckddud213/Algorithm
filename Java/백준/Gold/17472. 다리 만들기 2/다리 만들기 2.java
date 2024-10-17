import java.io.*;
import java.util.*;

public class Main {
    static int N, M, num, result, dist;
    static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int map[][], group[][];
    static HashMap<Integer, Integer> road[];
    static Deque<Pos> que;
    static HashMap<Integer, Pos> ghead;
    static PriorityQueue<Node> pq;
    static HashSet<Integer> hset;

    public static void Prims() {
        // MST로 최단거리

        for (int i = 1; i < num; i++) {
            int d = road[1].getOrDefault(i, Integer.MAX_VALUE);

            pq.add(new Node(1, i, d));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (hset.size() == num - 1) {
                break;
            }

            if ((hset.contains(cur.src) && hset.contains(cur.dest)) || (cur.dist == Integer.MAX_VALUE)) {
                continue;
            }

            dist += cur.dist;
            hset.add(cur.src);
            hset.add(cur.dest);

            for (int i = 1; i < num; i++) {
                int d = road[cur.dest].getOrDefault(i, Integer.MAX_VALUE);

                pq.add(new Node(cur.dest, i, d));
            }
        }

        if (hset.size() != num - 1) {
            dist = -1;
        }
    }

    public static void buildBridge() {
        // 각 섬에서 각각의 섬으로 가는 최단 거리 구한 뒤 프림 알고리즘으로 MST 적용
        // 다리 거리는 최소 2이상

        for (int i = 1; i < num; i++) {
            Pos now = ghead.get(i);
            que = new ArrayDeque<>();
            que.add(now);
            boolean isVisited[][] = new boolean[N][M];

            while (!que.isEmpty()) {
                Pos cur = que.poll();

                if (isVisited[cur.x][cur.y]) {
                    continue;
                }

                isVisited[cur.x][cur.y] = true;

                // 섬의 각 위치에서 연결가능한 다리길이 확인
                for (int idx = 0; idx < 4; idx++) {
                    for (int mul = 1;; mul++) {
                        int nx = cur.x + (dir[idx][0] * mul);
                        int ny = cur.y + (dir[idx][1] * mul);

                        if (!isValid(nx, ny) || group[nx][ny] == i) {
                            // 갈 수 없는 곳이거나 같은 섬 내부 일경우
                            break;
                        }

                        if (map[nx][ny] == 1 && group[nx][ny] != i) {
                            // 다른 섬 도달 시
                            mul--;
                            if (mul >= 2) {
                                int gnum = group[nx][ny];
                                road[i].put(gnum, Integer.min(mul, road[i].getOrDefault(gnum, Integer.MAX_VALUE)));
                            }
                            break;
                        }
                    }
                }

                // 섬의 다른 위치로 이동
                for (int idx = 0; idx < 4; idx++) {
                    int dx = cur.x + dir[idx][0];
                    int dy = cur.y + dir[idx][1];

                    if (isValid(dx, dy) && !isVisited[dx][dy] && group[dx][dy] == i) {
                        que.add(new Pos(dx, dy));
                    }
                }
            }
        }
    }

    public static void grouping() {
        // 각각의 섬 그룹으로 구분

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 || group[i][j] != 0) {
                    continue;
                }

                ghead.put(num, new Pos(i, j));
                que = new ArrayDeque<>();
                que.add(new Pos(i, j));
                boolean isVisited[][] = new boolean[N][M];

                while (!que.isEmpty()) {
                    Pos cur = que.poll();

                    if (isVisited[cur.x][cur.y]) {
                        continue;
                    }

                    isVisited[cur.x][cur.y] = true;
                    group[cur.x][cur.y] = num;

                    for (int idx = 0; idx < 4; idx++) {
                        int dx = cur.x + dir[idx][0];
                        int dy = cur.y + dir[idx][1];

                        if (isValid(dx, dy) && map[dx][dy] == 1) {
                            que.add(new Pos(dx, dy));
                        }
                    }
                }

                num++;
            }
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = 1;
        dist = 0;

        map = new int[N][M];
        group = new int[N][M];
        road = new HashMap[7];
        ghead = new HashMap<>();
        hset = new HashSet<>();
        pq = new PriorityQueue<>();

        for(int i = 0;i<7;i++){
            road[i] = new HashMap<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        grouping();
        buildBridge();
        Prims();
        System.out.println(dist);
    }

    static class Node implements Comparable<Node> {
        int src, dest, dist;

        public Node(int src, int dest, int dist) {
            this.src = src;
            this.dest = dest;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}