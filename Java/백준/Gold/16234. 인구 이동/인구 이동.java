import java.io.*;
import java.util.*;

public class Main {
    public static int n, l, r, ans;
    public static int map[][];
    public static int visited[][];
    public static int dx[] = { -1, 1, 0, 0 };
    public static int dy[] = { 0, 0, -1, 1 };

    public static int bfs(boolean[][] visited, int x, int y) {
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> q2 = new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new Node(x, y));
        q2.add(new Node(x, y));

        int cnt = 1;
        int sum = map[x][y];
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visited[nx][ny]) {
                        int diff = Math.abs(map[node.x][node.y] - map[nx][ny]);
                        if (diff >= l && diff <= r) {
                            cnt++;
                            sum += map[nx][ny];
                            visited[nx][ny] = true;
                            q.add(new Node(nx, ny));
                            q2.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }

        if (cnt == 1) {
            return 0;
        }
        else {
            while (!q2.isEmpty()) {
                Node node = q2.poll();
                map[node.x][node.y] = sum / cnt;
            }
        }
        return cnt;
    }

    public static void checkMoved() {
        while (true) {
            boolean check = false;
            boolean[][] visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int change = bfs(visited, i, j);
                        if (change >= 2) {
                            check = true;
                        }
                    }
                }
            }
            if (!check) {
                break;
            }

            ans++;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        ans = 0;
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    public static void main(String[] args) throws IOException {
        pre();
        checkMoved();
        System.out.println(ans);
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}