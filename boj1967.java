import java.io.*;
import java.util.*;

public class boj1967 {
    static int N,len,nodeNum;
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
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[10001];
        for (int i = 1; i <= 10000; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            inputV = Integer.parseInt(st.nextToken());
            inputW = Integer.parseInt(st.nextToken());
            tree[num].add(new Node(inputV, inputW));
            tree[inputV].add(new Node(num, inputW));
        }
    }

    public static void main(String args[]) throws IOException {
        pre();

        len = Integer.MIN_VALUE;
        isVisited = new boolean[N + 1];
        dfs(1, 0);

        len = Integer.MIN_VALUE;
        isVisited = new boolean[N + 1];
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
