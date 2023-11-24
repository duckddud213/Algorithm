import java.io.*;
import java.util.*;

public class boj1197 {
    static int V, E,sum;
    static ArrayList<Node> tree;
    static int parent[];

    public static void Kruskal() {
        int i;

        for (i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (Node n : tree) {
            if (isUnion(n.src, n.dest)) {
                sum += n.cost;
            }
        }

    }
    
    public static boolean isUnion(int src, int dest) {
        int srcRoot = findSet(src);
        int destRoot = findSet(dest);

        if (srcRoot == destRoot) {
            return false;
        }
        else {
            parent[destRoot] = srcRoot;
        }

        return true;
    }
    
    public static int findSet(int v) {
        if (parent[v] != v) {
            parent[v] = findSet(parent[v]);
        }
        return parent[v];
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        sum = 0;

        parent = new int[V + 1];
        tree = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            tree.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        Collections.sort(tree);
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        Kruskal();
        System.out.println(sum);
    }

    static class Node implements Comparable<Node> {
        int src, dest, cost;

        public Node() {
        }

        public Node(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
