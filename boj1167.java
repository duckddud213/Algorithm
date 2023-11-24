import java.io.*;
import java.util.*;

public class boj1167 {
    static int V, nodeNum, len;
    static ArrayList<Node>[] tree;
    static boolean isVisited[];

    public static void dfs(int node, int length) {

        if (len < length) {
            nodeNum = node;
            len = length;
        }
        isVisited[node] = true;

        for (Node next : tree[node]) {
            if (!isVisited[next.dest]) {
                dfs(next.dest, length + next.weight);
                isVisited[next.dest] = false;
            }
        }
    }

    public static void pre() throws IOException {
        int inputV, inputW,num;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());

        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            tree[num] = new ArrayList<>();
            inputV = Integer.parseInt(st.nextToken());
            while (inputV != -1) {
                inputW = Integer.parseInt(st.nextToken());
                tree[num].add(new Node(inputV, inputW));
                inputV = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();

        len = Integer.MIN_VALUE;
        isVisited = new boolean[V + 1];
        dfs(1, 0);

        len = Integer.MIN_VALUE;
        isVisited = new boolean[V + 1];
        dfs(nodeNum, 0);

        System.out.println(len);
    }

    static class Node implements Comparable<Node> {
        int dest, weight;

        public Node() {
        }

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return o.weight - this.weight;
        }
    }
}
