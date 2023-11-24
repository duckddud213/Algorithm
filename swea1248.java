import java.io.*;
import java.util.*;

public class swea1248 {
    static int x, T, V, E, src, dest, root, size, height;
    static BufferedReader br;
    static StringTokenizer st;
    static int parent[][]; // �ش� �ε��� ����� 2^k��° ���� ����� ��ȣ
    static int depth[]; // �ش� �ε��� ����� ���� ����
    static Node nodeInfo[];
    static boolean isVisited[]; // �ش� �ε��� ��� �湮 ���� ����
    static Deque<Integer> que;
    static StringBuilder sb;

    public static void checkSize() {
        int next;
        size = 0;
        que.add(root);

        while (!que.isEmpty()) {
            next = que.pollFirst();
            size++;
            if (nodeInfo[next].cl != 0) {
                que.add(nodeInfo[next].cl);
            }
            if (nodeInfo[next].cr != 0) {
                que.add(nodeInfo[next].cr);
            }
        }
    }

    public static void parentDepth() {
        int i, j;

        for (i = 1; i < height; i++) {
            for (j = 1; j <= V; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
    }

    public static int LCA() {
        int i, tmp;

        if (depth[src] < depth[dest]) {
            tmp = src;
            src = dest;
            dest = tmp;
        }

        for (i = height - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[src] - depth[dest]) {
                src = parent[src][i];
            }
        }

        if (src == dest) { // �� ��尡 �ٸ� ����� �θ������
            return src;
        }

        for (i = height - 1; i >= 0; i--) {
            if (parent[src][i] != parent[dest][i]) {
                src = parent[src][i];
                dest = parent[dest][i];
            }
        }

        return parent[src][0];
    }

    public static void dfs(int nodeNum) {
        int i;
        if (nodeInfo[nodeNum].cl != 0 && !isVisited[nodeInfo[nodeNum].cl]) {
            isVisited[nodeInfo[nodeNum].cl] = true;
            depth[nodeInfo[nodeNum].cl] = depth[nodeNum] + 1;
            parent[nodeInfo[nodeNum].cl][0] = nodeNum;
            dfs(nodeInfo[nodeNum].cl);
        }
        if (nodeInfo[nodeNum].cr != 0 && !isVisited[nodeInfo[nodeNum].cr]) {
            isVisited[nodeInfo[nodeNum].cr] = true;
            depth[nodeInfo[nodeNum].cr] = depth[nodeNum] + 1;
            parent[nodeInfo[nodeNum].cr][0] = nodeNum;
            dfs(nodeInfo[nodeNum].cr);
        }
    }

    public static void pre() throws IOException {
        int a, b;
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        src = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());
        height = 17;

        nodeInfo = new Node[V + 1];
        depth = new int[V + 1];
        parent = new int[V + 1][height];
        isVisited = new boolean[V + 1];
        que = new ArrayDeque<>();

        for (int i = 0; i <= V; i++) {
            nodeInfo[i] = new Node();
        }

        st = new StringTokenizer(br.readLine());
        // Scanner sc = new Scanner(System.in);

        for (int i = 0; i < E; i++) {
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            // a = sc.nextInt();
            // b = sc.nextInt();
            nodeInfo[b].p = a;
            if (nodeInfo[a].cl != 0) {
                nodeInfo[a].cr = b;
            } else {
                nodeInfo[a].cl = b;
            }
        }
        depth[1] = 0;
        isVisited[1] = true;
        size = 0;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (x = 1; x <= T; x++) {
            pre();
            dfs(1);
            parentDepth();
            root = LCA();
            checkSize();
            sb.append("#").append(x).append(" ").append(root).append(" ").append(size).append('\n');
        }
        System.out.println(sb);
    }

    static class Node {
        int p, cl, cr;
    }
}