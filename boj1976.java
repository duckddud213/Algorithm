import java.io.*;
import java.util.*;

public class boj1976 {
    static int N, M;
    static int road[][];
    static int parent[];
    static boolean result;

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        if (x < y) {
            parent[y] = x;
        } 
        else {
            parent[x] = y;
        }
        union(find(x), find(y));
    }

    public static int find(int x) {
        if (x != parent[x]) {
            return parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public static boolean isUnion(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry) {
            return true;
        }
        return false;
    }

    public static void pre() throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        road = new int[N + 1][N + 1];
        parent = new int[N + 1];
        result = true;

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                road[i][j] = Integer.parseInt(st.nextToken());
                if (road[i][j] == 1) { // 길이 있고 루트노드가 다른 경우
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int pNum = Integer.parseInt(st.nextToken());
        // System.out.print(parent[pNum] + " ");
        int tmp;
        for (int i = 2; i <= M; i++) {
            tmp = Integer.parseInt(st.nextToken());
            // System.out.print(parent[tmp] + " ");
            result = isUnion(pNum, tmp);
            if (!result) {
                break;
            }
        }
        // System.out.println();
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(result ? "YES" : "NO");
    }
}
